package com.tasksproject.tasksapp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarea")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tarea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotEmpty
	@NotNull
	@NotBlank
	@Column(name = "id")
	private Long id;

	@NotEmpty
	@NotNull
	@NotBlank
	@Column(name = "descripcion")
	private String descripcion;

	@NotEmpty
	@NotNull
	@NotBlank
	@Column(name = "fechaCreacion")
	private LocalDateTime fechaCreacion;

	@NotEmpty
	@NotNull
	@NotBlank
	@Column(name = "vigente")
	private boolean vigente;
}
