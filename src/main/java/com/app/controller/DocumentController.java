package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Document;
import com.app.service.IDocumentService;

@Controller
@RequestMapping("/docus")
public class DocumentController {

	@Autowired
	private IDocumentService service;

	// 1.SHOW DOCUMENTS PAGE
	@RequestMapping("/all")
	public String showAllUploads(ModelMap map) {
		List<Object[]> lst = service.getFileIdAndName();
		map.addAttribute("list", lst);
		return "DocumentsPage";
	}

	// 2.UPLOAD DOCUMENTS PAGE
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadPage(@RequestParam CommonsMultipartFile fob, ModelMap map) {

		if (fob != null) {
			// Convert to model class object
			Document d = new Document();
			d.setFileName(fob.getOriginalFilename());
			d.setFileData(fob.getBytes());
			service.saveDocument(d);
			List<Object[]> lst = service.getFileIdAndName();
			map.addAttribute("list", lst);
		}
		return "DocumentsPage";

	}

	// 3.DOWNLOAD DOCUMENTS PAGE
	@RequestMapping("/download")
	public void downloadDocs(@RequestParam Integer fileId, HttpServletResponse response) {

		// READ OBJECT FROM DATABASE USING PK
		Document doc = service.getDocumentById(fileId);

		// ADD HEADER PARAMETER
		response.addHeader("Content-Disposition", "attachment;filename=" + doc.getFileName());

		try {
			// COPY OBJECT DATA TO OUTPUT STREAM
			FileCopyUtils.copy(doc.getFileData(), response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
