package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wog.eag.administracion.aplicaciones.model.AplicacionEntity;

@Transactional
@Repository
public class AplicacionDAOImpl implements AplicacionDAO{

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public AplicacionEntity get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(AplicacionEntity.class, id);
	}

	@Override
	public BigDecimal save(AplicacionEntity entity) {
		sessionFactory.getCurrentSession().save(entity);
		return entity.getAdApplicationId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AplicacionEntity> list() {

		List<AplicacionEntity> list = sessionFactory.getCurrentSession().createQuery("from AplicacionEntity").list();
				
		
		return list;
	}

	@Override
	public void update(AplicacionEntity entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		AplicacionEntity entity = session.byId(AplicacionEntity.class).load(id);
		session.delete(entity);
	}
	
}