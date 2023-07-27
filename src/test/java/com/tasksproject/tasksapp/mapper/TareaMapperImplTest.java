package com.tasksproject.tasksapp.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.dto.TareaSaveDTO;
import com.tasksproject.tasksapp.mapper.TareaMapper;
import com.tasksproject.tasksapp.mapper.TareaMapperImpl;
import com.tasksproject.tasksapp.model.Tarea;

class TareaMapperImplTest {

	private final TareaMapper tareaMapper = new TareaMapperImpl();

	@Test
	void testTareaToTareaDTO() {

		Tarea tarea = new Tarea(1L, "Tarea 1", LocalDateTime.now(), true);

		TareaDTO tareaDTO = tareaMapper.tareaToTareaDTO(tarea);

		assertEquals(1L, tareaDTO.getId());
		assertEquals("Tarea 1", tareaDTO.getDescripcion());
		assertTrue(tareaDTO.isVigente());
	}

	@Test
	void testTareaDTOToTarea() {

		TareaDTO tareaDTO = new TareaDTO(1L, "Tarea 1", LocalDateTime.now(), true);

		Tarea tarea = tareaMapper.tareaDTOToTarea(tareaDTO);

		assertEquals(1L, tarea.getId());
		assertEquals("Tarea 1", tarea.getDescripcion());
		assertTrue(tarea.isVigente());
	}

	@Test
	void testToTareaDTOList() {

		List<Tarea> tareas = Arrays.asList(new Tarea(1L, "Tarea 1", LocalDateTime.now(), true),
				new Tarea(2L, "Tarea 2", LocalDateTime.now(), false));

		List<TareaDTO> tareaDTOs = tareaMapper.toTareaDTOList(tareas);

		assertEquals(2, tareaDTOs.size());
		assertEquals(1L, tareaDTOs.get(0).getId());
		assertEquals("Tarea 1", tareaDTOs.get(0).getDescripcion());
		assertEquals(true, tareaDTOs.get(0).isVigente());
		assertEquals(2L, tareaDTOs.get(1).getId());
		assertEquals("Tarea 2", tareaDTOs.get(1).getDescripcion());
		assertEquals(false, tareaDTOs.get(1).isVigente());
	}

	@Test
	void testToTareaList() {

		List<TareaDTO> tareaDTOs = Arrays.asList(new TareaDTO(1L, "Tarea 1", LocalDateTime.now(), true),
				new TareaDTO(2L, "Tarea 2", LocalDateTime.now(), false));

		List<Tarea> tareas = tareaMapper.toTareaList(tareaDTOs);

		assertEquals(2, tareas.size());
		assertEquals(1L, tareas.get(0).getId());
		assertEquals("Tarea 1", tareas.get(0).getDescripcion());
		assertEquals(true, tareas.get(0).isVigente());
		assertEquals(2L, tareas.get(1).getId());
		assertEquals("Tarea 2", tareas.get(1).getDescripcion());
		assertEquals(false, tareas.get(1).isVigente());
	}

	@Test
	void testTareaSaveDTOToTarea() {

		TareaSaveDTO tareaSaveDTO = new TareaSaveDTO();

		Tarea tarea = tareaMapper.tareaSaveDTOToTarea(tareaSaveDTO);

		assertNull(tarea.getId());
		assertEquals("Nueva tarea", tarea.getDescripcion());
		assertTrue(tarea.isVigente());
	}
}
