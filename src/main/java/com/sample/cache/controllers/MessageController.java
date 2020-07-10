package com.sample.cache.controllers;

import com.sample.cache.entities.Message;
import com.sample.cache.services.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {
    private final MessageService messageService;
    private final ApplicationContext context; //context.getBean("newCacheManager")

    public MessageController(MessageService messageService, ApplicationContext context) {
        this.messageService = messageService;
        this.context = context;
    }

    @GetMapping("/init")
    public void create() {
        for (int i = 0; i < 3; i++) {
            messageService.create("name" + i, "some content");
        }
    }

    @GetMapping("/")
    public List<Message> list() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Message getOne(@PathVariable("id") Long id) {
        return messageService.getById(id);
    }
}
