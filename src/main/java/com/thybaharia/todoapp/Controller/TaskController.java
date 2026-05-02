package com.thybaharia.todoapp.Controller;



import com.thybaharia.todoapp.Model.Task;
import com.thybaharia.todoapp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1/tasks")
    public class TaskController {


        private final TaskService taskService;

        public TaskController(TaskService taskService) {
            this.taskService = taskService;
        }

        @GetMapping
        public List<Task> getAllTasks() {
            return taskService.getAllTasks();
        }

        @PostMapping
        public Task createTask(@RequestBody Task task)
        {
            return taskService.createTask(task);
        }

        @GetMapping("{id}")
        public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
            return ResponseEntity.ok(taskService.getTaskById(id));
        }

        @PutMapping("{id}")
        public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task task){



            return ResponseEntity.ok(
                    taskService.updateTask(id, task));
        }

        @DeleteMapping("{id}")
        public ResponseEntity<HttpStatus> deleteTask(@PathVariable Integer id) {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

