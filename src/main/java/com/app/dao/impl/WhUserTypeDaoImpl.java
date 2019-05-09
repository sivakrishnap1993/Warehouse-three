package com.app.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IWhUserTypeDao;
import com.app.model.WhUserType;
import com.app.util.AppCollectionUtil;

@Repository
public class WhUserTypeDaoImpl implements IWhUserTypeDao {

	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveWhUserType(WhUserType wh) {

		return (Integer) ht.save(wh);
	}

	@Override
	public void updateWhUserType(WhUserType wh) {
		ht.update(wh);
	}

	@Override
	public void deleteWhUserType(Integer id) {
		WhUserType w = new WhUserType();
		w.setUrdId(id);
		ht.delete(w);
	}

	@Override
	public WhUserType getWhUserTypeById(Integer id) {
		WhUserType ww = ht.get(WhUserType.class, id);
		return ww;
	}

	@Override
	public List<WhUserType> getAllWhUserTypes() {
		List<WhUserType> lst = ht.loadAll(WhUserType.class);
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getWhUserTypeCountByMode() {
		List<Object[]> list=(List<Object[]>)ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class)
				.setProjection(Projections.projectionList().add(Projections.groupProperty("userType"))
				.add(Projections.count("userType"))
				));
		
		/*
		 * String hql = " select userType,count(userType) " + "  from " +
		 * WhUserType.class.getName() + "  group by userType ";
		 * 
		 * @SuppressWarnings({ "unchecked", "deprecation" }) List<Object[]> list =
		 * (List<Object[]>) ht.find(hql);
		 */
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WhUserType> getWhUsersBasedonType(String type) {
		List<WhUserType> list=(List<WhUserType>)ht.findByCriteria(DetachedCriteria.forClass(WhUserType.class).add(Restrictions.eq("userOneType", type)));
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isWhUserCodeExist(String userCode) {

		long count=0;
		//String hql="select count(userCode) from "+WhUserType.class.getName()+" where userCode=?";
		DetachedCriteria hql=
				DetachedCriteria.forClass(WhUserType.class)
				.setProjection(Projections.count("userCode"))
				.add(Restrictions.eq("userCode", userCode))
				;

		List<Long> whUserType=(List<Long>) ht.findByCriteria(hql);

		if(whUserType!=null && !whUserType.isEmpty()) {
			count=whUserType.get(0);
		}
		return count>0?true:false;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, String> getAllWhUserByType(String userType) {
		//String hql = "select userId,userCode from "+WhUserType.class.getName()+" where userType=?";
		DetachedCriteria hql=
				DetachedCriteria.forClass(WhUserType.class)
				.setProjection(
						Projections.projectionList()
						.add(Projections.property("userId"))
						.add(Projections.property("userCode"))

						)
				.add(Restrictions.eq("userType", userType))
				;
		List<Object[]> list=(List<Object[]>) ht.findByCriteria(hql);
		return AppCollectionUtil.toMap(list);
	}

	@SuppressWarnings("unchecked")
	public boolean isEmailOrMobileExist(String type, String userEmailOrmobile) {
		long count=0;
		//String hql="select count("+type+") from "+WhUserType.class.getName()+" where "+type+"=?";

		DetachedCriteria hql=
				DetachedCriteria.forClass(WhUserType.class)
				.setProjection(Projections.count(type))
				.add(Restrictions.eq(type, userEmailOrmobile));

		List<Long> user=(List<Long>) ht.findByCriteria(hql);

		if (user!=null && !user.isEmpty()) {
			count=user.get(0);
		}
		return count>0?true:false;
	}


}
