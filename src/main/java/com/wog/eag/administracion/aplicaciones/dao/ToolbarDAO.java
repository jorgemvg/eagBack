package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.ToolbarPk;
import com.wog.eag.administracion.aplicaciones.model.ToolbarEntity;

public interface ToolbarDAO {

	ToolbarEntity get(BigDecimal id);
	
	BigDecimal save( ToolbarEntity toolbar );

	void update( ToolbarEntity toolbar );
	
	void delete(ToolbarPk pk);
	
	List<ToolbarEntity> list(BigDecimal parentId);

}