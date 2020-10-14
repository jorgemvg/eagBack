package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.TabEntity;

public interface TabDAO {

	TabEntity get(BigDecimal id);
	
	BigDecimal save( TabEntity tab );

	void update( TabEntity tab );
	
	void delete( BigDecimal id);
	
	List<TabEntity> list(BigDecimal parentId);

}