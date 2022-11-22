package ru.nerzon.alcoholics.telegrambot.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ConfigurationProperties(prefix = "telegram-bot")
public class TelegramConfig {
    private String name;

    private String token;

    private String webhookPath;

}
