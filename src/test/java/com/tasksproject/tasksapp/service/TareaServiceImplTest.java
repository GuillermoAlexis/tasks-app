package com.tasksproject.tasksapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.dto.TareaSaveDTO;
import com.tasksproject.tasksapp.exception.TareaNotFoundException;
import com.tasksproject.tasksapp.mapper.TareaMapper;
import com.tasksproject.tasksapp.model.Tarea;
import com.tasksproject.tasksapp.repository.TareaRepository;
import com.tasksproject.tasksapp.service.TareaServiceImpl;

class TareaServiceImplTest {

	@Mock
	private TareaRepository tareaRepository;

	@Mock
	private TareaMapper tareaMapper;

	@InjectMocks
	private TareaServiceImpl tareaService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetAllTareas() {

		List<Tarea> tareas = Arrays.asList(new Tarea(1L, "Tarea 1", LocalDateTime.now(), true),
				new Tarea(2L, "Tarea 2", LocalDateTime.now(), false));

		List<TareaDTO> tareaDTOs = Arrays.asList(new TareaDTO(1L, "Tarea 1", LocalDateTime.now(), true),
				new TareaDTO(2L, "Tarea 2", LocalDateTime.now(), false));

		when(tareaRepository.findAll()).thenReturn(tareas);
		when(tareaMapper.toTareaDTOList(tareas)).thenReturn(tareaDTOs);

		List<TareaDTO> result = tareaService.getAllTareas();

		assertEquals(2, result.size());
		assertEquals(1L, result.get(0).getId());
		assertEquals("Tarea 1", result.get(0).getDescripcion());
		assertEquals(true, result.get(0).isVigente());
		assertEquals(2L, result.get(1).getId());
		assertEquals("Tarea 2", result.get(1).getDescripcion());
		assertEquals(false, result.get(1).isVigente());
	}

	@Test
	void testCreateTarea() {

		TareaSaveDTO tareaSaveDTO = new TareaSaveDTO();

		Tarea tareaToSave = new Tarea(null, "Nueva tarea", LocalDateTime.now(), true);
		Tarea tareaSaved = new Tarea(1L, "Nueva tarea", LocalDateTime.now(), true);

		TareaDTO tareaDTOToSave = new TareaDTO(null, "Nueva tarea", LocalDateTime.now(), true);
		TareaDTO tareaDTOSaved = new TareaDTO(1L, "Nueva tarea", LocalDateTime.now(), true);

		when(tareaMapper.tareaSaveDTOToTarea(tareaSaveDTO)).thenReturn(tareaToSave);
		when(tareaRepository.save(tareaToSave)).thenReturn(tareaSaved);
		when(tareaMapper.tareaToTareaDTO(tareaSaved)).thenReturn(tareaDTOSaved);

		TareaDTO result = tareaService.createTarea(tareaSaveDTO);

		assertEquals(1L, result.getId());
		assertEquals("Nueva tarea", result.getDescripcion());
		assertEquals(true, result.isVigente());
	}

	@Test
	void testDeleteTarea_ExistingTarea_ShouldDelete() {

		Long id = 1L;
		Tarea tareaToDelete = new Tarea(id, "Tarea a eliminar", LocalDateTime.now(), true);

		when(tareaRepository.findById(id)).thenReturn(Optional.of(tareaToDelete));

		tareaService.deleteTarea(id);

		verify(tareaRepository, times(1)).deleteById(id);
	}

	@Test
	void testDeleteTarea_NonExistingTarea_ShouldThrowTareaNotFoundException() {

		Long id = 1L;

		when(tareaRepository.findById(id)).thenReturn(Optional.empty());

		assertThrows(TareaNotFoundException.class, () -> tareaService.deleteTarea(id));
	}

	@Test
	void testUpdateTarea_ExistingTarea_ShouldUpdate() {

		TareaDTO tareaDTOToUpdate = new TareaDTO(1L, "Tarea actualizada", LocalDateTime.now(), false);
		Tarea tareaToUpdate = new Tarea(1L, "Tarea original", LocalDateTime.now(), true);
		Tarea tareaUpdated = new Tarea(1L, "Tarea actualizada", LocalDateTime.now(), false);

		when(tareaRepository.findById(tareaDTOToUpdate.getId())).thenReturn(Optional.of(tareaToUpdate));
		when(tareaRepository.save(tareaToUpdate)).thenReturn(tareaUpdated);
		when(tareaMapper.tareaToTareaDTO(tareaUpdated)).thenReturn(tareaDTOToUpdate);

		TareaDTO result = tareaService.updateTarea(tareaDTOToUpdate);

		assertEquals(1L, result.getId());
		assertEquals("Tarea actualizada", result.getDescripcion());
		assertEquals(false, result.isVigente());
	}

	@Test
	void testUpdateTarea_NonExistingTarea_ShouldThrowTareaNotFoundException() {

		TareaDTO tareaDTOToUpdate = new TareaDTO(1L, "Tarea actualizada", LocalDateTime.now(), false);

		when(tareaRepository.findById(tareaDTOToUpdate.getId())).thenReturn(Optional.empty());

		assertThrows(TareaNotFoundException.class, () -> tareaService.updateTarea(tareaDTOToUpdate));
	}
}
