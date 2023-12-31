package com.org.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.org.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	public void exportExcel(HttpServletResponse response, List<CitizenPlan> records, File f) throws Exception {
//		Workbook workbook = new XSSFWorkbook();   // for xmlx file
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);
		
		// set the name of the columns
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		headerRow.createCell(7).setCellValue("Benifit Amount");
		
		// fetch all the data from database
		
		int dataRowIndex = 1;
		
		// insert all the data into sheet's row
		for(CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			
			if(plan.getPlanStartDate() != null)
			    dataRow.createCell(5).setCellValue(plan.getPlanStartDate()+"");
			else
				dataRow.createCell(5).setCellValue("N/A");
			
			if(plan.getPlanEndDate() != null)
			    dataRow.createCell(6).setCellValue(plan.getPlanEndDate()+"");
			else
				dataRow.createCell(6).setCellValue("N/A");
			
			if(plan.getBenifitAmount() != null) {
			   dataRow.createCell(7).setCellValue(plan.getBenifitAmount());
			}else {
				dataRow.createCell(7).setCellValue("N/A");
			}
			
			dataRowIndex++;
		}
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		workbook.close();
		
		ServletOutputStream sos = response.getOutputStream();
		workbook.write(sos);
		workbook.close();
		
	}
}
