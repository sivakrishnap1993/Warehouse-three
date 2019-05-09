package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WHUserTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Change the file name
		response.addHeader("Content-Disposition", "attachment;filename=whuser.pdf");

		// Add Data get form model
		@SuppressWarnings("unchecked")
		List<WhUserType> list = (List<WhUserType>) model.get("list");

		// Create paragraph and add file to document
		Paragraph p = new Paragraph("Welcome to User Type page");

		// Document
		document.add(p);

		PdfPTable t = new PdfPTable(8);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("UFOR");
		t.addCell("EMAIL");
		t.addCell("CONTACT");
		t.addCell("IDTYPE");
		t.addCell("NUMBER");

		for (WhUserType w : list) {
			t.addCell(w.getUrdId().toString());
			t.addCell(w.getUserOneType());
			t.addCell(w.getUsrCode());
			t.addCell(w.getUsrFor());
			t.addCell(w.getUsrEmail());
			t.addCell(w.getUsrContact());
			t.addCell(w.getUserType());
			t.addCell(w.getUsrNum());

		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));

	}

}
