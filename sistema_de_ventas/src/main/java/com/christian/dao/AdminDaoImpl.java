package com.christian.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.christian.models.Admin;
import com.christian.models.Cliente;
import com.christian.models.Repartidor;


@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Admin getAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdmin(Admin admin) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(admin);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		
	}

}
