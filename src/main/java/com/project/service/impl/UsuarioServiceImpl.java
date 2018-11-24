package com.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Usuario;
import com.project.repository.UsuarioRepository;
import com.project.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario delete(Long id) {
		Usuario usuario = this.getById(id);
		if (usuario !=null) {

		this.usuarioRepository.delete(usuario);	
		}

		return usuario;
	}
}
