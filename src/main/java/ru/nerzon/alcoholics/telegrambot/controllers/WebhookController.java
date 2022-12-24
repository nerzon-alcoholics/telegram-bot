package ru.nerzon.alcoholics.telegrambot.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.nerzon.alcoholics.telegrambot.utils.TeleBot;

@RestController
@AllArgsConstructor
public class WebhookController {
    @Autowired
    private final TeleBot teleBot;

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return teleBot.onWebhookUpdateReceived(update);
    }
}