package com.wog.eag.administracion.aplicaciones.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.Modulos;

public interface ModulosService {

	Modulos get(BigDecimal id);
	
	BigDecimal save(Modulos modulos);
	
	void update(BigDecimal id, Modulos modulos);
	
	void delete(BigDecimal id);
	
	List<Modulos> list(BigDecimal adApplicationId);

}