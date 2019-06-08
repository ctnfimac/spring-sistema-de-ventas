package com.christian.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.christian.models.Usuario;

@Repository("UsuarioDao")
public class UsuarioDaoImpl implements UsuarioDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Usuario getUsuario(String email, String password) {
		final Session session = sessionFactory.getCurrentSession();
		Usuario usuario = null;
		usuario = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.and(Restrictions.eq("email",email),Restrictions.eq("password", password)))
				.uniqueResult();
		return usuario;
	}
	
}
