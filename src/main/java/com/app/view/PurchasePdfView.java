package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Purchase;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PurchasePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Change File Name
		response.addHeader("Content-Disposition", "attachment;filename=purchase.pdf");

		// Data get to model
		@SuppressWarnings("unchecked")
		List<Purchase> list = (List<Purchase>) model.get("list");

		// create paragraph
		Paragraph p = new Paragraph("Welcome to my page");

		// Add to document
		document.add(p);

		// Create PdfTable
		PdfPTable t = new PdfPTable(8);
		t.addCell("ID");
		t.addCell("CODE");
		t.addCell("MODE");
		t.addCell("REFERENCE NO");
		t.addCell("QUALITY");
		t.addCell("STATUS");
		t.addCell("SHIPMENTTYPE");
		t.addCell("VENDOR");
		t.addCell("NOTE");

		for (Purchase pp : list) {
			t.addCell(pp.getOrdId().toString());
			t.addCell(pp.getOrdCode());
			t.addCell(pp.getShipMode());
			t.addCell(pp.getRefNo());
			t.addCell(pp.getQtyCk());
			t.addCell(pp.getOrdSts());
			t.addCell(pp.getShip().getShipmentCode());
			t.addCell(pp.getVenwhuser().getUsrCode());
			t.addCell(pp.getNode());
		}

		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
