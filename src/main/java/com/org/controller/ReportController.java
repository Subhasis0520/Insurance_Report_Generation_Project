package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.org.request.SearchRequest;
import com.org.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	
	@GetMapping("/pdf")
	public void convertToPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");	
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	
	
	@GetMapping("/excel")
	public void convertToExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");	
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
	}
	
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request,Model model) {	
		System.out.println(request);
		
		model.addAttribute("plansInfo", service.search(request));
		extracted(model);
		return "index";
	}

	
	@GetMapping("/")
	public String search(Model model) {	
		model.addAttribute("search", new SearchRequest());
		extracted(model);
		return "index";
	}

	private void extracted(Model model) {
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}
}
