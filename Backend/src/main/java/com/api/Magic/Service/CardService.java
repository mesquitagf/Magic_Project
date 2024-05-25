package com.api.Magic.Service;

import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public void createCard(Card cardRequest) {
        cardRepository.save(cardRequest);
    }

    public ResponseEntity<List<Card>> findAll(){
        return ResponseEntity.ok(this.cardRepository.findAll());
    }

    public ResponseEntity<List<Card>> findAllByType(String type) {
        return ResponseEntity.ok(this.cardRepository.findAllByType(type));
    }
}
