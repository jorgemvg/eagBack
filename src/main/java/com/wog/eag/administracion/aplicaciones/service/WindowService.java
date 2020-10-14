package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.WindowEntity;

public interface WindowService {

	WindowEntity get(	BigDecimal id);
	
	BigDecimal save( WindowEntity window );

	void update( BigDecimal id, WindowEntity window );
	
	void delete(	BigDecimal id);
	
	List<WindowEntity> list(BigDecimal parentId);

}