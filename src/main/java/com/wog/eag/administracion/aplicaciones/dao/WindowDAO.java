package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.WindowEntity;

public interface WindowDAO {

	WindowEntity get(BigDecimal id);
	
	BigDecimal save( WindowEntity window );

	void update( WindowEntity window );
	
	void delete( BigDecimal id);
	
	List<WindowEntity> list(BigDecimal parentId);

}