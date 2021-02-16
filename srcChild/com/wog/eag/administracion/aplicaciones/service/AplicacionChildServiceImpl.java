package com.wog.eag.administracion.aplicaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.AplicacionChildDAOImpl;

@Service
public class AplicacionChildServiceImpl extends AplicacionServiceImpl implements AplicacionChildService {

	@Autowired
	private AplicacionChildDAOImpl aplicacionDao;
	

}