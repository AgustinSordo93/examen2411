package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.entity.Tarea;
import com.project.entity.Usuario;
import com.project.repository.TareaRepository;
import com.project.repository.UsuarioRepository;
import com.project.service.TareaService;

public class TareaServiceImpl implements TareaService {

	@Autowired
	private TareaRepository tareaRepository;
	
	@Override
	public List<Tarea> getAll() {
		// TODO Auto-generated method stub
		return this.tareaRepository.findAll();
	}

	@Override
	public Tarea getById(Long id) {
		// TODO Auto-generated method stub
		return this.tareaRepository.findById(id).orElse(null);
	}

	@Override
	public Tarea save(Tarea tarea) {
		// TODO Auto-generated method stub
		return this.tareaRepository.save(tarea);
	}

	@Override
	public Tarea delete(Long id) {
		Tarea tarea = this.getById(id);
		if (tarea !=null) {

		this.tareaRepository.delete(tarea);	
		}

		return tarea;
	}

}
