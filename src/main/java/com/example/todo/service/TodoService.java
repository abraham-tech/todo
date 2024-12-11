package com.example.todo.service;

import com.example.todo.entity.Todo;
import com.example.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<Todo> findAll() {
        return repository.findAll();
    }

    public Optional<Todo> findById(Long id) {
        return repository.findById(id);
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }

    public Todo update(Long id, Todo todoDetails) {
        return repository.findById(id).map(todo -> {
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());
            return repository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo not found with id " + id));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
