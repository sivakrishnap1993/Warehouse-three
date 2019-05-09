package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// file Name & Download PDF file
		response.addHeader("Content-Disposition", "attachment;filename=uom.pdf");

		// read data from model
		@SuppressWarnings("unchecked")
		List<Uom> lst = (List<Uom>) model.get("list");

		// create One Element
		Paragraph p = new Paragraph("Welcome To App");

		// Add Element To Document

		document.add(p);

		// Table With Column Count
		PdfPTable t = new PdfPTable(7);
		t.addCell("ID");
		t.addCell("TYPE");
		t.addCell("CODE");
		t.addCell("ENABLE");
		t.addCell("META");
		t.addCell("SIZE");
		t.addCell("NOTE");

		// add Data to Table
		for (Uom u : lst) {
			t.addCell(u.getUomId().toString());
			t.addCell(u.getUonType());
			t.addCell(u.getUomCode());
			t.addCell(u.getUomEnable());
			t.addCell(u.getMetaCode());
			t.addCell(u.getAdjst());
			t.addCell(u.getNote());
		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
