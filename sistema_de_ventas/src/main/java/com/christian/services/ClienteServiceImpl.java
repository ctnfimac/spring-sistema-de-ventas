package com.christian.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.dao.ClienteDao;
import com.christian.models.Cliente;
import com.christian.models.Localidad;

@Service("ClienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Inject
	private ClienteDao clienteDao;
	
	@Override
	public void loadClientes() {
		clienteDao.loadClientes();
	}

	@Override
	public List<Cliente> getClientes() {
		return clienteDao.getClientes();
	}

	@Override
	public Cliente getCliente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCliente(Cliente cliente) {
		clienteDao.addCliente(cliente);
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCliente(Long id) {
		clienteDao.deleteCliente(id);
	}

	@Override
	public void updateCliente(Cliente clienteOld, Cliente clienteNew) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String cambiarEstadoPorId(Long id) {
		return clienteDao.cambiarEstadoPorId(id);
	}

	@Override
	public List<Localidad> obtenerLocalidades() {
		return clienteDao.obtenerLocalidades();
	}

}
