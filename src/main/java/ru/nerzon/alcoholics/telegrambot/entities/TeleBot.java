package ru.nerzon.alcoholics.telegrambot.entities;


import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.nerzon.alcoholics.telegrambot.config.TelegramConfig;
import ru.nerzon.alcoholics.telegrambot.handlers.MessageHandler;
import ru.nerzon.alcoholics.telegrambot.handlers.CallbackQueryHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;


@Component
public class TeleBot extends TelegramWebhookBot {
    private final MessageHandler messageHandler;
    private final CallbackQueryHandler callbackQueryHandler;
    private final TelegramConfig telegramConfig;

    private final SetWebhook setWebhook;

    public TeleBot(MessageHandler messageHandler, CallbackQueryHandler callbackQueryHandler, TelegramConfig telegramConfig) {
        this.messageHandler = messageHandler;
        this.callbackQueryHandler = callbackQueryHandler;
        this.telegramConfig = telegramConfig;
        this.setWebhook = new SetWebhook(this.telegramConfig.getWebhookPath());
    }

    @Override
    public String getBotUsername() {
        return this.telegramConfig.getName();
    }

    @Override
    public String getBotToken() {
        return this.telegramConfig.getToken();
    }

    @Override
    public String getBotPath() {
        return this.telegramConfig.getWebhookPath();
    }



    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        try {
            return handleUpdate(update);
        } catch (Exception e) {
            return null;
        }
    }


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
