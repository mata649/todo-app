package com.mata649.todoapp.todo.domain;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    public Todo create(Todo todo);

    public Optional<Todo> findById(Todo todo);

    public Optional<Todo> findByTodoname(Todo todo);

    public Optional<List<Todo>> findAll(Todo todo);

    public Todo delete(Todo todo);

    public Todo update(Todo todo);
}
