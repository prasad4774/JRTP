package com.example.jrtp.datalodaer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.jrtp.entity.CitizenPlan;
import com.example.jrtp.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	
	@Autowired
	private CitizenPlanRepository citizenPlanRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
//
//		CitizenPlan cl = new CitizenPlan();
//
//		cl.setCitizenName("John");
//
//		cl.setGender("Male");
//
//		cl.setPlanName("Cash");
//
//		cl.setPlanStatus("Approved");
//
//		cl.setPlanStartDate(LocalDate.now());
//
//		cl.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		cl.setBenefitAmt(5000.00);
//
//		CitizenPlan c2 = new CitizenPlan();
//
//		c2.setCitizenName("Smith");
//
//		c2.setGender("Male");
//
//		c2.setPlanName("Cash");
//
//		c2.setPlanStatus("Denied");
//
//		c2.setDenialReason("Rental Income");
//
//		CitizenPlan c3 = new CitizenPlan();
//
//		c3.setCitizenName("Smith");
//
//		c3.setGender("Male");
//
//		c3.setPlanName("Cash");
//
//		c3.setPlanStatus("Terminated");
//
//		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
//
//		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		c3.setBenefitAmt(5000.00);
//
//		c3.setTerminatedDate(LocalDate.now());
//
//		c3.setTerminationRsn("Employed");
//
//		CitizenPlan c4 = new CitizenPlan();
//
//		c4.setCitizenName("seema");
//
//		c4.setGender("Female");
//
//		c4.setPlanName("Cash");
//
//		c4.setPlanStatus("Terminated");
//
//		c4.setPlanStartDate(LocalDate.now().minusMonths(4));
//
//		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		c4.setBenefitAmt(5000.00);
//
//		c4.setTerminatedDate(LocalDate.now());
//
//		c4.setTerminationRsn("Employed");
//
////		food----------------------------------------------------
//		
//		
//		
//		CitizenPlan fl = new CitizenPlan();
//
//		fl.setCitizenName("prasad");
//
//		fl.setGender("Male");
//
//		fl.setPlanName("food");
//
//		fl.setPlanStatus("Approved");
//
//		fl.setPlanStartDate(LocalDate.now());
//
//		fl.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		fl.setBenefitAmt(6000.00);
//		
//		
//		
//		CitizenPlan f2 = new CitizenPlan();
//
//		f2.setCitizenName("Ram");
//
//		f2.setGender("Male");
//
//		f2.setPlanName("food");
//
//		f2.setPlanStatus("Denied");
//
//		f2.setDenialReason("Rental Income");
//		
//		
//		CitizenPlan f3 = new CitizenPlan();
//
//		f3.setCitizenName("vijay");
//
//		f3.setGender("Male");
//
//		f3.setPlanName("food");
//
//		f3.setPlanStatus("Terminated");
//
//		f3.setPlanStartDate(LocalDate.now().minusMonths(4));
//
//		f3.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		f3.setBenefitAmt(4000.00);
//
//		f3.setTerminatedDate(LocalDate.now());
//
//		f3.setTerminationRsn("Employed");
//		
//		
//		CitizenPlan f4 = new CitizenPlan();
//
//		f4.setCitizenName("pallavi");
//
//		f4.setGender("Female");
//
//		f4.setPlanName("food");
//
//		f4.setPlanStatus("Terminated");
//
//		f4.setPlanStartDate(LocalDate.now().minusMonths(4));
//
//		f4.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		f4.setBenefitAmt(5000.00);
//
//		f4.setTerminatedDate(LocalDate.now());
//
//		f4.setTerminationRsn("Employed");
//		
////		medical-------------------------------------------------------------------
//		
//		
//		
//		CitizenPlan ml = new CitizenPlan();
//
//		ml.setCitizenName("prasad hatte");
//
//		ml.setGender("Male");
//
//		ml.setPlanName("medical");
//
//		ml.setPlanStatus("Approved");
//
//		ml.setPlanStartDate(LocalDate.now());
//
//		ml.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		ml.setBenefitAmt(6000.00);
//		
//		
//		CitizenPlan m2 = new CitizenPlan();
//
//		m2.setCitizenName("Ramu");
//
//		m2.setGender("Male");
//
//		m2.setPlanName("medical");
//
//		m2.setPlanStatus("Denied");
//
//		m2.setDenialReason("Rental Income");
//		
//		
//		CitizenPlan m3 = new CitizenPlan();
//
//		m3.setCitizenName("Ajay");
//
//		m3.setGender("Male");
//
//		m3.setPlanName("medical");
//
//		m3.setPlanStatus("Terminated");
//
//		m3.setPlanStartDate(LocalDate.now().minusMonths(4));
//
//		m3.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		m3.setBenefitAmt(4000.00);
//
//		m3.setTerminatedDate(LocalDate.now());
//
//		m3.setTerminationRsn("Gove -Employed ");
//		
//		CitizenPlan m4 = new CitizenPlan();
//
//		m4.setCitizenName("rani");
//
//		m4.setGender("Female");
//
//		m4.setPlanName("food");
//
//		m4.setPlanStatus("Terminated");
//
//		m4.setPlanStartDate(LocalDate.now().minusMonths(4));
//
//		m4.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		m4.setBenefitAmt(5000.00);
//
//		m4.setTerminatedDate(LocalDate.now());
//
//		m4.setTerminationRsn("lotery");
//		
//		
////		Employeement -----------------------------------------------------------------
//		
//		CitizenPlan el = new CitizenPlan();
//
//		el.setCitizenName("Saurabh");
//
//		el.setGender("Male");
//
//		el.setPlanName("Employeement");
//
//		el.setPlanStatus("Approved");
//
//		el.setPlanStartDate(LocalDate.now());
//
//		el.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		el.setBenefitAmt(6000.00);
//		
//		
//		
//		CitizenPlan e2 = new CitizenPlan();
//
//		e2.setCitizenName("mahesh");
//
//		e2.setGender("Male");
//
//		e2.setPlanName("Employeement");
//
//		e2.setPlanStatus("Denied");
//
//		e2.setDenialReason("Rental Income");
//		
//		
//		CitizenPlan e4 = new CitizenPlan();
//
//		e4.setCitizenName("Shri");
//
//		e4.setGender("Female");
//
//		e4.setPlanName("food");
//
//		e4.setPlanStatus("Terminated");
//
//		e4.setPlanStartDate(LocalDate.now().minusMonths(4));
//
//		e4.setPlanEndDate(LocalDate.now().plusMonths(6));
//
//		e4.setBenefitAmt(5000.00);
//
//		e4.setTerminatedDate(LocalDate.now());
//
//		e4.setTerminationRsn("Business");
//		
//		List<CitizenPlan> list = Arrays.asList( c2, cl, c3,c4,fl,f2,f3,f4,ml,m2,m3,m4,el,e2,e4);
//		
//		citizenPlanRepository.saveAll(list);

	}

}
