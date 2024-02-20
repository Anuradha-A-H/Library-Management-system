package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/addCard")
    private String addCard(){
        String result = cardService.getFreshCard();
        return result;
    }
}
