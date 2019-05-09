package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// file Name & Download PDF file
		response.addHeader("Content-Disposition", "attachment;filename=shipment.pdf");

		// read data from model
		@SuppressWarnings("unchecked")
		List<ShipmentType> lst = (List<ShipmentType>) model.get("list");

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
		for (ShipmentType u : lst) {
			t.addCell(u.getShipmentId().toString());
			t.addCell(u.getShipmentMode());
			t.addCell(u.getShipmentCode());
			t.addCell(u.getEnableShipment());
			t.addCell(u.getShipmentGrade());
			t.addCell(u.getNote());

		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
