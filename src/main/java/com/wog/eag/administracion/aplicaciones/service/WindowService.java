package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.Window;;

public interface WindowService {

	Window get(BigDecimal id);
	
	BigDecimal save(Window window);
	
	void update(BigDecimal id, Window window);
	
	void delete(BigDecimal id);
	
	List<Window> list(BigDecimal adModuleId);

}