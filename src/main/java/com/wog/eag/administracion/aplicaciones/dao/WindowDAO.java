package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.Window;;

public interface WindowDAO {

	Window get(BigDecimal id);
	
	BigDecimal save( Window window );

	void update( Window window );
	
	void delete(BigDecimal id);
	
	List<Window> list(BigDecimal adModuleId);
	
}