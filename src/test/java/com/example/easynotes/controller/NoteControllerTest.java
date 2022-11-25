package com.example.easynotes.controller;


import com.example.easynotes.model.Note;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class NoteControllerTest {
    private ObjectMapper objectMapper;
    private final long NOTE_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
    }

    @Test
    @Disabled
    void getAllNotes() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/notes");
        MvcResult result = mockMvc.perform(request).andDo(print()).andReturn();
        assertEquals(2, result.getResponse().getContentAsString().length());
    }

    @Test
    @Disabled
    void createNote() throws Exception {
        Note note = new Note();
        note.setContent("test content");
        note.setTitle("test title");

        this.mockMvc.perform(
                post("/api/notes", note)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(note))
                )
                .andExpect(status().isOk());
    }

    @Test
    @Disabled
    void getNoteById() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/notes/" + NOTE_ID);
        MvcResult result = mockMvc.perform(request).andDo(print()).andReturn();

        String responseBody = result.getResponse().getContentAsString();
        boolean isTrue = responseBody.contains(String.format("\"id\":%d", NOTE_ID));

        assertTrue(isTrue);
    }

    @Test
    @Disabled
    void updateNote() throws Exception {
        Note updatedNote = new Note();
        updatedNote.setTitle("updated title");
        updatedNote.setContent("updated content");

        this.mockMvc.perform(
                        put("/api/notes/" + NOTE_ID, updatedNote)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(this.objectMapper.writeValueAsString(updatedNote))
                )
                .andExpect(status().isOk());
    }

    @Test
    @Disabled
    void deleteNote() throws Exception {
        this.mockMvc.perform(delete("/api/notes/" + NOTE_ID)).andExpect(status().isOk());
    }
}