package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Admin;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class AdminPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// file Name & Download PDF file
		response.addHeader("Content-Disposition", "attachment;filename=uom.pdf");

		// read data from model
		@SuppressWarnings("unchecked")
		List<Admin> lst = (List<Admin>) model.get("list");

		// create One Element
		Paragraph p = new Paragraph("Welcome To App");

		// Add Element To Document

		document.add(p);

		// Table With Column Count
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("ENABLE");
		t.addCell("GRADE");
		t.addCell("NOTE");

		// add Data to Table
		for (Admin u : lst) {
			t.addCell(u.getAdmId().toString());
			t.addCell(u.getAdmName());
			t.addCell(u.getAdmSalary());
			t.addCell(u.getDept());
			t.addCell(u.getAdmModes().toString());

		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
