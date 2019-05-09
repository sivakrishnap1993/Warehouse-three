
package com.app.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Employee;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class EmployeePdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// file Name & Download PDF file
		response.addHeader("Content-Disposition", "attachment;filename=employee.pdf");

		// read data from model
		
		@SuppressWarnings("unchecked")
		List<Employee> lst = (List<Employee>) model.get("list");

		// create One Element
		Paragraph p = new Paragraph("Welcome To App");

		// Add Element To Document

		document.add(p);

		// Table With Column Count
		PdfPTable t = new PdfPTable(5);
		t.addCell("ID");
		t.addCell("NAME");
		t.addCell("PWD");
		t.addCell("GEN");
		t.addCell("ADDR");

		// add Data to Table
		for (Employee u : lst) {
			t.addCell(u.getEmpId().toString());
			t.addCell(u.getEmpName());
			t.addCell(u.getEmpPwd());
			t.addCell(u.getEmpGen());
			t.addCell(u.getEmpAddr());

		}
		document.add(t);
		document.add(new Paragraph(new Date().toString()));
	}

}
