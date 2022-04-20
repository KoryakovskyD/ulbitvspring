package com.example.ulbitvspring.service;

import com.example.ulbitvspring.entity.TodoEntity;
import com.example.ulbitvspring.entity.UserEntity;
import com.example.ulbitvspring.repository.TodoRepo;
import com.example.ulbitvspring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public TodoEntity createTodo(TodoEntity todo, Long userid) {
        UserEntity user = userRepo.findById(userid).get();
        todo.setUser(user);
        return todoRepo.save(todo);
    }

    public TodoEntity complete(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();

        todo.setCompleted(!todo.getCompleted());
        return todoRepo.save(todo);
    }

}
