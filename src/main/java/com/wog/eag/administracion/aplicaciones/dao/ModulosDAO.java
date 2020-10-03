package com.wog.eag.administracion.aplicaciones.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.administracion.aplicaciones.model.Modulos;

public interface ModulosDAO {

	Modulos get(BigDecimal id);
	
	BigDecimal save( Modulos modulos );

	void update( Modulos modulos );
	
	void delete(BigDecimal id);
	
	List<Modulos> list(BigDecimal adApplicationId);
	
}