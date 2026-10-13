package com.pharmacy.pms.service;

import com.pharmacy.pms.model.Message;
import com.pharmacy.pms.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> inboxFor(String username) {
        return messageRepository.findByRecipientOrderBySentAtDesc(username);
    }

    public Message send(Message message) {
        return messageRepository.save(message);
    }
}
