package com.gencore.crudgenerator.controller;

import com.gencore.crudgenerator.controller.dto.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WordCountController {

    @GetMapping("/wordcount")
    public void wordCountForm(Model model) {
        model.addAttribute("message", new Message());
    }

    @PostMapping("/wordcount")
    public void wordCountSubmit(@ModelAttribute Message message, Model model) {
        int wordCount = countWords(message.getText());
        model.addAttribute("wordCount", wordCount);
    }

    private int countWords(String text) {
        // Lógica para contar as palavras do texto
        // Você pode implementar sua própria lógica de contagem de palavras aqui
        // Neste exemplo simples, vamos apenas contar os espaços em branco
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
}
