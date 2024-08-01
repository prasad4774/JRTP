package com.example.jrtp.excee;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.example.jrtp.entity.CitizenPlan;

@Component
public class Excelgenerato {
	
	

	public boolean generateExcel(HttpServletResponse response , List<CitizenPlan> recoder , File f) throws Exception
	{
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Citizen_Plans");
		      Row headerrow = sheet.createRow(0);
		      
		      headerrow.createCell(0).setCellValue("ID");
		      headerrow.createCell(1).setCellValue("citizenName");
		      headerrow.createCell(2).setCellValue("gender");
		      headerrow.createCell(3).setCellValue("planName");
		      headerrow.createCell(4).setCellValue("planStatus");
		      headerrow.createCell(5).setCellValue("planStartDate");
		      headerrow.createCell(6).setCellValue("planEndDate");
		      headerrow.createCell(7).setCellValue("benefitAmt");
		     
		      
		      
		      int count =1;
		      
		      for(CitizenPlan plans :recoder )
		      {
		    	             Row dataRow = sheet.createRow(count);
		    	             
		    	             dataRow.createCell(0).setCellValue(plans.getCitizenId());
		    	             dataRow.createCell(1).setCellValue(plans.getCitizenName());
		    	             dataRow.createCell(2).setCellValue(plans.getGender());
		    	             dataRow.createCell(3).setCellValue(plans.getPlanName());
		    	             dataRow.createCell(4).setCellValue(plans.getPlanStatus());
		    	             if(plans.getPlanStartDate()!=null)
		    	             {
		    	             dataRow.createCell(5).setCellValue(plans.getPlanStartDate()+"");
		    	             }
		    	             else {
		    	            	 dataRow.createCell(5).setCellValue("N/A");
		    	             }
		    	             
		    	             if(plans.getPlanEndDate()!=null)
		    	             {
		    	            	 dataRow.createCell(6).setCellValue(plans.getPlanEndDate()+""); 
		    	             }
		    	             else {
		    	            	 dataRow.createCell(6).setCellValue("N/A");
		    	             }
		    	             
		    	             if(plans.getBenefitAmt()!=null)
		    	             {
		    	             dataRow.createCell(7).setCellValue(plans.getBenefitAmt());  
		    	             }
		    	             else {
		    	            	 dataRow.createCell(7).setCellValue("N/A");  
		    	             }
		    	  
		    	  count++;
		      }
		      
		      FileOutputStream fos= new FileOutputStream(f);
		      workbook.write(fos);
		      fos.close();
		      
		      ServletOutputStream outputStream = response.getOutputStream();
		      
		      workbook.write(outputStream);
		      workbook.close();

		return true;
	}
	
	
	
	
}
