package ru.nerzon.alcoholics.telegrambot.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.nerzon.alcoholics.telegrambot.DAO.TaskRepo;
import ru.nerzon.alcoholics.telegrambot.domain.Task;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Component
@Slf4j
public class TaskService implements TaskRepo {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public void addTask(Task task) {
        log.info("entered");
        entityManager.persist(task);
        log.info("success");
    }

//    @Override
//    public Task getTaskById(Long id) {
//        Task task = entityManager.find(Task.class, id);
//        return task;
//    }
//
//    @Override
//    public Task updateTask(Task task) {
//        return null;
//    }
//
//    @Override
//    public boolean deleteTaskWithId(Long id) {
//        return false;
//}
}
