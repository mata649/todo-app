package com.mata649.todoapp.todo.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoDataRepository extends JpaRepository<TodoEntity, Long> {

}
