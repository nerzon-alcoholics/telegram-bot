package ru.nerzon.alcoholics.telegrambot.handlers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;


@Component
public class MessageHandler {

    public BotApiMethod<?> answerMessage(Message message) throws UnsupportedOperationException {
        if(message.hasText()){
            return echo(message);
        }
        throw new UnsupportedOperationException();
    }
    private SendMessage echo(Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(message.getText());
        return sendMessage;
    }
}
