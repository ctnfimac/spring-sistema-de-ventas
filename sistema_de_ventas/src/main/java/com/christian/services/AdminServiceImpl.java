package com.christian.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.christian.dao.AdminDao;
import com.christian.models.Admin;

@Service("AdminService")
@Transactional
public class AdminServiceImpl implements AdminService{

	@Inject
	private AdminDao servicioAdminDao;
	
	@Override
	public Admin getAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdmin(Admin admin) {
		this.servicioAdminDao.addAdmin(admin);
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
