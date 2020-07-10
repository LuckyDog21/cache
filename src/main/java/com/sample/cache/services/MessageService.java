package com.sample.cache.services;

import com.sample.cache.entities.Message;
import com.sample.cache.repositories.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MessageService {
    private final MessageRepository messageRepo;

    public MessageService(MessageRepository messageRepo) {
        this.messageRepo = messageRepo;
    }

    public Message create(String title, String content) {
        log.debug("create message");
        return messageRepo.save(new Message(title, content));
    }

    @Cacheable("messages")
    public Message getById(Long id) {
        log.debug("get message by id: " + id);
        return messageRepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Message> getAll() {
        log.debug("get all");
        return (List<Message>) messageRepo.findAll();
    }
}
