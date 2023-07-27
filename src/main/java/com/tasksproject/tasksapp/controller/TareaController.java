package com.tasksproject.tasksapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasksproject.tasksapp.dto.TareaDTO;
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

	@Operation(summary = "TRX 1 - Lista los valores asociados a las Tareas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Actualizó registros", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Integer.class)) }),
			@ApiResponse(responseCode = "204", description = "No encontro registros, lista vacia!"),
			@ApiResponse(responseCode = "302", description = "El registro ya existe!"),
			@ApiResponse(responseCode = "500", description = "Error interno, algo no esperado") })
	@GetMapping(path = "/trx/1")
	public ResponseEntity<List<TareaDTO>> getAllTareas() {
		List<TareaDTO> tasks = tareaService.getAllTareas();
		return ResponseEntity.ok(tasks);
	}

}
