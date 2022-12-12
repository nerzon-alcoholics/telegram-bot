package ru.nerzon.alcoholics.telegrambot.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nerzon.alcoholics.telegrambot.DAO.TaskRepo;
import ru.nerzon.alcoholics.telegrambot.domain.Task;


@Component
@Slf4j
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;

    public void addTask(Task task){
        taskRepo.save(task);
        log.info("service");
    }

}
