package com.example.todo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Data
@Entity
@Table(name = "todos")
@Getter
@Service
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;
}

