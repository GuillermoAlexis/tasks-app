package com.tasksproject.tasksapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDTO {
	private Long id;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private boolean vigente;

}
