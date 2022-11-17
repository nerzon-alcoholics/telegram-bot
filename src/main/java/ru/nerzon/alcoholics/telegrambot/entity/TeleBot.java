package ru.nerzon.alcoholics.telegrambot.entity;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import ru.nerzon.alcoholics.telegrambot.config.TelegramConfig;
import ru.nerzon.alcoholics.telegrambot.handler.MessageHandler;
import ru.nerzon.alcoholics.telegrambot.handler.CallbackQueryHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;


@Component

public class TeleBot extends TelegramWebhookBot {
    @Override
    public String getBotUsername() {
        return new TelegramConfig().getName();
    }

    @Override
    public String getBotToken() {
        return new TelegramConfig().getToken();
    }

    @Override
    public String getBotPath() {
        return new TelegramConfig().getWebhook();
    }

    MessageHandler messageHandler;
    CallbackQueryHandler callbackQueryHandler;

    public TeleBot(MessageHandler messageHandler, CallbackQueryHandler callbackQueryHandler) {
        this.messageHandler = messageHandler;
        this.callbackQueryHandler = callbackQueryHandler;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        try {
            return handleUpdate(update);
        } catch (Exception e) {
            return null;
        }
    }
    TelegramConfig telegramConfig = new TelegramConfig();

    @SneakyThrows
    private BotApiMethod<?> handleUpdate(Update update) throws IOException {
        if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            return callbackQueryHandler.processCallbackQuery(callbackQuery);
        } else {
            Message message = update.getMessage();
            if (message != null) {
                return messageHandler.answerMessage(update.getMessage());
            }
        }
        return null;
    }
}
