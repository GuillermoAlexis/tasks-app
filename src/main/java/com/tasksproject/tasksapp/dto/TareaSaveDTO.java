package com.tasksproject.tasksapp.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TareaSaveDTO {

	@NotEmpty(message = "La descripción es obligatoria")
	@NotBlank(message = "La descripción es obligatoria")
	@NotNull(message = "La descripción es obligatoria")
	private String descripcion;

	@NotNull(message = "La fecha de creación es obligatoria")
	private LocalDateTime fechaCreacion;

	@NotNull(message = "El campo vigente es obligatorio")
	private boolean vigente;
}
