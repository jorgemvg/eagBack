package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.ToolbarEntity;

public interface ToolbarService {

	ToolbarEntity get(String parameters);
	
	BigDecimal save( ToolbarEntity toolbar );

	void update( BigDecimal id, ToolbarEntity toolbar );
	
	void delete(String parameters);
	
	List<ToolbarEntity> list(BigDecimal parentId);

}