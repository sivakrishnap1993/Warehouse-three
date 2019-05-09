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

public class WHUsertypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Change the file name
		response.addHeader("Content-Disposition", "attachment;filename=whuser.xlsx");

		// get the data from model
		@SuppressWarnings("unchecked")
		List<WhUserType> lst = (List<WhUserType>) model.get("list");

		// Create sheet and add workspace
		Sheet sheet = workbook.createSheet("whusertype");

		// Create Row#0 onwards
		setHead(sheet);

		// Create Row#1 onwards
		setBody(sheet, lst);

	}

	private void setHead(Sheet sheet) {
		Row r = sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(1).setCellValue("CODE");
		r.createCell(1).setCellValue("UFOR");
		r.createCell(1).setCellValue("EMAIL");
		r.createCell(1).setCellValue("CONTACT");
		r.createCell(1).setCellValue("IDTYPE");
		r.createCell(1).setCellValue("NUMBER");

	}

	private void setBody(Sheet sheet, List<WhUserType> list) {
		int rowId = 1;
		for (WhUserType w : list) {
			Row rr = sheet.createRow(rowId++);
			rr.createCell(0).setCellValue(w.getUrdId());
			rr.createCell(6).setCellValue(w.getUserOneType());
			rr.createCell(2).setCellValue(w.getUsrCode());
			rr.createCell(3).setCellValue(w.getUsrFor());
			rr.createCell(4).setCellValue(w.getUsrEmail());
			rr.createCell(5).setCellValue(w.getUsrContact());
			rr.createCell(1).setCellValue(w.getUserType());
			rr.createCell(7).setCellValue(w.getUsrNum());
		}
	}

}
