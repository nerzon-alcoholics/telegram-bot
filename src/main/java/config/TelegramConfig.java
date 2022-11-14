package config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class TelegramConfig {
    @Value("${telegram.bot-name}")
    private String botName;

    @Value("${telegram.bot-token}")
    private String botToken;

    @Value("${telegram.webhook-path}")
    private String webhookPath;
}
