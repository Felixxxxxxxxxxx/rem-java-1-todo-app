package de.neuefische.backend.controller;

import de.neuefische.backend.models.Todo;
import de.neuefische.backend.services.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// url ending "/api/todo"  ?????

// url ending in board: forked into three sub-pages
// open, in-progress & done

// der Controller gibt die to do liste aus

@RestController
@RequestMapping("api/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<Todo> getTodoList (){
        return todoService.getTodos();
    }

    @PutMapping("{id}")
    public Todo advanceTodo (@RequestBody Todo todoToBeAdvanced){
        todoService.advanceTodo(todoToBeAdvanced);
        return todoToBeAdvanced;
    }
}
