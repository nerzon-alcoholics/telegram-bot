package ru.nerzon.alcoholics.telegrambot.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.nerzon.alcoholics.telegrambot.domain.TeleBot;

@RestController
@AllArgsConstructor
@Slf4j
public class WebhookController {
    private final TeleBot teleBot;

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        log.info("Controller");
        return teleBot.onWebhookUpdateReceived(update);
    }
}