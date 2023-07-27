package com.tasksproject.tasksapp.service;

import java.util.List;

import javax.validation.Valid;

import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.dto.TareaSaveDTO;

public interface TareaService {
	// Listar tareas
	List<TareaDTO> getAllTareas();

	// Agregar una tarea
	TareaDTO createTarea(@Valid TareaSaveDTO tareaDTO);

	// Remover una tarea
	void deleteTarea(Long id);

	// Editar una tarea
	TareaDTO updateTarea(TareaDTO taskDTO);
}
