package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.app.model.Employee;



public class EmployeeExcelView  extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		       // Change File name
				response.addHeader("Context-Disposition", "attachment;filename=employee.xlsx");

				// Read data from model(map)
				@SuppressWarnings("unchecked")
				List<Employee> lst = (List<Employee>) model.get("list");

				// Create sheet with name shipments
				Sheet sheet = workbook.createSheet("employee");

				// Create row#0 only heading
				setHead(sheet);
				// Create Row#1 onwards
				setBody(sheet, lst);
			}

			private void setHead(Sheet sheet) {
				Row r = sheet.createRow(0);
				r.createCell(0).setCellValue("ID");
				r.createCell(1).setCellValue("NAME");
				r.createCell(2).setCellValue("PWD");
				r.createCell(3).setCellValue("GEN");
				r.createCell(4).setCellValue("ADDR");
			}

			private void setBody(Sheet sheet, List<Employee> list) {
				int rowId = 1;
				for (Employee s : list) {
					Row r = sheet.createRow(rowId++);
					r.createCell(0).setCellValue(s.getEmpId());
					r.createCell(1).setCellValue(s.getEmpName());
					r.createCell(2).setCellValue(s.getEmpPwd());
					r.createCell(3).setCellValue(s.getEmpGen());
					r.createCell(4).setCellValue(s.getEmpAddr());
				
					
				}
			}

}
