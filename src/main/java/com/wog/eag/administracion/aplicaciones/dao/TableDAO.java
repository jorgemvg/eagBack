package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.TableEntity;

public interface TableDAO {

	TableEntity get(BigDecimal id);
	
	BigDecimal save( TableEntity window );

	void update( TableEntity window );
	
	void delete(BigDecimal id);
	
	List<TableEntity> list(BigDecimal adModuleId);
	
}