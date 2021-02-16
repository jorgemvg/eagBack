package com.wog.eag.administracion.aplicaciones.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Primary
@Transactional
@Repository
public class ModulosChildDAOImpl extends ModulosDAOImpl implements ModulosChildDAO {

	
}