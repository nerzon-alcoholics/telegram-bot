package ru.nerzon.alcoholics.telegrambot.handlers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.nerzon.alcoholics.telegrambot.entities.Task;
import ru.nerzon.alcoholics.telegrambot.services.TaskService;


@Component
@Slf4j
public class MessageHandler {
    TaskService taskService = new TaskService();

    public BotApiMethod<?> answerMessage(Message message) throws UnsupportedOperationException {
        if(message.hasText()){
            return test(message);
        }
        throw new UnsupportedOperationException();
    }
    private SendMessage echo(Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(message.getText());
        return sendMessage;
    }
    private BotApiMethod<?> test(Message message){
        Task task = new Task();
        task.setName("Test");
        task.setDescription("Test");
        task.setNumber(11111L);
        taskService.addTask(task);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(message.getText());
        log.info("test");
        return sendMessage;
    }

}
