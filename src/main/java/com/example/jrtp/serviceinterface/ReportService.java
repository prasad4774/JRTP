package com.example.jrtp.serviceinterface;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.example.jrtp.entity.CitizenPlan;
import com.example.jrtp.searchReq.SearchRequest;

public interface ReportService {

	
	
	
	public List<String> getPlanName();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean sendExcel(HttpServletResponse response) throws Exception;
	
	public boolean sendPdf(HttpServletResponse response) throws Exception;

	
}
