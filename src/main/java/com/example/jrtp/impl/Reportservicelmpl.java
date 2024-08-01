package com.example.jrtp.impl;


import java.awt.Font;
import java.io.File;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import org.springframework.stereotype.Service;

import com.example.jrtp.email.EmailUtils;
import com.example.jrtp.entity.CitizenPlan;
import com.example.jrtp.excee.Excelgenerato;
import com.example.jrtp.pdf.PdfGenerator;
import com.example.jrtp.repo.CitizenPlanRepository;
import com.example.jrtp.searchReq.SearchRequest;
import com.example.jrtp.serviceinterface.ReportService;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class Reportservicelmpl implements ReportService {

	@Autowired
	private CitizenPlanRepository citizenPlanRepository;
	
	@Autowired
	private Excelgenerato excelgenerato;

	@Autowired
	private PdfGenerator generator;
	
	@Autowired
	private EmailUtils emailUtils;
	
	
	@Override
	public List<String> getPlanName() {

		return citizenPlanRepository.getPlanName();
	}

	@Override
	public List<String> getPlanStatus() {

		return citizenPlanRepository.getplanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();

		if (request.getPlanName() != null && !"".equals(request.getPlanName())) {

			entity.setPlanName(request.getPlanName());
		}

		if (request.getPlanStatus() != null && !"".equals(request.getPlanStatus())) {

			entity.setPlanStatus(request.getPlanStatus());
		}

		if (request.getGender() != null && !"".equals(request.getGender())) {

			entity.setGender(request.getGender());
		}

		List<CitizenPlan> findAll = citizenPlanRepository.findAll(Example.of(entity));

		return findAll;
	}

	@Override
	public boolean sendExcel(HttpServletResponse response) throws Exception {
		
		List<CitizenPlan> findAll = citizenPlanRepository.findAll();
		
		File f = new File("Plans.xls");
		
		
           excelgenerato.generateExcel(response, findAll, f);
           
           
           String subject="Text mail send";
           String body ="<h1> Test</h1>";
           String to = "prasadjadhav4747@gmail.com";
           
           emailUtils.sendEmail(subject, body, to, f);
           
           f.delete();
           return true;
		
	}

	@Override
	public boolean sendPdf(HttpServletResponse response) throws Exception{
	
		List<CitizenPlan> findAll = citizenPlanRepository.findAll();
		
		File f = new File("Plans.pdf");
		
		generator.generatePdf(response, findAll, f);
		
		

        String subject="Text mail send";
        String body ="<h1> Test PDF</h1>";
        String to = "prasadjadhav4747@gmail.com";
        
        emailUtils.sendEmail(subject, body, to,f);
		
		return true;
	}



}
