package com.tasksproject.tasksapp.service;

import java.util.List;

import com.tasksproject.tasksapp.dto.TareaDTO;

public interface TareaService {
	// Listar tareas
	List<TareaDTO> getAllTareas();

	// Agregar una tarea
	TareaDTO createTarea(TareaDTO taskDTO);

	// Remover una tarea
	void deleteTarea(Long id);

	// Editar una tarea
	TareaDTO updateTarea(Long id, TareaDTO taskDTO);
}
