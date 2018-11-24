package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {

}
