package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Pais;
import com.project.repository.PaisRepository;
import com.project.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService{
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public List<Pais> getAll() {
		// TODO Auto-generated method stub
		return this.paisRepository.findAll();
	}

	@Override
	public Pais getById(Long id) {
		// TODO Auto-generated method stub
		return this.paisRepository.findById(id).orElse(null);
	}

	@Override
	public Pais save(Pais pais) {
		// TODO Auto-generated method stub
		return this.paisRepository.save(pais);
	}

	@Override
	public Pais delete(Long id) {
		Pais pais = this.getById(id);
		if (pais !=null) {

		this.paisRepository.delete(pais);	
		}

		return pais;
	}
	

}
