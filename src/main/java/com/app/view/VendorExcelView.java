package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Vendor;

public class VendorExcelView extends AbstractXlsView{

	
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=VENDOR.xlsx");
		Sheet sheet=workbook.createSheet("VEN");
		List<Vendor> vens=(List<Vendor>) model.get("vens");
		setHead(sheet);
		setBody(sheet,vens);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("Deseg");
		row.createCell(4).setCellValue("Preserve");
	}

	private void setBody(Sheet sheet, List<Vendor> vens) {
		int rowNum=1;
		for(Vendor v:vens) {
		Row row=sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(v.getVenId().toString());
		row.createCell(1).setCellValue(v.getVenName());
		row.createCell(2).setCellValue(v.getVenCode());
		row.createCell(3).setCellValue(v.getVenDesg());
		row.createCell(4).setCellValue(v.getVenPreserve().toString());
		}
	}

}
