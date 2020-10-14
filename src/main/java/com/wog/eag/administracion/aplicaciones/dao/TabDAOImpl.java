package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wog.eag.administracion.aplicaciones.model.TabEntity;

@Repository
public class TabDAOImpl implements TabDAO{

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public TabEntity get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(TabEntity.class, id);
	}

	@Override
	public BigDecimal save(TabEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity.getAdTabId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TabEntity> list(BigDecimal parentId) {

		List<TabEntity> list = sessionFactory.getCurrentSession().createQuery("from TabEntity where adWindowId = :parentId")
				.setParameter("parentId", parentId).list();
		
		return list;
	}

	@Override
	public void update(TabEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		TabEntity entity = session.byId(TabEntity.class).load(id);
		session.delete(entity);
	}
	
}