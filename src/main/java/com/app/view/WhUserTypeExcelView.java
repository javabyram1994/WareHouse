package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsView{

	
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=WhUserType.xlsx");
		Sheet sheet=workbook.createSheet("WHUSERTYPE");
		List<WhUserType> whs=(List<WhUserType>) model.get("whs");
		setHead(sheet);
		setBody(sheet,whs);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("USERFOR");
		row.createCell(4).setCellValue("EMAIL");
		row.createCell(5).setCellValue("CONTACT");
		row.createCell(6).setCellValue("IDType");
		row.createCell(7).setCellValue("IfOthers");
		row.createCell(8).setCellValue("IdNumber");
		
	}

	private void setBody(Sheet sheet, List<WhUserType> whs) {
		int rowNum=1;
		for(WhUserType w:whs) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(w.getId());
			row.createCell(1).setCellValue(w.getType());
			row.createCell(2).setCellValue(w.getCode());
			row.createCell(3).setCellValue(w.getForType());
			row.createCell(4).setCellValue(w.getEmail());
			row.createCell(5).setCellValue(w.getContact());
			row.createCell(6).setCellValue(w.getIdType());
			row.createCell(7).setCellValue(w.getIfOthers());
			row.createCell(8).setCellValue(w.getIfNum());
		}
		
	}

}
