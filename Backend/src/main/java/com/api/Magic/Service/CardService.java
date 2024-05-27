package com.api.Magic.Service;

import com.api.Magic.Converter.CardConverter;
import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    @Autowired
    CardRepository cardRepository;

    private final CardConverter cardConverter;

    public String createCard(CardDTO cardRequestDTO) {
        try {
            var cardRequest = cardConverter.toEntity(cardRequestDTO);
            cardRepository.save(cardRequest);
            return "Card created successfully! ID: " + cardRequest.getId();
        } catch (Exception e){
            throw new BusinessException("Error creating new Card!", e);
        }
    }

    public ResponseEntity<List<Card>> findAll(){
        return ResponseEntity.ok(this.cardRepository.findAll());
    }

    public ResponseEntity<List<Card>> findAllByType(String type) {
        return ResponseEntity.ok(this.cardRepository.findAllByType(type));
    }
}
