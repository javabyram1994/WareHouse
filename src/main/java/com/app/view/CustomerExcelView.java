package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment;filename=Customer.xlsx");
		Sheet sheet=workbook.createSheet("CUSTS");
		List<Customer> custs=(List<Customer>) model.get("custs");
		setHead(sheet);
		setBody(sheet,custs);
	}

	private void setHead(Sheet sheet) {
         Row row=sheet.createRow(0);
         row.createCell(0).setCellValue("ID");
         row.createCell(1).setCellValue("CODE");
         row.createCell(2).setCellValue("Address");
         row.createCell(3).setCellValue("Locs");
         row.createCell(4).setCellValue("Enabled");
         row.createCell(5).setCellValue("Email");
         row.createCell(6).setCellValue("CONTACT");
	}

	private void setBody(Sheet sheet, List<Customer> custs) {
		int rowNum=1;
		for(Customer c:custs) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(c.getCustId().toString());
			row.createCell(1).setCellValue(c.getCustCode());
			row.createCell(2).setCellValue(c.getCustAddr());
			row.createCell(3).setCellValue(c.getCustLocs().toString());
			row.createCell(4).setCellValue(c.getCustEnabled());
			row.createCell(5).setCellValue(c.getCustEmail());
			row.createCell(6).setCellValue(c.getCustContact());
		}
	}

}
