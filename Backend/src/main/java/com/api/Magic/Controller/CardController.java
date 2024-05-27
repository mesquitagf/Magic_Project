package com.api.Magic.Controller;

import com.api.Magic.Business.CardBusiness;
import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Model.Entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardBusiness cardBusiness;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createCard(@RequestBody CardDTO cardRequestDTO){
        return cardBusiness.createCard(cardRequestDTO);
    }

    @GetMapping("/getAllCards")
    public ResponseEntity<List<Card>> findAll(){
        return this.cardBusiness.findAll();
    }

    @GetMapping("/getCardsByType")
    public ResponseEntity<List<Card>> findAllByType(@RequestParam ("type") String type){
        return this.cardBusiness.findAllByType(type);
    }
}
