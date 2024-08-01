package com.example.jrtp.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.example.jrtp.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	
	public void generatePdf(HttpServletResponse response, List<CitizenPlan> recoder, File f) throws Exception
	{
		
Document document= new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		
		document.open();
		
		com.lowagie.text.Font fonttitle= FontFactory.getFont(FontFactory.TIMES_ROMAN);
		
		fonttitle.setSize(20);
		
		Paragraph paragraph =  new Paragraph("Citizen Plans Info",fonttitle);
		paragraph.setAlignment(paragraph.ALIGN_CENTER);
		
		PdfPTable table = new PdfPTable(8);
		
		table.setSpacingBefore(5);
		
		table.addCell("ID");
		table.addCell("citizenName");
		table.addCell("Gender");
		table.addCell("planName");
		table.addCell("planStatus");
		table.addCell("planStartDate");
		table.addCell("planEndDate");
		table.addCell("benefitAmt");

		
		
		
		
		
		
		for(CitizenPlan plans:recoder)
		{
			table.addCell(String.valueOf(plans.getCitizenId()) );
			table.addCell(plans.getCitizenName());
			table.addCell(plans.getGender());
			table.addCell(plans.getPlanName());
			table.addCell(plans.getPlanStatus());
			table.addCell(plans.getPlanStartDate()+"");
			table.addCell(plans.getPlanEndDate()+"");
			table.addCell(plans.getBenefitAmt()+"");
			
			
		}
		
		document.add(paragraph);
		document.add(table);
		document.close();
		
		
		
	}
}
