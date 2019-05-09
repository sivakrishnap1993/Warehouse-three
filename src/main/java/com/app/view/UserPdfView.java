package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.User;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UserPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Change File Name
		response.addHeader("Content-Disposition", "attachment;filename=user.pdf");

		// Data get From The Model
		@SuppressWarnings("unchecked")
		List<User> list =  (List<User>) model.get("list");

		Paragraph p = new Paragraph("Welcome To Usee Page");

		// Add Document to Value
		document.add(p);

		PdfPTable t = new PdfPTable(5);
		t.addCell("ID");
		t.addCell("NAME");
		t.addCell("GENDER");
		t.addCell("EMAIL");
		t.addCell("MOBILE");
		t.addCell("PWD");
		t.addCell("ROLES");

		for (User u : list) {
			t.addCell(u.getUseId().toString());
			t.addCell(u.getUsrName());
			t.addCell(u.getGender());
			t.addCell(u.getUsrMail());
			t.addCell(u.getUserMobile());
			t.addCell(u.getUsrPwd());
			t.addCell(u.getUsrRoles().toString());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
