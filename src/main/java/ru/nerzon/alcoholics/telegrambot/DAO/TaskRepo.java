package ru.nerzon.alcoholics.telegrambot.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nerzon.alcoholics.telegrambot.domain.Task;


public interface TaskRepo extends JpaRepository<Task, Long> {
}
