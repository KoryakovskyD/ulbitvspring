package com.example.ulbitvspring.controller;

import com.example.ulbitvspring.entity.TodoEntity;
import com.example.ulbitvspring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo,
                                     @RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.createTodo(todo, userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }

    @PostMapping
    public ResponseEntity completeTodo(@RequestParam Long userId) {
        try {
            return ResponseEntity.ok(todoService.complete(userId));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error!");
        }
    }
}
