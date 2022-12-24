package ru.nerzon.alcoholics.telegrambot.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tasks")
@Getter
@Setter
@Component
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "external_id", nullable = false)
    private Long externalId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "module")
    private String module;

    @Column(name = "executor_id")
    private Long executorId;

    @Column(name = "created_at")
    private LocalDateTime localDateTime;

    @Override
    public String toString(){
        return this.name;
    }

}
