package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/generateCard")
    private String addCard(){
        String result = cardService.getFreshCard();
        return result;
    }

    @PutMapping("/associateCardAndStudent")
    public ResponseEntity associateCardandStudent(@RequestParam("cardId")Integer cardId, @RequestParam("studentId") Integer studentId)
    {
        try{
            String result = cardService.associateCardAndStudent(studentId,cardId);

            return new ResponseEntity(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
