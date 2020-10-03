package com.wog.eag.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.model.Aplicacion;

public interface AplicacionDAO {

	Aplicacion get(BigDecimal id);
	
	BigDecimal save( Aplicacion author );
	
	void update( Aplicacion book );
	
	void delete(BigDecimal id);

	List<Aplicacion> list();
	
}