package ru.nerzon.alcoholics.telegrambot.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nerzon.alcoholics.telegrambot.DAO.TaskRepoImpl;
import ru.nerzon.alcoholics.telegrambot.entities.Task;

import java.util.List;

@Slf4j
public class TaskService {


    private final TaskRepoImpl taskRepoImpl = new TaskRepoImpl();

    public Task getTaskById(Long id){
        return taskRepoImpl.getTaskById(id);
    }

    public List<Task> getTasks(){
        return taskRepoImpl.getTasks();
    }

    public void updateTask(Task task){
        taskRepoImpl.updateTask(task);
    }

    public void deleteTask(Task task){
        taskRepoImpl.deleteTask(task);
    }

    public void addTask(Task task){
        log.info("service");
        taskRepoImpl.addTask(task);
    }

    public List<Task> getMyTasks(Long executor_id){
        return taskRepoImpl.getMyTasks(executor_id);
    }
}
