package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wog.eag.administracion.aplicaciones.model.TableEntity;

@Repository
public class TableDAOImpl implements TableDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public TableEntity get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(TableEntity.class, id);
	}

	@Override
	public BigDecimal save(TableEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity.getAdTableId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TableEntity> list(BigDecimal adModuleId) {

		List<TableEntity> list = sessionFactory.getCurrentSession().createQuery("from TableEntity where adModuleId = :adModuleId")
				.setParameter("adModuleId", adModuleId).list();
		
		return list;
	}

	@Override
	public void update(TableEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		TableEntity window = session.byId(TableEntity.class).load(id);
		session.delete(window);
	}
	
}