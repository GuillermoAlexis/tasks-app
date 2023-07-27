package com.tasksproject.tasksapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.model.Tarea;

@Mapper
public interface TareaMapper {

	TareaDTO tareaToTareaDTO(Tarea tarea);

	Tarea tareaDTOToTarea(TareaDTO tareaDTO);

	List<TareaDTO> toTareaDTOList(List<Tarea> tareas);

	List<Tarea> toTareaList(List<TareaDTO> tareaDTOs);

}
