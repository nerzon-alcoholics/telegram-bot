package ru.nerzon.alcoholics.telegrambot.utils;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import ru.nerzon.alcoholics.telegrambot.config.HibernateConfig;
import ru.nerzon.alcoholics.telegrambot.entities.Task;

@Slf4j
public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    @Autowired
    private static HibernateConfig hibernateConfig;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addProperties(hibernateConfig.getHibernateProperties());
                configuration.addAnnotatedClass(Task.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                log.info("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}