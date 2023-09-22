package com.example.scheduleservice.mail;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.dataservice.entity.CreditProfileEntity;
import com.example.dataservice.repository.CreditProfileRepository;
import com.example.scheduleservice.common.BaseService;

@Service
public class MailScheduleService extends BaseService {
	private static final Logger logger = LoggerFactory.getLogger(MailScheduleService.class);

	@Autowired
	MailService mailService;

	@Autowired
	CreditProfileRepository creditProfileRepository;

	@Scheduled(cron = "#{@getMailScheduleCron}")
	public void sendMailSchedule() {
		Date currentDate = new Date();
		LocalDate today = LocalDate.now();
		List<CreditProfileEntity> listProfile = creditProfileRepository.findAll();

		List<CreditProfileEntity> listNearDL = this.listProfileNearDealine(listProfile);
		List<CreditProfileEntity> listDL = creditProfileRepository.findAllPastPaymentDeadline(currentDate);
		// send notification to list near deadline
		if (listNearDL != null && !listNearDL.isEmpty()) {
			listNearDL.parallelStream().forEach(v -> {
				Integer remainDay = getTimeRemain(today,
						v.getPaymentDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
				mailService.sendEmail(v.getEmail(), "[Profile management] Payment due soon",
						"You are"+ remainDay + " day(s) overdue to pay the amount of" + v.getTotalAssets());
			});
		}
		// send notification to list deadline
		if (listDL != null && !listDL.isEmpty()) {
			listDL.parallelStream().forEach(v -> {
				Integer remainDay = getTimeRemain(
						v.getPaymentDeadline().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), today);
				mailService.sendEmail(v.getEmail(), "[Profile management] Payment is past due",
						remainDay + " day(s) left to pay the amount of" + v.getTotalAssets());
			});
		}
	}

	private List<CreditProfileEntity> listProfileNearDealine(List<CreditProfileEntity> listProfile) {

		LocalDate today = LocalDate.now();
		LocalDate fifteenDaysAgo = today.minusDays(15);
		List<CreditProfileEntity> listProfileNearDeadline = listProfile.stream().filter(profile -> {
			if (profile.getPaymentDeadline() != null) {
				LocalDate deadline = profile.getPaymentDeadline().toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();
				return !deadline.isBefore(fifteenDaysAgo) && deadline.isAfter(today);
			}
			return false;
		}).collect(Collectors.toList());

		return listProfileNearDeadline;
	}

	private Integer getTimeRemain(LocalDate dateFrom, LocalDate dateTo) {
		return Period.between(dateFrom, dateTo).getDays();
	}

}
