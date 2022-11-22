package ru.nerzon.alcoholics.telegrambot.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity(name = "task")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "number", nullable = false)
    Long number;

    @Column(name = "module")
    String module;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "executor")
    String executor;

    @Column(name = "executor_id", nullable = false)
    Long executor_id;

    @Column(name = "description", nullable = false)
    String description;

}
