package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.User;

public class UserExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// CHANGE THE FILE NAME
		response.addHeader("Content-Disposition", "attachment;filename=user.xlsx");

		// GET DATA FROM MODEL
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) model.get("list");

		// CREATE SHEET AND ADD TO WORKBOOK
		Sheet sheet = workbook.createSheet("user");

		setHead(sheet);

		setBody(sheet, list);
	}

	private void setHead(Sheet sheet) {
		Row r = sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("NAME");
		r.createCell(2).setCellValue("GENDER");
		r.createCell(3).setCellValue("EMAIL");
		r.createCell(4).setCellValue("MOBILE");
		r.createCell(5).setCellValue("PWD");
		r.createCell(6).setCellValue("ROLES");
	}

	private void setBody(Sheet sheet, List<User> list) {
		int rowId = 1;
		for (User u : list) {
			Row rr = sheet.createRow(rowId++);
			rr.createCell(0).setCellValue(u.getUseId());
			rr.createCell(1).setCellValue(u.getUsrName());
			rr.createCell(2).setCellValue(u.getGender());
			rr.createCell(3).setCellValue(u.getUsrMail());
			rr.createCell(4).setCellValue(u.getUserMobile());
			rr.createCell(4).setCellValue(u.getUsrPwd());
			rr.createCell(6).setCellValue(u.getUsrRoles().toString());
		}
	}
}
