package ru.nerzon.alcoholics.telegrambot.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.nerzon.alcoholics.telegrambot.DAO.TaskRepoImpl;
import ru.nerzon.alcoholics.telegrambot.entities.Task;

import java.util.List;

public class TaskService {

    @Autowired
    private static TaskRepoImpl taskRepo;

    public Task getTaskById(Long id){
        return taskRepo.getTaskById(id);
    }

    public List<Task> getTasks(){
        return taskRepo.getTasks();
    }

    public void updateTask(Task task){
        taskRepo.updateTask(task);
    }

    public void deleteTask(Task task){
        taskRepo.deleteTask(task);
    }

    public void addTask(Task task){
        taskRepo.addTask(task);
    }

    public List<Task> getMyTasks(Long executor_id){
        return taskRepo.getMyTasks(executor_id);
    }
}
