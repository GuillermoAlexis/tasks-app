package com.tasksproject.tasksapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasksproject.tasksapp.dto.TareaDTO;
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
		List<Tarea> tareas = tareaRepository.findAll();

		return tareaMapper.toTareaDTOList(tareas);
	}

	public TareaDTO createTarea(TareaDTO tareaDTO) {
		Tarea tarea = tareaMapper.tareaDTOToTarea(tareaDTO);
		tarea = tareaRepository.save(tarea);
		return tareaMapper.tareaToTareaDTO(tarea);
	}

	@Override
	public void deleteTarea(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public TareaDTO updateTarea(Long id, TareaDTO taskDTO) {
		// TODO Auto-generated method stub
		return null;
	}

}
