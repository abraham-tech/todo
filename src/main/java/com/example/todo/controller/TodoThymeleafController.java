package com.example.todo.controller;

import com.example.todo.entity.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoThymeleafController {

    @Autowired
    private TodoService service;

    @GetMapping
    public String listTodos(Model model) {
        model.addAttribute("todos", service.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String newTodoForm(Model model) {
        model.addAttribute("title", "Add New TODO");
        model.addAttribute("todo", new Todo());
        return "form";
    }

    @PostMapping
    public String saveTodo(@ModelAttribute Todo todo) {
        service.save(todo);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String editTodoForm(@PathVariable Long id, Model model) {
        Todo todo = service.findById(id).orElse(new Todo());
        model.addAttribute("title", "Edit TODO");
        model.addAttribute("todo", todo);
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodoById(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/todos";
    }
}