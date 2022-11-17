package ru.nerzon.alcoholics.telegrambot.config;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@ConfigurationProperties(prefix = "telegram-bot")
public class TelegramConfig {
    private String name;
    private String token;
    private String webhook;
}
