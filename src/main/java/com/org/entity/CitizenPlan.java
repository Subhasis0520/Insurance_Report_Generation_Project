package com.org.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CitizenPlan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CITIZEN_ID")
	private Integer citizenId; 
	
	@Column(name = "CITIZEN_NAME")
	private String citizenName;
	
	private String gender;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate; 
	private LocalDate planEndDate;
	private Double benifitAmount; 
	private String denialReason; 
	private LocalDate terminatedDate;
	private String terminationReason; 
}
