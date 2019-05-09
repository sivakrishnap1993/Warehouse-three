package com.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDoucmentDao;
import com.app.model.Document;

@Repository
public class DocumentDaoImpl implements IDoucmentDao {

	@Autowired
	private HibernateTemplate ht;

	public Integer saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getFileIdAndName() {
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(Document.class)
				.setProjection(Projections.projectionList()
						.add(Projections.property("fileId"))
						.add(Projections.property("fileName"))));
		
		/*
		 * String hql = " select fileId,fileName " + " from com.app.model.Document ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]> lst =
		 * (List<Object[]>) ht.find(hql);
		 */
		return list;
	}

	@Override
	public Document getDocumentById(Integer id) {
		return ht.get(Document.class, id);
	}

}
