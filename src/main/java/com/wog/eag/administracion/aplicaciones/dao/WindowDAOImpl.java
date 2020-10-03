package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wog.eag.administracion.aplicaciones.model.Window;

@Repository
public class WindowDAOImpl implements WindowDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Window get(BigDecimal id) {
		return sessionFactory.getCurrentSession().get(Window.class, id);
	}

	@Override
	public BigDecimal save(Window window) {
		sessionFactory.getCurrentSession().save(window);
		return window.getAdModuleId();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Window> list(BigDecimal adModuleId) {

		List<Window> list = sessionFactory.getCurrentSession().createQuery("from Window where adModuleId = :adModuleId")
				.setParameter("adModuleId", adModuleId).list();
		
		return list;
	}

	@Override
	public void update(Window window) {
		sessionFactory.getCurrentSession().update(window);
	}

	@Override
	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		Window window = session.byId(Window.class).load(id);
		session.delete(window);
	}
	
}