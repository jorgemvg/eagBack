package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.wog.eag.administracion.aplicaciones.model.ToolbarPk;

import com.wog.eag.administracion.aplicaciones.model.ToolbarEntity;

@Repository
public class ToolbarDAOImpl implements ToolbarDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public ToolbarEntity get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(ToolbarEntity.class, id);
	}

	@Override
	public BigDecimal save(ToolbarEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity.getAdTabToolbarId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ToolbarEntity> list(BigDecimal parentId) {

		List<ToolbarEntity> list = sessionFactory.getCurrentSession().createQuery("from ToolbarEntity where adTabId = :parentId")
				.setParameter("parentId", parentId).list();
		
		return list;
	}

	@Override
	public void update(ToolbarEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(ToolbarPk pk) {
		Session session = sessionFactory.getCurrentSession();
		ToolbarEntity entity = session.byId(ToolbarEntity.class).load(pk);
		session.delete(entity);
	}
	
}