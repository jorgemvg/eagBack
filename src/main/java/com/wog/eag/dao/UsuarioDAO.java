package com.wog.eag.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wog.eag.model.Usuario;

@Repository
public class UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public BigDecimal save(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
		return usuario.getAdUserId();
	}

	public Usuario get(BigDecimal adUserId) {
		return sessionFactory.getCurrentSession().get(Usuario.class, adUserId);
	}

	public List<Usuario> list() {
		List<Usuario> list = sessionFactory.getCurrentSession().createQuery("from Usuario").list();
		return list;
	}

	public void update(BigDecimal id, Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
//		Aplicacion oldAuthor = session.byId(Aplicacion.class).load(id);
//		oldAuthor.setFirstName(author.getFirstName() );
//		oldAuthor.setLastName(author.getLastName());
//		oldAuthor.setPhoneNumber(author.getPhoneNumber());
//		oldAuthor.setBornDate(author.getBornDate());
//		oldAuthor.setCity(author.getCity());
		session.flush();
	}

	public void delete(BigDecimal id) {
		Session session = sessionFactory.getCurrentSession();
		Usuario usuario = session.byId(Usuario.class).load(id);
		session.delete(usuario);
	}

	public boolean exists( BigDecimal adUserId ) {

		boolean exists = false;
		Object object = sessionFactory.getCurrentSession().createQuery("select count(1) from Usuario where ad_user_id = :id")
				.setParameter("id", adUserId)
				.uniqueResult();
		
		if ( object != null ) {
			long count = (Long)object;
			if (count > 0 ) exists = true;
		}
		
		return exists;
	}
	
	public Usuario getUsuarioByUsername(String username) {
		Usuario usuario = (Usuario)sessionFactory.getCurrentSession().createQuery("FROM Usuario WHERE username = :username").setParameter("username", username).uniqueResult();
		return usuario;
	}
	
}
