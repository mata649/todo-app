package com.mata649.todoapp.todo.data;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.mata649.todoapp.todo.domain.Todo;
import com.mata649.todoapp.user.data.UserMapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface TodoMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "content", target = "content"),
            @Mapping(source = "user", target = "user"),
    })
    public Todo toTodo(TodoEntity todoEntity);
    public List<Todo> toTodos(List<TodoEntity> todos);
    

    @InheritInverseConfiguration
    public TodoEntity toTodoEntity(Todo todo);
}
