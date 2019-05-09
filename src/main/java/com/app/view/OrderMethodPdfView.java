package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.OrderMethod;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class OrderMethodPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// file Name & Download PDF file
		response.addHeader("Content-Disposition", "attachment;filename=ordermethod.pdf");

		// read data from model
		@SuppressWarnings("unchecked")
		List<OrderMethod> lst = (List<OrderMethod>) model.get("list");

		// create One Element
		Paragraph p = new Paragraph("Welcome To App");

		// Add Element To Document

		document.add(p);

		// Table With Column Count
		PdfPTable t = new PdfPTable(6);
		t.addCell("ID");
		t.addCell("MODE");
		t.addCell("CODE");
		t.addCell("TYPE");
		t.addCell("ACCEPT");
		t.addCell("NOTE");

		// add Data to Table
		for (OrderMethod u : lst) {
			t.addCell(u.getOrdMId().toString());
			t.addCell(u.getOrdMode());
			t.addCell(u.getOrdCode());
			t.addCell(u.getOrdExType());
			t.addCell(u.getOrdAccept().toString());
			t.addCell(u.getNote());

		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
