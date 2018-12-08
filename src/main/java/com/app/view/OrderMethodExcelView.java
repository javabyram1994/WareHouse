package com.app.view;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsView {


	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=ORDERMETHOD.xlsx");
		Sheet sheet=workbook.createSheet("OMS");
		setHead(sheet);
		@SuppressWarnings("unchecked")
		List<OrderMethod> oms=(List<OrderMethod>) model.get("oms");
		setBody(sheet,oms);
	}
	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("METHOD");
		row.createCell(4).setCellValue("ACCEPT");
		row.createCell(5).setCellValue("DSC");  
	}

	private void setBody(Sheet sheet, List<OrderMethod> oms) {
		int rowNum=1;
		for(OrderMethod om:oms) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(om.getId());
			row.createCell(1).setCellValue(om.getMode());
			row.createCell(2).setCellValue(om.getCode());
			row.createCell(3).setCellValue(om.getMethod());
			row.createCell(4).setCellValue(om.getAccept().toString());
			row.createCell(5).setCellValue(om.getDsc());

		}

	}



}
