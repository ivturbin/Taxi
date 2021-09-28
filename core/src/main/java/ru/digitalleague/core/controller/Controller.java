package ru.digitalleague.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.digitalleague.core.model.OrderDetails;

@RestController
public class Controller {
    @PostMapping("/orders")
    public void newOrder(@RequestBody OrderDetails orderDetails) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValueAsString(orderDetails);
            System.out.println("new order");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
