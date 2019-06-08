package com.christian.dao;

import com.christian.models.Usuario;

public interface UsuarioDao {
	Usuario getUsuario(String email, String password);
}
