package com.org.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.org.entity.CitizenPlan;
import com.org.repository.CitizenPlanRepo;

@Component
public class DataLoader implements ApplicationRunner{

	@Autowired
	private CitizenPlanRepo repo;	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		// cash plan
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Anup");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitAmount(40000.00);
		
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Laxmi");
		c2.setGender("Male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental House");
		
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Susmita");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(2));
		c3.setPlanEndDate(LocalDate.now().plusMonths(4));
		c3.setBenifitAmount(35000.00);
		c3.setTerminationReason("Employed");
		
		// food plan
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Shilpa");
		c4.setGender("Female");
		c4.setPlanName("Food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now().minusMonths(3));
		c4.setPlanEndDate(LocalDate.now().plusMonths(3));
		c4.setBenifitAmount(25000.00);
		
		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Akash");
		c5.setGender("Male");
		c5.setPlanName("Food");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Income");
		
		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Mousumi");
		c6.setGender("Female");
		c6.setPlanName("Food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(2));
		c6.setPlanEndDate(LocalDate.now().plusMonths(4));
		c6.setBenifitAmount(15000.00);
		c6.setTerminationReason("Employed");
		
		// medical plan
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Abhijit");
		c7.setGender("Male");
		c7.setPlanName("Medical");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitAmount(40000.00);
		
		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Sourav");
		c8.setGender("Male");
		c8.setPlanName("Medical");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Better Job");
		
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Barsha");
		c9.setGender("Female");
		c9.setPlanName("Medical");
		c9.setPlanStatus("Terminated");
		c9.setPlanStartDate(LocalDate.now().minusMonths(2));
		c9.setPlanEndDate(LocalDate.now().plusMonths(4));
		c9.setBenifitAmount(35000.00);
		c9.setTerminationReason("Govt Employed");
		
		// Employment  plan
		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Bidhan");
		c10.setGender("Male");
		c10.setPlanName("Employment");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifitAmount(20000.00);
		
		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Shweta");
		c11.setGender("Female");
		c11.setPlanName("Employment");
		c11.setPlanStatus("Denied");
		c11.setDenialReason("Govt Job");
		
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Sudip");
		c12.setGender("Male");
		c12.setPlanName("Employment");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now().minusMonths(2));
		c12.setPlanEndDate(LocalDate.now().plusMonths(4));
		c12.setBenifitAmount(23000.00);
		c12.setTerminationReason("Govt Employed");
		
		List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
//		repo.saveAll(list);
		
	}

}
