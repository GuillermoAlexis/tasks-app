package com.tasksproject.tasksapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.dto.TareaSaveDTO;
import com.tasksproject.tasksapp.exception.TareaNotFoundException;
import com.tasksproject.tasksapp.service.TareaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController

@RequestMapping("/tareas")
public class TareaController {
	@Autowired
	private TareaService tareaService;

	@Operation(summary = "Lista los valores asociados a las Tareas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Actualizó registros", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)) }),
			@ApiResponse(responseCode = "204", description = "No encontro registros, lista vacia!"),
			@ApiResponse(responseCode = "302", description = "El registro ya existe!"),
			@ApiResponse(responseCode = "500", description = "Error interno, algo no esperado") })
	@GetMapping
	public ResponseEntity<List<TareaDTO>> getAllTareas() {
		List<TareaDTO> tasks = tareaService.getAllTareas();
		return ResponseEntity.ok(tasks);
	}

	@Operation(summary = "Crea una nueva Tarea")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Tarea creada exitosamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = TareaDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
	@PostMapping
	public ResponseEntity<TareaDTO> createTarea(@Valid @RequestBody TareaSaveDTO tareaDTO) {
		TareaDTO createdTarea = tareaService.createTarea(tareaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTarea);
	}

	@Operation(summary = "Actualiza una Tarea existente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Tarea actualizada exitosamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = TareaDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
			@ApiResponse(responseCode = "404", description = "No se encontró la Tarea"),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
	@PutMapping("/{id}")
	public ResponseEntity<TareaDTO> updateTarea(@RequestBody TareaDTO tareaDTO) {
		try {
			TareaDTO updatedTarea = tareaService.updateTarea(tareaDTO);
			return ResponseEntity.ok(updatedTarea);
		} catch (TareaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(summary = "Elimina una Tarea por su ID")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Tarea eliminada exitosamente"),
			@ApiResponse(responseCode = "404", description = "No se encontró la Tarea"),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor") })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTarea(@PathVariable Long id) {
		try {
			tareaService.deleteTarea(id);
			return ResponseEntity.noContent().build();
		} catch (TareaNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
