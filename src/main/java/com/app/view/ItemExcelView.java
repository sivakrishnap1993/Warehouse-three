package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("Content-Disposition", "attachment:filename=item.xlxs");

		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) model.get("list");

		Sheet sheet = workbook.createSheet("Items");

		setHead(sheet);

		setBody(sheet, list);
	}

	private void setHead(Sheet sheet) {
		Row r = sheet.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("HEIGHT");
		r.createCell(3).setCellValue("LENGTH");
		r.createCell(4).setCellValue("WEIGHT");
		r.createCell(5).setCellValue("UOM");
		r.createCell(6).setCellValue("ORDERMETHOD");
		r.createCell(7).setCellValue("VENDOR");
		r.createCell(8).setCellValue("CUSTOMER");
		r.createCell(9).setCellValue("COST");
		r.createCell(10).setCellValue("CURRENCY");
		r.createCell(11).setCellValue("NOTE");
	}

	private void setBody(Sheet sheet, List<Item> list) {
		int rowId = 1;
		for (Item i : list) {
			Row r = sheet.createRow(rowId++);
			r.createCell(0).setCellValue(i.getItemId());
			r.createCell(1).setCellValue(i.getItmCode());
			r.createCell(2).setCellValue(i.getItemHeight());
			r.createCell(3).setCellValue(i.getItemLength());
			r.createCell(4).setCellValue(i.getItmWidth());
			r.createCell(5).setCellValue(i.getUom().getUomEnable());
			r.createCell(6).setCellValue(i.getOm().getOrdMode());
			r.createCell(7).setCellValue(i.getWuven().getUsrCode());
			r.createCell(8).setCellValue(i.getWucust().getUsrCode());
			r.createCell(9).setCellValue(i.getBaseCost());
			r.createCell(10).setCellValue(i.getBaseCurrency());
			r.createCell(11).setCellValue(i.getNote());
		}
	}

}
