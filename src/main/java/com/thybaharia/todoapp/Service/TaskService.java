package com.thybaharia.todoapp.Service;

import com.thybaharia.todoapp.Model.Task;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    public List<Task> getAllTasks();

    public Task createTask(Task task);

   public Task getTaskById(Integer id);


    public Task updateTask(Integer id, Task task);

    public void deleteTask(Integer task);



}

