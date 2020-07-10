package com.sample.cache.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {
    String title;
    String content;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    public Message(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
