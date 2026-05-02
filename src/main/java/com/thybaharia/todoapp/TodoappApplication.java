package com.thybaharia.todoapp;

import com.thybaharia.todoapp.Model.Task;
import com.thybaharia.todoapp.Service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoappApplication  {

    public static void main(String[] args) {
        SpringApplication.run(TodoappApplication.class, args);
    }
    @Bean
    public CommandLineRunner init(TaskService taskService) {

        return args -> {
            Task task = new Task();
            task.setTitle("SOFTWARE DESIGN");
            task.setDeadline("O1-1-2026");

            Task task2 = new Task();
            task2.setTitle("HUMAN COMPUTER INTERACTION");
            task2.setDeadline("O2-1-2026");

            Task task3 = new Task();
            task3.setTitle("COMPUTER ARCHITECTURE");
            task3.setDeadline("O3-1-2026");


            taskService.createTask(task);
            taskService.createTask(task2);
            taskService.createTask(task3);

        };


    }
}

