package com.christian.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.dao.UsuarioDao;
import com.christian.models.Usuario;

@Service("UsuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService{

	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public Usuario getUsuario(String email, String password) {
		return usuarioDao.getUsuario(email, password);
	}

}
