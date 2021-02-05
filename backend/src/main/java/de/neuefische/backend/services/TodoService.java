package de.neuefische.backend.services;

import de.neuefische.backend.dbs.TodoDb;
import de.neuefische.backend.models.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    private TodoDb todoDb;

    public TodoService(TodoDb todoDb) {
        this.todoDb = todoDb;
    }

    public List<Todo> getTodos() {
        return todoDb.getTodoDbList();
    }

    public void advanceTodo(Todo todoToBeAdvanced) {
        for (Todo todo : todoDb.getTodoDbList()) {
            if(todo.getId().equals(todoToBeAdvanced.getId())){
                todo.setStatus(todoToBeAdvanced.getStatus());
            }
        }
    }

}
