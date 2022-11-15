package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serviceid;	
	private String title;
	private String description;
	private String auth;
	private String https;
	private String cors;
	private String category;
	
}