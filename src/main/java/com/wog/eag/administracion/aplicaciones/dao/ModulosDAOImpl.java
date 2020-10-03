package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wog.eag.administracion.aplicaciones.model.Modulos;

@Repository
public class ModulosDAOImpl implements ModulosDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Modulos get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(Modulos.class, id);
	}

	@Override
	public BigDecimal save(Modulos modulos) {
		sessionFactory.getCurrentSession().save(modulos);
		return modulos.getAdModuleId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Modulos> list(BigDecimal adApplicationId) {

		List<Modulos> list = sessionFactory.getCurrentSession().createQuery("from Modulos where adApplicationId = :adApplicationId")
				.setParameter("adApplicationId", adApplicationId).list();
		
		return list;
	}

	@Override
	public void update(Modulos modulos) {
		sessionFactory.getCurrentSession().update(modulos);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		Modulos modulos = session.byId(Modulos.class).load(id);
		session.delete(modulos);
	}
	
}