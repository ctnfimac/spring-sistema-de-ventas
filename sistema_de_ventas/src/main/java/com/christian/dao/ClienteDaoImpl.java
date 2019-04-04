package com.christian.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.christian.models.Cliente;
import com.christian.models.Localidad;

@Repository("ClienteDao")
public class ClienteDaoImpl implements ClienteDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cliente> getClientes() {
		List<Cliente> clientes = null;
		clientes = sessionFactory.getCurrentSession().createCriteria(Cliente.class).list();
		return clientes;
	}

	@Override
	public Cliente getCliente(Long id) {
		Cliente cliente = null;
		cliente = (Cliente) sessionFactory.getCurrentSession()
				.createCriteria(Cliente.class)
				.add(Restrictions.eq("id",id))
				.list();
		return cliente;
	}

	@Override
	public void addCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCliente(Cliente cliente) {
		sessionFactory.getCurrentSession()
			.delete(cliente);
	}

	@Override
	public void deleteCliente(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Cliente cliente = (Cliente) session.createCriteria(Cliente.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		session.delete(cliente);	
	}

	@Override
	public void updateCliente(Cliente clienteOld, Cliente clienteNew) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadClientes() {
		Session session = sessionFactory.getCurrentSession();
		
		Localidad localidad1 = new Localidad("Villa luzuriaga"),
				  localidad2 = new Localidad("Liniers");
		
		Cliente cliente1 = new Cliente("Tom Y Jerry", "tomyjerry@gmail.com", "tom", "habilitado",
										"venezuela", "5500", localidad1);
		
		Cliente cliente2 = new Cliente("Dunka", "dunka@gmail.com", "dun", "deshabilitado",
				"las tunas", "11122", localidad2);
		
		session.save(localidad1);
		session.save(localidad2);
		session.save(cliente1);
		session.save(cliente2);
//		session.close();
	}

	@Override
	public String cambiarEstadoPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		
		Cliente cliente = (Cliente) session.createCriteria(Cliente.class)
				.add(Restrictions.eq("id",id)).uniqueResult();
		
		String estadoActual = cliente.getEstado();
		
		if(estadoActual.equals("habilitado")) cliente.setEstado("deshabilitado");
		else cliente.setEstado("habilitado");
		
		session.update(cliente);
		
		return cliente.getEstado();
	}

}
