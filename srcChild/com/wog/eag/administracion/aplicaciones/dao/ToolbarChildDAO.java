package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;

public interface ToolbarChildDAO extends ToolbarDAO {

	public BigDecimal getAdTabToolbarId( BigDecimal adTabId, String screenType );
	
}
