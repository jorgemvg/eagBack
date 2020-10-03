package com.wog.eag.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wog.eag.model.Aplicacion;

@Repository
public class AplicacionDAOImpl implements AplicacionDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Aplicacion get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(Aplicacion.class, id);
	}
	
	@Override
	public BigDecimal save(Aplicacion author) {
		sessionFactory.getCurrentSession().save(author);
		return author.getAdApplicationId();
	}

	@Override
	public void update(Aplicacion author) {
		sessionFactory.getCurrentSession().update(author);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		Aplicacion author = session.byId(Aplicacion.class).load(id);
		session.delete(author);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Aplicacion> list() {

		List<Aplicacion> list = sessionFactory.getCurrentSession().createQuery("from Aplicacion").list();
		
		return list;
	}
	
}