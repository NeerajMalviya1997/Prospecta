package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.masai.model.CurrentAdminSession;

@Repository
public interface AminSessionDao extends JpaRepository<CurrentAdminSession, Integer>{

 public Optional<CurrentAdminSession> findByAdminId(Integer adminId);
	
	public Optional<CurrentAdminSession> findByUuid(String uuid);
}
