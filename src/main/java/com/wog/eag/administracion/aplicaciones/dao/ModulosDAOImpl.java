package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wog.eag.administracion.aplicaciones.model.ModulosEntity;

@Transactional
@Repository
public class ModulosDAOImpl implements ModulosDAO{

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public ModulosEntity get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(ModulosEntity.class, id);
	}

	@Override
	public BigDecimal save(ModulosEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity.getAdModuleId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ModulosEntity> list(BigDecimal parentId) {

		List<ModulosEntity> list = sessionFactory.getCurrentSession().createQuery("from ModulosEntity where adApplicationId = :parentId")
				.setParameter("parentId", parentId).list();
		
		return list;
	}

	@Override
	public void update(ModulosEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		ModulosEntity entity = session.byId(ModulosEntity.class).load(id);
		session.delete(entity);
	}
	
}