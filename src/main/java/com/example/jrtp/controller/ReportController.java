package com.example.jrtp.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.jrtp.entity.CitizenPlan;
import com.example.jrtp.searchReq.SearchRequest;
import com.example.jrtp.serviceinterface.ReportService;



@Controller
public class ReportController {
	
	
	@Autowired
	private  ReportService reportService;
	
	
	
	@GetMapping("/pdf")
	public void exportPdf(HttpServletResponse response)throws Exception
	{
		
		response.setContentType("application/pdf");
		
		response.addHeader("content-Disposition", "attachment;filename=Citizen_Plan_Name.pdf");
		reportService.sendPdf(response);
		
	}
	
	
	
	@GetMapping("/excel")
	public void exportExcel(HttpServletResponse response) throws Exception
	{
		response.setContentType("application/octet-stream");
		response.addHeader("content-Disposition", "attachment;filename=Citizen_Plan_Name.xls");
		
		reportService.sendExcel(response);
		
	}
	
	
	
	
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search")  SearchRequest request, Model model)
	{
		List<CitizenPlan> searc = reportService.search(request);
		model.addAttribute("plans", searc);
		
		System.out.println(searc);
		
		init(model);
		return "index";
	}
	
	
	
	@GetMapping("/")
	public String indexpage(Model model)
	{
		SearchRequest searchobj  = new SearchRequest();
		
		model.addAttribute("search", searchobj);
//		model.addAttribute("names", reportService.getPlanName());
//		model.addAttribute("status", reportService.getPlanStatus());
		
		init(model);
		return "index";
	}

	
	private void init(Model model)
	{
		
//         SearchRequest searchobj  = new SearchRequest();
//		
//		model.addAttribute("search", searchobj);
		model.addAttribute("names", reportService.getPlanName());
		model.addAttribute("status", reportService.getPlanStatus());
	}
	
}
