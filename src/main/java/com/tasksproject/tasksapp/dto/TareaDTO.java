package com.tasksproject.tasksapp.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareaDTO {
	@NotEmpty(message = "El ID es obligatorio")
	@NotBlank(message = "El ID es obligatorio")
	@NotNull(message = "El ID es obligatorio")
	private Long id;

	@NotEmpty(message = "La descripción es obligatoria")
	@NotBlank(message = "La descripción es obligatoria")
	@NotNull(message = "La descripción es obligatoria")
	private String descripcion;

	@NotEmpty(message = "La fecha de creación es obligatoria")
	@NotBlank(message = "La fecha de creación es obligatoria")
	@NotNull(message = "La fecha de creación es obligatoria")

	private LocalDateTime fechaCreacion;

	@NotEmpty(message = "El campo vigente es obligatorio")
	@NotBlank(message = "El campo vigente es obligatorio")
	@NotNull(message = "El campo vigente es obligatorio")
	private boolean vigente;
}
