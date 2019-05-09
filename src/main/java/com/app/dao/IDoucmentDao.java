package com.app.dao;

import java.util.List;

import com.app.model.Document;

public interface IDoucmentDao {

	public Integer saveDocument(Document doc);
	
	public Document getDocumentById(Integer id);
	
	public List<Object[]> getFileIdAndName ();
}
