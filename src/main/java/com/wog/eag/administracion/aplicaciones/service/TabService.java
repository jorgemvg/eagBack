package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.TabEntity;

public interface TabService {

	TabEntity get(	BigDecimal id);
	
	BigDecimal save( TabEntity tab );

	void update( BigDecimal id, TabEntity tab );
	
	void delete(	BigDecimal id);
	
	List<TabEntity> list(BigDecimal parentId);

}