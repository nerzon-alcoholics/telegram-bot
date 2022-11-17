package ru.nerzon.alcoholics.telegrambot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TelegramBotApplication {
    public static void main(String[] args) {
        log.info("Hello World!");
        SpringApplication.run(TelegramBotApplication.class, args);
    }

}
