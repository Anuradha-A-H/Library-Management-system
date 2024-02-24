package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.Entities.LibraryCard;
import com.example.librarymanagmentsystem.Services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping("/generateCard")
    private String addCard(){
        String result = cardService.getFreshCard();
        return result;
    }

    @PutMapping("/associateCardAndStudent")
    public ResponseEntity associateCardAndStudent( @RequestParam("studentId") Integer studentId, @RequestParam("cardId")Integer cardId)
    {
        try{
            String result = cardService.associateCardAndStudent(studentId,cardId);

            return new ResponseEntity(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getCard")
    public ResponseEntity getCard(@RequestParam("/cardId")Integer cardId)
    {
        try{


            LibraryCard card = cardService.getCard(cardId);
            return new ResponseEntity(card,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
