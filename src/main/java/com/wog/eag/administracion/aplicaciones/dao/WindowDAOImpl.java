package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wog.eag.administracion.aplicaciones.model.WindowEntity;

@Repository
public class WindowDAOImpl implements WindowDAO{

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public WindowEntity get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(WindowEntity.class, id);
	}

	@Override
	public BigDecimal save(WindowEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity.getAdWindowId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<WindowEntity> list(BigDecimal parentId) {

		List<WindowEntity> list = sessionFactory.getCurrentSession().createQuery("from WindowEntity where adModuleId = :parentId")
				.setParameter("parentId", parentId).list();
		
		return list;
	}

	@Override
	public void update(WindowEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		WindowEntity entity = session.byId(WindowEntity.class).load(id);
		session.delete(entity);
	}
	
}