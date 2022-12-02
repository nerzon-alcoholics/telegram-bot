package ru.nerzon.alcoholics.telegrambot.DAO;

import ru.nerzon.alcoholics.telegrambot.entities.Task;

import java.util.List;

public interface TaskRepo {
    void addTask(Task task);

    void updateTask(Task task);

    void deleteTask(Task task);

    Task getTaskById(Long id);

    List<Task> getTasks();

    public List<Task> getMyTasks(Long executor_id);
}
