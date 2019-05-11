package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Purchase;

public class PurchaseExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// Change File Name
		response.addHeader("Content-Disposition", "attachment;filename=purchase.xlsx");

		// Get Data To Model
		@SuppressWarnings("unchecked")
		List<Purchase> lst = (List<Purchase>) model.get("list");

		// Create Sheet And Add data to Workbook
		Sheet sheet = workbook.createSheet("purchase");

		
		setHead(sheet);

		setBody(sheet, lst);

	}

	public void setHead(Sheet sheet) {
		Row r = sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("MODE");
		r.createCell(4).setCellValue("REFERENCE NO");
		r.createCell(5).setCellValue("QUALITY");
		r.createCell(6).setCellValue("STATUS");
		r.createCell(7).setCellValue("SHIPMENTTYPE");
		r.createCell(8).setCellValue("VENDOR");
		r.createCell(9).setCellValue("NOTE");

	}

	public void setBody(Sheet sheet, List<Purchase> list) {
		int rowId = 1;
		for (Purchase p : list) {
			Row rr = sheet.createRow(rowId++);
			rr.createCell(0).setCellValue(p.getOrdId());
			rr.createCell(1).setCellValue(p.getOrdCode());
			rr.createCell(2).setCellValue(p.getShipMode());
			rr.createCell(4).setCellValue(p.getRefNo());
			rr.createCell(5).setCellValue(p.getQtyCk());
			rr.createCell(6).setCellValue(p.getOrdSts());
			rr.createCell(7).setCellValue(p.getShip().getShipmentCode());
			rr.createCell(8).setCellValue(p.getVenwhuser().getUserCode());
			rr.createCell(9).setCellValue(p.getNode());
		}
	}
}
