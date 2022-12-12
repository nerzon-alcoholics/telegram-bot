package ru.nerzon.alcoholics.telegrambot.DAO;

import org.springframework.data.repository.CrudRepository;
import ru.nerzon.alcoholics.telegrambot.domain.Task;

public interface TaskRepo extends CrudRepository<Task, Long> {}
