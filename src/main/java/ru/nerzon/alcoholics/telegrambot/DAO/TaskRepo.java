package ru.nerzon.alcoholics.telegrambot.DAO;

import org.springframework.stereotype.Repository;
import ru.nerzon.alcoholics.telegrambot.domain.Task;

@Repository
public interface TaskRepo{
    void addTask(Task task);

//    Task getTaskById(Long id);
//
//    Task updateTask(Task task);
//
//    boolean deleteTaskWithId(Long id);
}
