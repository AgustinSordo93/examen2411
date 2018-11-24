package com.project.service;

import java.util.List;

import com.project.entity.Pais;


public interface PaisService {

	public List<Pais> getAll();
	public Pais getById(Long id);
	public Pais save(Pais pais);
	public Pais delete (Long id);
	
	

}
