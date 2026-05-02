package com.thybaharia.todoapp.Service;

import com.thybaharia.todoapp.Exception.ResourceNotFoundException;
import com.thybaharia.todoapp.Model.Task;
import com.thybaharia.todoapp.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public List<Task>getAllTasks() {
        return taskRepository.findAll();
    }
    @Override
    public Task createTask(Task task){
        return taskRepository.save(task);

    }
    @Override
    public Task getTaskById(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No task found with id " + id));
        return task;

    }

    @Override
    public Task updateTask(Integer id, Task task) {
        Task updateTask = (Task) taskRepository.findById(task.getId()).orElseThrow(() -> new ResourceNotFoundException("No task found with id " + task.getId()));
      updateTask.setTitle(task.getTitle());
      updateTask.setDeadline(task.getDeadline());
      taskRepository.save(updateTask);
      return updateTask;

    }
    @Override
    public void deleteTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No task found with id " + id));
        taskRepository.delete(task);

    }
}
