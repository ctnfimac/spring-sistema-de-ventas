package com.christian.dao;

import com.christian.models.Admin;

public interface AdminDao {
	public Admin getAdmin();
	public void addAdmin(Admin admin);
	public void deleteAdmin(Admin admin);
	public void updateAdmin(Admin admin);
}
