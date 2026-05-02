package com.thybaharia.todoapp.Repository;

import com.thybaharia.todoapp.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
