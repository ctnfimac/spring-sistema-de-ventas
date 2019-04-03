package com.christian.dao;

import java.util.List;

import com.christian.models.Cliente;

public interface ClienteDao {
	List<Cliente> getClientes();
	Cliente getCliente(Long id);
	void addCliente(Cliente cliente);
	void deleteCliente(Cliente cliente);
	void deleteCliente(Long id);
	void updateCliente(Cliente clienteOld, Cliente clienteNew);
	void loadClientes();
	String cambiarEstadoPorId(Long id);
}
