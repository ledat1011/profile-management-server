package com.example.commclient.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.commclient.common.BaseResource;
import com.example.commclient.service.CreditProfileService;
import com.example.dataservice.entity.CreditProfileEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/profile")
public class CreditProfileResource extends BaseResource {
	@Autowired
	CreditProfileService profileService;

	@Autowired
	ObjectMapper mapper;

	@Autowired
	private ProducerTemplate producerTemplate;

	@RequestMapping("/get-all")
	public List<CreditProfileEntity> getAll() {
		return profileService.getAll();
	}

	@RequestMapping("/get-all-by-apache")
	public String getAllByApace() {
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Content-Type", "application/xml");
		String response = (String) producerTemplate.requestBodyAndHeaders("direct:startGetAllByApache", null, headers);
		return response;
	}

	@RequestMapping("/get")
	public CreditProfileEntity getById(@RequestParam(name = "id") Integer id) {
		return profileService.getById(id);
	}

	@PostMapping("/delete")
	public ResponseEntity<Boolean> deleteById(@RequestBody List<Integer> ids) {
		return ResponseEntity.ok(profileService.deleteById(ids));
	}
}
