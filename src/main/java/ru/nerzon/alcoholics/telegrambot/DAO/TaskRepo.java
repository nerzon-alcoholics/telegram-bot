package ru.nerzon.alcoholics.telegrambot.DAO;

import ru.nerzon.alcoholics.telegrambot.entities.Task;

import java.util.List;

public class TaskRepo {
    public void addTask(Task task);

    public void updateTask(Task task);

    public void deleteTask(Task task);

    public Task getTaskById(Long number);

    public List<Task> getTasks();

    public List<Task> getMyTasks(String executor);

}
