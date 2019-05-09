package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Change File name
		response.addHeader("Context-Disposition", "attachment:filename=uom.xlsx");

		// Read data from model(map)
		@SuppressWarnings("unchecked")
		List<Uom> lst = (List<Uom>) model.get("list");

		// Create sheet with name shipments
		Sheet sheet = workbook.createSheet("uoms");

		// Create row#0 only heading
		setHead(sheet);
		// Create Row#1 onwards
		setBody(sheet, lst);
	}

	private void setHead(Sheet sheet) {
		Row r = sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("ENABLE");
		r.createCell(4).setCellValue("METACODE");
		r.createCell(5).setCellValue("SIZE");
		r.createCell(6).setCellValue("NOTE");
	}

	private void setBody(Sheet sheet, List<Uom> list) {
		int rowId = 1;
		for (Uom s : list) {
			Row r = sheet.createRow(rowId++);
			r.createCell(0).setCellValue(s.getUomId());
			r.createCell(1).setCellValue(s.getUonType());
			r.createCell(2).setCellValue(s.getUomCode());
			r.createCell(3).setCellValue(s.getUomEnable());
			r.createCell(4).setCellValue(s.getMetaCode());
			r.createCell(5).setCellValue(s.getAdjst());
			r.createCell(6).setCellValue(s.getNote());
		}
	}
}
