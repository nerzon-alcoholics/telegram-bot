package ru.nerzon.alcoholics.telegrambot.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.nerzon.alcoholics.telegrambot.domain.Task;
import ru.nerzon.alcoholics.telegrambot.services.TaskService;

import java.util.concurrent.ThreadLocalRandom;


@Component
@Slf4j
public class MessageHandler {
    @Autowired
    TaskService taskService;


    public BotApiMethod<?> answerMessage(Message message) throws UnsupportedOperationException {
        if(message.hasText()){
            log.info("answerMessage");
            return add(message);
        }
        throw new UnsupportedOperationException();
    }
    private SendMessage echo(Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(message.getText());
        return sendMessage;
    }

    private SendMessage add(Message message){
        Task task = new Task();
        task.setName(message.getText());
        task.setExternalId(ThreadLocalRandom.current().nextLong());
        task.setDescription("test");
        log.info("before");
        taskService.addTask(task);
        log.info("after");
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText("new task added");
        return sendMessage;
    }


}
