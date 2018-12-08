package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsView{

	
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=SHIPMENTTYPE.xlsx");
		Sheet sheet=workbook.createSheet("STS");
		List<ShipmentType> sts=(List<ShipmentType>) model.get("sts");
		setHead(sheet);
		setBody(sheet,sts);
	}

	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("ENABLING");
		row.createCell(4).setCellValue("GRADE");
		row.createCell(5).setCellValue("DISCRIPTION");
	}

	private void setBody(Sheet sheet, List<ShipmentType> sts) {
		int rowNum=1;
		for(ShipmentType s:sts) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(s.getId());
			row.createCell(1).setCellValue(s.getMode());
			row.createCell(2).setCellValue(s.getCode());
			row.createCell(3).setCellValue(s.getEnabled());
			row.createCell(4).setCellValue(s.getGrade());
			row.createCell(5).setCellValue(s.getDsc());
		}
		
	}
	

}
