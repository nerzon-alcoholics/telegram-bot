package ru.nerzon.alcoholics.telegrambot.handlers.commands;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class StartCommand{
    private final Message message;

    public StartCommand(Message message) {
        this.message = message;
    }

    private String answerMessageText = "Hello, dear user!\n" +
            "This bot written to streamline workflow within the Nerzon team\n" +
            "To get the list of commands use: \"/help\"\n";

    public BotApiMethod<?> answerStartCommand(){
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText(answerMessageText);
        InlineKeyboardMarkup inlineKeyboardMarkup  = new InlineKeyboardMarkup();
        InlineKeyboardButton buttonHelp = new InlineKeyboardButton();
        buttonHelp.setCallbackData("/help");
        buttonHelp.setText("help");
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<List<InlineKeyboardButton>> table = new ArrayList<>();
        inlineKeyboardMarkup.setKeyboard(table);
        answer.setReplyMarkup(inlineKeyboardMarkup);
        return answer;
    }
}
