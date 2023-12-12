package com.org.service;

import java.io.File;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.org.entity.CitizenPlan;
import com.org.repository.CitizenPlanRepo;
import com.org.request.SearchRequest;
import com.org.util.EmailUtils;
import com.org.util.ExcelGenerator;
import com.org.util.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

@Service
public  class ReportServiceImp implements ReportService{

	@Autowired
	private CitizenPlanRepo repo;
	
	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils email;

	@Override
	public List<String> getPlanNames() {
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();
		
		if(request.getPlanName() != null && !request.getPlanName().equals(""))
			entity.setPlanName(request.getPlanName());
		
		if(request.getPlanStatus() != null && !request.getPlanStatus().equals(""))
			entity.setPlanStatus(request.getPlanStatus());
		
		if(request.getGender() != null && !request.getGender().equals(""))
			entity.setGender(request.getGender());
		
		if(request.getPlanStartDate() != null && !request.getPlanStartDate().equals("")) {
			String startDate = request.getPlanStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(date);
		}
		
		if(request.getPlanEndDate() != null && !request.getPlanEndDate().equals("")) {
			String endDate = request.getPlanEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(date);
		}
		
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> list = repo.findAll();
		File f = new File("Plans.xls");
		excelGenerator.exportExcel(response, list,f);
		
		String subject = "Send plans data";
		String body = "<h2>Mail Has Send</h2>";
		String toMail = "subhasisghosh551@gmail.com";
		email.sendMail(subject, body, toMail,f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		File f = new File("Plans.pdf");
		List<CitizenPlan> list = repo.findAll();
		pdfGenerator.generatePdf(response, list,f);
		
		String subject = "Send plans data";
		String body = "<h2>Mail Has Send</h2>";
		String toMail = "subhasisghosh551@gmail.com";
		email.sendMail(subject, body, toMail,f);
		f.delete();
		
		return true;
	}

	
}
