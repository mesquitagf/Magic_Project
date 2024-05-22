package com.api.Magic.Controller;

import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardRepository cardRepository;

    @PostMapping("/createCard")
    public void createCard(@RequestBody Card cardRequest){
        cardRepository.save(cardRequest);
    }

    @GetMapping("/getAllCard")
    public ResponseEntity<List<Card>> findAll(){
        return ResponseEntity.ok(this.cardRepository.findAll());
    }
}
