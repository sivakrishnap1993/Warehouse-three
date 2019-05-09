package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView  extends AbstractPdfView{
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	response.addHeader("Content-Disposition", "attachment;filename=item.pdf");

	// read data from model
	@SuppressWarnings("unchecked")
	List<Item> lst = (List<Item>) model.get("list");

	// create One Element
	Paragraph p = new Paragraph("Welcome To App");

	// Add Element To Document

	document.add(p);

	// Table With Column Count
	PdfPTable t = new PdfPTable(12);
	t.addCell("ID");
	t.addCell("CODE");
	t.addCell("HEIGHT");
	t.addCell("LENGTH");
	t.addCell("WEIGHT");
	t.addCell("UOM");
	t.addCell("ORDERMETHOD");
	t.addCell("VENDOR");
	t.addCell("CUSTOMER");
	t.addCell("COST");
	t.addCell("CURRENCY");
	t.addCell("NOTE");

	// add Data to Table
	for (Item u : lst) {
		t.addCell(u.getItemId().toString());
		t.addCell(u.getItmCode());
		t.addCell(u.getItemHeight().toString());
		t.addCell(u.getItemLength().toString());
		t.addCell(u.getItmWidth().toString());
		t.addCell(u.getUom().getUomEnable());
		t.addCell(u.getOm().getOrdMode());
		t.addCell(u.getWuven().getUsrCode());
		t.addCell(u.getWucust().getUsrCode());
		t.addCell(u.getBaseCost());
		t.addCell(u.getBaseCurrency());
		t.addCell(u.getNote());

	}
	
	document.add(t);
	document.add(new Paragraph(new Date().toString()));
}
}
