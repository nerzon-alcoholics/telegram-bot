package ru.nerzon.alcoholics.telegrambot.entities;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Component
@Entity(name = "task")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "task_number", nullable = false)
    Long number;

    @Column(name = "task_module")
    String module;

    @Column(name = "task_name", nullable = false)
    String name;

    @Column(name = "task_executor")
    String executor;

    @Column(name = "task_description", nullable = false)
    String description;

    @Column(name = "task_status", nullable = false)
    String status;

    @Column(name = "task_time_evaluation")
    String timeEvaluation;

    @Column(name = "task_created_at")
    LocalDateTime createdAt;
}
