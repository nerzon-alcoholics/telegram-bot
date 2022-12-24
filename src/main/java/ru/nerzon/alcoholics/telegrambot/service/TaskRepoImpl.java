package ru.nerzon.alcoholics.telegrambot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.nerzon.alcoholics.telegrambot.DAO.TaskRepo;
import ru.nerzon.alcoholics.telegrambot.domain.Task;

@Component
public class TaskRepoImpl {
    @Autowired
    @Lazy
    private TaskRepo taskRepo;

    public void addTask(Task task){
        taskRepo.save(task);
    }
}
