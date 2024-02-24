package com.example.librarymanagmentsystem.Controllers;

import com.example.librarymanagmentsystem.Services.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionsService transactionsService;

    @PostMapping("issueBook")
    public ResponseEntity issueBook(@RequestParam("cardId")Integer cardId,
                                    @RequestParam("bookId")Integer bookId)
    {
        try{
            String result = transactionsService.IssueBook(cardId, bookId);
            return new  ResponseEntity(result, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

}
