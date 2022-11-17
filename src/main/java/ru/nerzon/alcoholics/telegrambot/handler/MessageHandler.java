package ru.nerzon.alcoholics.telegrambot.handler;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.nerzon.alcoholics.telegrambot.exception.UnsupportedOperationException;

@Component
public class MessageHandler {
    public BotApiMethod<?> answerMessage(Message message) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
