package com.niit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.niit.entity.UserPNR;

public interface PNRRepository extends JpaRepository<UserPNR, Long>{
	@Query("FROM UserPNR WHERE pnr = ?1")
	UserPNR getByPNR(String pnr);
	
}
