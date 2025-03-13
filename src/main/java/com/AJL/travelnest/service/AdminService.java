package com.AJL.travelnest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AJL.travelnest.entity.Admin;
import com.AJL.travelnest.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adrepo;
	
	public void registrar(Admin admin) {
		adrepo.save(admin);
	}
	
	public List<Admin> lsitarAdmin(){
		return adrepo.findAll();
	}
	
}
