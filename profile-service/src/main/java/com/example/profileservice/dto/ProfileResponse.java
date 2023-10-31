package com.example.profileservice.dto;

import java.util.List;

import org.springframework.data.domain.PageImpl;

import com.example.dataservice.entity.CreditProfileEntity;

/**
 * The Class ProfileResponse.
 */
public class ProfileResponse extends BaseResponse {

	/** The credit profile. */
	private List<CreditProfileEntity> creditProfiles;
	
	public ProfileResponse() {}
	
	public ProfileResponse(PageImpl<CreditProfileEntity> proImpl) {
		this.creditProfiles = proImpl.getContent();
		this.total = proImpl.getTotalElements();
	}

	public List<CreditProfileEntity> getCreditProfiles() {
		return creditProfiles;
	}

	public void setCreditProfiles(List<CreditProfileEntity> creditProfiles) {
		this.creditProfiles = creditProfiles;
	}

}
