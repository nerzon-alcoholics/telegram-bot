package ru.nerzon.alcoholics.telegrambot.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "tasks")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "external_id", nullable = false)
    Long external_id;

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "module")
    String module;

    @Column(name = "executor_id")
    Long executor_id;


    @Column(name = "created_at")
    LocalDateTime localDateTime;

    @Override
    public String toString(){
        return "Task#" + id.toString();
    }

}
