package com.christian.services;

import com.christian.models.Admin;

public interface AdminService {
	Admin getAdmin(String usuario, String password);
	void addAdmin(Admin admin);
	void deleteAdmin(Admin admin);
	void updateAdmin(Admin admin);
}
