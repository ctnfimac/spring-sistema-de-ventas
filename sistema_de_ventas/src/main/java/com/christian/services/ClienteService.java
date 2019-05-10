package com.christian.services;

import java.util.List;

import com.christian.models.Cliente;
import com.christian.models.Localidad;

public interface ClienteService {
	List<Cliente> getClientes();
	Cliente getCliente(Long id);
	void addCliente(Cliente cliente);
	void deleteCliente(Cliente cliente);
	void deleteCliente(Long id);
	void updateCliente(Cliente clienteOld, Cliente clienteNew);
	void loadClientes();
	String cambiarEstadoPorId(Long id);
	public List<Localidad> obtenerLocalidades();
}
