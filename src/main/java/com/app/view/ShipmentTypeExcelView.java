package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.ShipmentType;



public class ShipmentTypeExcelView  extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		       // Change File name
				response.addHeader("Context-Disposition", "attachment;filename=shipments.xlsx");

				// Read data from model(map)
				@SuppressWarnings("unchecked")
				List<ShipmentType> lst = (List<ShipmentType>) model.get("list");

				// Create sheet with name shipments
				Sheet sheet = workbook.createSheet("shipmentTypes");

				// Create row#0 only heading
				setHead(sheet);
				// Create Row#1 onwards
				setBody(sheet, lst);
			}

			private void setHead(Sheet sheet) {
				Row r = sheet.createRow(0);
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("MODE");
				r.createCell(2).setCellValue("CODE");
				r.createCell(3).setCellValue("ENABLE");
				r.createCell(4).setCellValue("SHIPGRADE");
				r.createCell(5).setCellValue("NOTE");
			}

			private void setBody(Sheet sheet, List<ShipmentType> list) {
				int rowId = 1;
				for (ShipmentType s : list) {
					Row r = sheet.createRow(rowId++);
					r.createCell(0).setCellValue(s.getShipmentid());
					r.createCell(1).setCellValue(s.getShipmentMode());
					r.createCell(2).setCellValue(s.getShipmentCode());
					r.createCell(3).setCellValue(s.getEnableShipment());
					r.createCell(4).setCellValue(s.getShipmentGrade());
					r.createCell(5).setCellValue(s.getShipDesc());
					
				}
			}

}
