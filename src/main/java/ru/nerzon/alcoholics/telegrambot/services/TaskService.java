package ru.nerzon.alcoholics.telegrambot.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.nerzon.alcoholics.telegrambot.DAO.TaskRepo;



@Component
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;



}
