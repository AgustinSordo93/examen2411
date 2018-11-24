package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entity.Tarea;

public interface TareaRepository extends JpaRepository <Tarea, Long>{

}
