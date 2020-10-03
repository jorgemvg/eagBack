package com.wog.eag.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.model.Aplicacion;

public interface AplicacionService {

	Aplicacion get(BigDecimal id);
	
	BigDecimal save(Aplicacion aplicacion);

	void update(BigDecimal id, Aplicacion aplicacion);

	void delete(BigDecimal id);
	
	List<Aplicacion> list();

}