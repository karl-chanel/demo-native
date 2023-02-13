package com.example.controller;

import com.example.entity.User_H2;
import com.example.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl mockUserService;

    @Test
    void testAdd() throws Exception {
        // Setup
        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("user/add")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
        verify(mockUserService).addUser(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1))));
    }

    @Test
    void testList() throws Exception {
        // Setup
        // Configure UserServiceImpl.list(...).
        final List<User_H2> userH2s = List.of(
                new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1))));
        when(mockUserService.list()).thenReturn(userH2s);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("user/list")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testList_UserServiceImplReturnsNoItems() throws Exception {
        // Setup
        when(mockUserService.list()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("user/list")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testFind1() throws Exception {
        // Setup
        // Configure UserServiceImpl.findById(...).
        final User_H2 userH2 = new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)));
        when(mockUserService.findById(0)).thenReturn(userH2);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("user/find/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testFind2() throws Exception {
        // Setup
        // Configure UserServiceImpl.findByName(...).
        final User_H2 userH2 = new User_H2(0, "userName", "address", "phone", Date.valueOf(LocalDate.of(2020, 1, 1)));
        when(mockUserService.findByName("name")).thenReturn(userH2);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("user/find")
                        .param("name", "name")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
