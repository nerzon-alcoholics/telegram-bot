package ru.nerzon.alcoholics.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.nerzon.alcoholics.telegrambot.config.TelegramConfig;




@SpringBootApplication
@EnableConfigurationProperties(TelegramConfig.class)
public class TelegramBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TelegramBotApplication.class, args);
    }

}
