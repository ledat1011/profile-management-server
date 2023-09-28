package com.example.commclient.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.commclient.common.BaseResource;
import com.example.commclient.service.CreditProfileService;
import com.example.dataservice.entity.CreditProfileEntity;

@RestController
@RequestMapping("/profile")
public class CreditProfileResource extends BaseResource{
	@Autowired
	CreditProfileService profileService;

	@RequestMapping("/get-all")
	public List<CreditProfileEntity> getAll() {
		return profileService.getAll();
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
