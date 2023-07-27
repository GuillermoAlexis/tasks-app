package com.tasksproject.tasksapp.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.model.Tarea;

@Component
public class TareaMapperImpl implements TareaMapper {

	public TareaDTO tareaToTareaDTO(Tarea tarea) {
		if (tarea == null) {
			return null;
		}

		TareaDTO tareaDTO = new TareaDTO();
		tareaDTO.setId(tarea.getId());
		tareaDTO.setDescripcion(tarea.getDescripcion());
		tareaDTO.setFechaCreacion(tarea.getFechaCreacion());
		tareaDTO.setVigente(tarea.isVigente());
		return tareaDTO;
	}

	public Tarea tareaDTOToTarea(TareaDTO tareaDTO) {
		if (tareaDTO == null) {
			return null;
		}

		Tarea tarea = new Tarea();
		tarea.setId(tareaDTO.getId());
		tarea.setDescripcion(tareaDTO.getDescripcion());
		tarea.setFechaCreacion(tareaDTO.getFechaCreacion());
		tarea.setVigente(tareaDTO.isVigente());
		return tarea;
	}

	public List<TareaDTO> toTareaDTOList(List<Tarea> tareas) {
		if (tareas == null) {
			return null;
		}

		return tareas.stream().map(this::tareaToTareaDTO).collect(Collectors.toList());
	}

	public List<Tarea> toTareaList(List<TareaDTO> tareaDTOs) {
		if (tareaDTOs == null) {
			return null;
		}

		return tareaDTOs.stream().map(this::tareaDTOToTarea).collect(Collectors.toList());
	}

}
