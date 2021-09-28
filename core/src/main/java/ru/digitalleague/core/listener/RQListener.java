package ru.digitalleague.core.listener;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
public class RQListener {
    @RabbitListener(queues = "order")
    public void orderListener(String message){
        System.out.println("message = " + message);
    }
}
