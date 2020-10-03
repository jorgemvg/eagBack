package com.wog.eag.service;

import java.math.BigDecimal;
import java.util.List;

import com.wog.eag.model.Usuario;

public interface UsuarioService {

	BigDecimal save(Usuario author);

	Usuario get(BigDecimal id);

	List<Usuario> list();

	void update(BigDecimal id, Usuario aplicacion);

	void delete(BigDecimal id);

	boolean exists(long id);
	
	public Usuario getUsuarioByUsername(String username);

}
