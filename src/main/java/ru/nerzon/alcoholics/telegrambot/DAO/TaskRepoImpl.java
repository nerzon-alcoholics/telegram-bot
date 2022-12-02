package ru.nerzon.alcoholics.telegrambot.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import ru.nerzon.alcoholics.telegrambot.entities.Task;
import ru.nerzon.alcoholics.telegrambot.utils.HibernateSessionFactoryUtil;

import java.util.List;

@Component
public class TaskRepoImpl implements TaskRepo{
    public void addTask(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(task);
        transaction.commit();
        session.close();
    }

    public void updateTask(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(task);
        transaction.commit();
        session.close();
    }

    public void deleteTask(Task task) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(task);
        transaction.commit();
        session.close();
    }

    public Task getTaskById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Task.class, id);
    }


    public List<Task> getTasks() {
        List<Task> tasks = (List<Task>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From task").list();
        return tasks;
    }

    public List<Task> getMyTasks(Long executor_id) {
        throw new UnsupportedOperationException();
    }
}
