package com.christian.dao;

import org.springframework.stereotype.Repository;

import com.christian.models.Admin;

public interface AdminDao {
	public Admin getAdmin(String usuario, String password);
	public void addAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
	public void updateAdmin(Admin admin);
}
