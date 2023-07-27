package com.tasksproject.tasksapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.dto.TareaSaveDTO;
import com.tasksproject.tasksapp.exception.TareaNotFoundException;
import com.tasksproject.tasksapp.mapper.TareaMapper;
import com.tasksproject.tasksapp.model.Tarea;
import com.tasksproject.tasksapp.repository.TareaRepository;

@Service
public class TareaServiceImpl implements TareaService {

	@Autowired
	private TareaRepository tareaRepository;

	@Autowired
	TareaMapper tareaMapper;

	public List<TareaDTO> getAllTareas() {
		// Obtiene todas las tareas de la base de datos
		List<Tarea> tareas = tareaRepository.findAll();

		// Mapea la lista de tareas a una lista de TareaDTO utilizando el TareaMapper
		return tareaMapper.toTareaDTOList(tareas);
	}

	public TareaDTO createTarea(TareaSaveDTO tareaDTO) {
		// Mapea el TareaDTO a una entidad Tarea
		Tarea tarea = tareaMapper.tareaSaveDTOToTarea(tareaDTO);

		// Guarda la nueva tarea en la base de datos y recupera el objeto actualizado
		tarea = tareaRepository.save(tarea);

		// Mapea la entidad Tarea actualizada a un TareaDTO y lo devuelve
		return tareaMapper.tareaToTareaDTO(tarea);
	}

	public void deleteTarea(Long id) {
		// Busca la tarea por su ID en la base de datos
		Optional<Tarea> optionalTarea = tareaRepository.findById(id);

		if (optionalTarea.isPresent()) {
			// Si la tarea existe, la elimina de la base de datos
			tareaRepository.deleteById(id);
		} else {
			// Si la tarea no existe, lanza una excepción de TareaNotFoundException
			throw new TareaNotFoundException("Tarea no encontrada");
		}
	}

	public TareaDTO updateTarea(TareaDTO tareaDTO) {
		// Busca la tarea por su ID en la base de datos
		Optional<Tarea> optionalTarea = tareaRepository.findById(tareaDTO.getId());

		if (optionalTarea.isPresent()) {
			// Si la tarea existe, actualiza los datos de la entidad con los datos del TareaDTO recibido
			Tarea tareaToUpdate = optionalTarea.get();

			tareaToUpdate.setDescripcion(tareaDTO.getDescripcion());
			tareaToUpdate.setFechaCreacion(tareaDTO.getFechaCreacion());
			tareaToUpdate.setVigente(tareaDTO.isVigente());

			// Guarda la tarea actualizada en la base de datos y recupera el objeto actualizado
			Tarea tareaUpdated = tareaRepository.save(tareaToUpdate);

			// Mapea la entidad Tarea actualizada a un TareaDTO y lo devuelve
			return tareaMapper.tareaToTareaDTO(tareaUpdated);
		} else {
			// Si la tarea no existe, lanza una excepción de TareaNotFoundException
			throw new TareaNotFoundException("Tarea no encontrada");
		}
	}
}
