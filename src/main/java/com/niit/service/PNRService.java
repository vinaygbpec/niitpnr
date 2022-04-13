package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserPNRDao;
import com.niit.entity.UserPNR;
import com.niit.repository.PNRRepository;

@Service
public class PNRService {
	@Autowired
	private PNRRepository pnrRepository;

	private final UserPNRDao userPNRDao;

	public PNRService(UserPNRDao userPNRDao) {
		super();
		this.userPNRDao = userPNRDao;
	}

	@Transactional
	public boolean addPNR(UserPNR userPNR) {

		return userPNRDao.addPNR(userPNR);

	}

	public UserPNR getPNRDetail(String pnr) {
		return pnrRepository.getByPNR(pnr);
	}
}
