package com.stevencl.resthr.controller;

import com.stevencl.resthr.model.Manager;
import com.stevencl.resthr.repository.ManagerRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ManagerController.class)
public class ManagerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private ManagerRepository managerRepository;

    Manager manager1 = new Manager("James", "Henry", "jhenry@email.com");
    Manager manager2 = new Manager("Joy", "Thomas", "jthomas@email.com");

    @Test
    void listAllManagers() throws Exception {
        List<Manager> managers = new ArrayList<>(Arrays.asList(manager1, manager2));
        Mockito.when(managerRepository.findAll()).thenReturn(managers);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/managers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].firstName", is(manager2.getFirstName())));
    }

    @Test
    void getManagerSuccess() throws Exception {
        Manager manager = new Manager("Linda", "Carter", "lcarter@domain.com");
        manager.setId(1L);
        Mockito.when(managerRepository.findById(1L)).thenReturn(Optional.of(manager));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/managers/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(manager.getId()), Long.class))
                .andExpect(jsonPath("$.firstName", is(manager.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(manager.getLastName())))
                .andExpect(jsonPath("$.email", is(manager.getEmail())));
    }

    @Test
    void getManagerNotFound() throws Exception {
        Mockito.when(managerRepository.findById(3L)).thenReturn(Optional.empty());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/managers/3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void createManagerSuccess() throws Exception {
        Manager manager = new Manager("Linda", "Carter", "lcarter@domain.com");
        manager.setId(1L);
        Mockito.when(managerRepository.save(manager)).thenReturn(manager);

        String requestBody = "{\"firstName\":\"Linda\",\"lastName\":\"Carter\",\"email\":\"lcarter@domain.com\"}";
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/managers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isCreated());
    }

}
