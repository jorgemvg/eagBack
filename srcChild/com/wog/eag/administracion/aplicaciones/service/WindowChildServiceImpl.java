package com.wog.eag.administracion.aplicaciones.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wog.eag.administracion.aplicaciones.dao.WindowChildDAOImpl;

@Service
public class WindowChildServiceImpl extends WindowServiceImpl implements WindowChildService {

	@Autowired
	private WindowChildDAOImpl windowDao;
	

}