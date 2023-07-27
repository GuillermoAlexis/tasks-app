package com.tasksproject.tasksapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasksproject.tasksapp.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
