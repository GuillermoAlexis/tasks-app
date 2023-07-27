package com.tasksproject.tasksapp.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasksproject.tasksapp.dto.TareaDTO;
import com.tasksproject.tasksapp.dto.TareaSaveDTO;
import com.tasksproject.tasksapp.service.TareaService;

@WebMvcTest(TareaController.class)
public class TareaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TareaService tareaService;

    private List<TareaDTO> tareaList;

    @BeforeEach
    public void setup() {
        TareaDTO tarea1 = new TareaDTO(1L, "Tarea 1", LocalDateTime.now(), true);
        TareaDTO tarea2 = new TareaDTO(2L, "Tarea 2", LocalDateTime.now(), false);
        tareaList = new ArrayList<>();
        tareaList.add(tarea1);
        tareaList.add(tarea2);
    }

    @Test
    public void testGetAllTareas() throws Exception {
        when(tareaService.getAllTareas()).thenReturn(tareaList);

        mockMvc.perform(get("/tareas"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].descripcion").value("Tarea 1"))
                .andExpect(jsonPath("$[0].fechaCreacion").exists())
                .andExpect(jsonPath("$[0].vigente").value(true))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].descripcion").value("Tarea 2"))
                .andExpect(jsonPath("$[1].fechaCreacion").exists())
                .andExpect(jsonPath("$[1].vigente").value(false));

        verify(tareaService, times(1)).getAllTareas();
        verifyNoMoreInteractions(tareaService);
    }

    @Test
    public void testCreateTarea() throws Exception {
        TareaSaveDTO tareaSaveDTO = new TareaSaveDTO("Nueva Tarea", LocalDateTime.now(), true);
        TareaDTO tareaDTO = new TareaDTO(3L, tareaSaveDTO.getDescripcion(), tareaSaveDTO.getFechaCreacion(), tareaSaveDTO.isVigente());

        when(tareaService.createTarea(any(TareaSaveDTO.class))).thenReturn(tareaDTO);

        mockMvc.perform(post("/tareas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tareaSaveDTO)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.descripcion").value("Nueva Tarea"))
                .andExpect(jsonPath("$.fechaCreacion").exists())
                .andExpect(jsonPath("$.vigente").value(true));

        verify(tareaService, times(1)).createTarea(any(TareaSaveDTO.class));
        verifyNoMoreInteractions(tareaService);
    }

    @Test
    public void testUpdateTarea() throws Exception {
        TareaDTO tareaDTO = new TareaDTO(4L, "Tarea Actualizada", LocalDateTime.now(), false);

        when(tareaService.updateTarea(any(TareaDTO.class))).thenReturn(tareaDTO);

        mockMvc.perform(put("/tareas/{id}", 4L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tareaDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(4))
                .andExpect(jsonPath("$.descripcion").value("Tarea Actualizada"))
                .andExpect(jsonPath("$.fechaCreacion").exists())
                .andExpect(jsonPath("$.vigente").value(false));

        verify(tareaService, times(1)).updateTarea(any(TareaDTO.class));
        verifyNoMoreInteractions(tareaService);
    }

    @Test
    public void testDeleteTarea() throws Exception {
        mockMvc.perform(delete("/tareas/{id}", 5L))
                .andExpect(status().isNoContent());

        verify(tareaService, times(1)).deleteTarea(5L);
        verifyNoMoreInteractions(tareaService);
    }
}
