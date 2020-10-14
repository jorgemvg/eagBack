package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class ToolbarChildDAOImpl extends ToolbarDAOImpl implements ToolbarChildDAO {

	public BigDecimal getAdTabToolbarId( BigDecimal adTabId, String screenType ) {

		Object adTabToolbarId = sessionFactory.getCurrentSession().createNativeQuery(
				"SELECT DISTINCT AD_TAB_TOOLBAR_ID FROM AD_TAB_TOOLBAR WHERE AD_TAB_ID = :adTabId AND SCREEN_TYPE = :screenType")
					.setParameter("adTabId", adTabId)
					.setParameter("screenType", screenType)
					.uniqueResult();
		
		return (BigDecimal)adTabToolbarId;
	}
	
}