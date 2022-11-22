package ru.nerzon.alcoholics.telegrambot.services;

import ru.nerzon.alcoholics.telegrambot.DAO.TaskRepo;
import ru.nerzon.alcoholics.telegrambot.entities.Task;

import java.util.List;

public class TaskService implements TaskRepo {

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void updateTask(Task task) {

    }

    @Override
    public void deleteTask(Task task) {

    }

    @Override
    public Task getTaskByNumber(Long number) {
        return null;
    }

    @Override
    public List<Task> getTasks() {
        return null;
    }

    @Override
    public List<Task> getMyTasks(String executor) {
        return null;
    }
}
