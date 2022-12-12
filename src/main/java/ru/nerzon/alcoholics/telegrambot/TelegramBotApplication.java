package ru.nerzon.alcoholics.telegrambot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.nerzon.alcoholics.telegrambot.config.TelegramConfig;
import ru.nerzon.alcoholics.telegrambot.domain.Task;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@SpringBootApplication
@EnableConfigurationProperties(TelegramConfig.class)
@Slf4j
public class TelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class, args);
    }
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @PostConstruct
    public void testCreate() {
        var task = new Task();
        task.setName("1");
        task.setDescription("1");
        task.setExternal_id(1L);
        log.info("Saving task {}", task);
        entityManager.persist(task);
        log.info("Saved {}", task);
    }

}
