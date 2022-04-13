package com.niit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.entity.UserPNR;
import com.niit.service.PNRService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/v1/pnr/")
@Api(tags = "Operations On user PNR API")
public class UserPNRController {
	private final PNRService pnrService;

	public UserPNRController(PNRService pnrService) {
		super();
		this.pnrService = pnrService;
	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@PostMapping("/addpnr")
	public ResponseEntity<?> addToIntersted(@RequestBody UserPNR userPNR) {
		// leadService.addToInterested(lead, employee_id);
		boolean isInserted = pnrService.addPNR(userPNR);
		if (isInserted) {
			return ResponseEntity.ok("PNR added");
		} else {
			return ResponseEntity.ok("PNR not added");
		}

	}

	@CrossOrigin(origins = "*", maxAge = 3600)
	@GetMapping("/getpnr/{pnr}")
	ResponseEntity<UserPNR> getEmployee(@PathVariable String pnr) {
		UserPNR userPNR = pnrService.getPNRDetail(pnr);

		return new ResponseEntity<UserPNR>(userPNR, HttpStatus.OK);

	}
}
