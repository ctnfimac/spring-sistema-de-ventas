package com.christian.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.dao.ClienteDao;

@Service("ClienteService")
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Inject
	private ClienteDao clienteDao;
	
	@Override
	public void loadClientes() {
		clienteDao.loadClientes();
	}

}
