package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ToolbarChildDAOImpl extends ToolbarDAOImpl {

	public BigDecimal getAdTabToolbarId( BigDecimal adTabId, String screenType ) {

		Object adTabToolbarId = sessionFactory.getCurrentSession().createNativeQuery(
				"SELECT DISTINCT AD_TAB_TOOLBAR_ID FROM AD_TAB_TOOLBAR WHERE AD_TAB_ID = :adTabId AND SCREEN_TYPE = :screenType")
					.setParameter("adTabId", adTabId)
					.setParameter("screenType", screenType)
					.uniqueResult();
		
		return (BigDecimal)adTabToolbarId;
	}
	
}