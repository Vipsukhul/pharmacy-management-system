package com.pharmacy.pms.controller;

import com.pharmacy.pms.model.Message;
import com.pharmacy.pms.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping
    public String inbox(Model model, Authentication authentication) {
        model.addAttribute("messages", messageService.inboxFor(authentication.getName()));
        return "messages/inbox";
    }

    @GetMapping("/send")
    public String sendForm(Model model) {
        model.addAttribute("message", new Message());
        return "messages/send";
    }

    @PostMapping("/send")
    public String send(@ModelAttribute Message message, Authentication authentication) {
        message.setSender(authentication.getName());
        messageService.send(message);
        return "redirect:/messages";
    }
}
