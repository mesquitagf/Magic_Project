package com.api.Magic.Controller;

import com.api.Magic.Business.CardBusiness;
import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Model.Entity.Card;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardBusiness cardBusiness;

    Logger logger = LoggerFactory.getLogger(CardController.class);
    
    @PostMapping("/create")
    public ResponseEntity<Card> createCard(@RequestBody @Valid CardDTO cardRequestDTO){
        logger.info("Creating card with request: {}", cardRequestDTO);
        return new ResponseEntity<>(cardBusiness.createCard(cardRequestDTO.toEntity(cardRequestDTO)), HttpStatus.CREATED);
    }

    @GetMapping("/getById")
    public ResponseEntity<Object> findById(@RequestParam("id") @NotBlank String id) {
        logger.info("Finding card with ID: {}", id);
        Optional<Card> card = this.cardBusiness.findById(id);
        return card.<ResponseEntity<Object>>map(value
                -> ResponseEntity.status(HttpStatus.FOUND).body(value)).orElseGet(()
                -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Card not found!"));
    }

    @PostMapping("/update")
    public ResponseEntity<Card> updateCard(@RequestParam("id") @NotBlank String id, @RequestBody @Valid CardDTO cardRequestDTO){
        logger.info("Updating card with ID: {}", id);
        return new ResponseEntity<>(cardBusiness.updateCard(id, cardRequestDTO.toEntity(cardRequestDTO)), HttpStatus.OK);
    };

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCardById(@RequestParam("id") @NotBlank String id) {
        logger.info("Deleting card with ID: {}", id);
        var deleted = this.cardBusiness.deleteCardById(id);
        if (deleted.isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error deleting card!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(deleted);
        }
    }

    @GetMapping("/getAllCards")
    public ResponseEntity<Page<Card>> findAll(@PageableDefault(page = 0, size = 5, sort = {"id"},
            direction = Sort.Direction.DESC) Pageable pageable){
        logger.info("Finding all cards");
        return new ResponseEntity<>(cardBusiness.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/getCardsByType")
    public ResponseEntity<Page<Card>> findAllByType(@RequestParam("type") @NotBlank String type,
            @PageableDefault(page = 0, size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable){
        logger.info("Finding all cards by type: {}", type);
        return new ResponseEntity<>(cardBusiness.findAllByType(type, pageable), HttpStatus.OK);
    }

}
