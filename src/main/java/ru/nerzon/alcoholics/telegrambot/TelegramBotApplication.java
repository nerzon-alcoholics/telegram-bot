package ru.nerzon.alcoholics.telegrambot;

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
public class TelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class, args);
    }

}
