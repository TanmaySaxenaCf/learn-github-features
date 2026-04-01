package com.example.taskmanager;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        taskRepository.deleteAll();
    }

    @Test
    void shouldCreateTask() throws Exception {
        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("A test task description");

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Task"))
                .andExpect(jsonPath("$.status").value("TODO"));
    }

    @Test
    void shouldGetAllTasks() throws Exception {
        Task task = new Task();
        task.setTitle("Task 1");
        taskRepository.save(task);

        mockMvc.perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value("Task 1"));
    }

    @Test
    void shouldGetTaskById() throws Exception {
        Task task = new Task();
        task.setTitle("Find Me");
        Task saved = taskRepository.save(task);

        mockMvc.perform(get("/api/tasks/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Find Me"));
    }

    @Test
    void shouldReturn404ForMissingTask() throws Exception {
        mockMvc.perform(get("/api/tasks/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldUpdateTask() throws Exception {
        Task task = new Task();
        task.setTitle("Original");
        Task saved = taskRepository.save(task);

        saved.setTitle("Updated");
        saved.setStatus(Task.Status.IN_PROGRESS);

        mockMvc.perform(put("/api/tasks/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated"))
                .andExpect(jsonPath("$.status").value("IN_PROGRESS"));
    }

    @Test
    void shouldDeleteTask() throws Exception {
        Task task = new Task();
        task.setTitle("Delete Me");
        Task saved = taskRepository.save(task);

        mockMvc.perform(delete("/api/tasks/" + saved.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/api/tasks/" + saved.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldRejectBlankTitle() throws Exception {
        Task task = new Task();
        task.setTitle("");

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldCreateTaskWithDueDateAndPriority() throws Exception {
        Task task = new Task();
        task.setTitle("Priority Task");
        task.setDueDate(LocalDate.of(2026, 12, 31));
        task.setPriority(Task.Priority.HIGH);

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Priority Task"))
                .andExpect(jsonPath("$.dueDate").value("2026-12-31"))
                .andExpect(jsonPath("$.priority").value("HIGH"));
    }

    @Test
    void shouldGetTasksByPriority() throws Exception {
        Task highTask = new Task();
        highTask.setTitle("High Priority");
        highTask.setPriority(Task.Priority.HIGH);
        taskRepository.save(highTask);

        Task lowTask = new Task();
        lowTask.setTitle("Low Priority");
        lowTask.setPriority(Task.Priority.LOW);
        taskRepository.save(lowTask);

        mockMvc.perform(get("/api/tasks/priority/HIGH"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value("High Priority"))
                .andExpect(jsonPath("$[0].priority").value("HIGH"));
    }

    @Test
    void shouldGetOverdueTasks() throws Exception {
        Task overdueTask = new Task();
        overdueTask.setTitle("Overdue Task");
        overdueTask.setDueDate(LocalDate.now().minusDays(1));
        overdueTask.setStatus(Task.Status.TODO);
        taskRepository.save(overdueTask);

        Task futureTask = new Task();
        futureTask.setTitle("Future Task");
        futureTask.setDueDate(LocalDate.now().plusDays(10));
        futureTask.setStatus(Task.Status.TODO);
        taskRepository.save(futureTask);

        Task doneTask = new Task();
        doneTask.setTitle("Done Task");
        doneTask.setDueDate(LocalDate.now().minusDays(5));
        doneTask.setStatus(Task.Status.DONE);
        taskRepository.save(doneTask);

        mockMvc.perform(get("/api/tasks/overdue"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title").value("Overdue Task"));
    }

    @Test
    void shouldUpdateTaskWithDueDateAndPriority() throws Exception {
        Task task = new Task();
        task.setTitle("Original");
        Task saved = taskRepository.save(task);

        saved.setTitle("Updated");
        saved.setDueDate(LocalDate.of(2026, 6, 15));
        saved.setPriority(Task.Priority.CRITICAL);

        mockMvc.perform(put("/api/tasks/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Updated"))
                .andExpect(jsonPath("$.dueDate").value("2026-06-15"))
                .andExpect(jsonPath("$.priority").value("CRITICAL"));
    }
}
