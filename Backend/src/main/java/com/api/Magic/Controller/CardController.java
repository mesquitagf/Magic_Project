package com.api.Magic.Controller;

import com.api.Magic.Business.CardBusiness;
import com.api.Magic.Dto.CardDTO;
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
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createCard(@RequestBody CardDTO cardRequestDTO){
        return cardBusiness.createCard(cardRequestDTO);
    }

    @GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public CardDTO findById(@RequestParam String id) {
        return this.cardBusiness.findById(id);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public String updateCard(@RequestParam String id, @RequestBody CardDTO cardRequestDTO){
        return cardBusiness.updateCard(id, cardRequestDTO);
    };

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCardById(@RequestParam String id) {
        return this.cardBusiness.deleteCardById(id);

    }

    @GetMapping("/getAllCards")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CardDTO>> findAll(){
        return this.cardBusiness.findAll();
    }

    @GetMapping("/getCardsByType")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CardDTO>> findAllByType(@RequestParam ("type") String type){
        return this.cardBusiness.findAllByType(type);
    }

}
