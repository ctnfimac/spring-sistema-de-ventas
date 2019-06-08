package com.christian.services;

import com.christian.models.Usuario;

public interface UsuarioService {
	Usuario getUsuario(String email, String password);
}
