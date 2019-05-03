package com.christian.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.christian.models.Admin;

@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Admin getAdmin(String usuario, String password) {
		Session session = sessionFactory.getCurrentSession();
		Admin admin = null;
		admin = (Admin) session.createCriteria(Admin.class)
				.add(Restrictions.and(Restrictions.eq("usuario", usuario),Restrictions.eq("password",password)))
				.uniqueResult();
				
		return admin;
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
