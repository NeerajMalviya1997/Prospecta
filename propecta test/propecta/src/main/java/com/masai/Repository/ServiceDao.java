package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.masai.model.Services;

public interface ServiceDao extends JpaRepository<Services, Integer>{
	public Optional<Services> findByTitle(String title);
}
