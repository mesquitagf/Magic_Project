package com.api.Magic.Service;

import com.api.Magic.Converter.CardConverter;
import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    @Autowired
    CardRepository cardRepository;

    private final CardConverter cardConverter;

    public String createCard(CardDTO cardRequestDTO) {
        try {
            cardRequestDTO.setId(UUID.randomUUID().toString());
            var cardRequest = cardConverter.toEntity(cardRequestDTO);
            cardRepository.save(cardRequest);
            return "Card created successfully! ID: " + cardRequest.getId();
        } catch (Exception e){
            throw new BusinessException("Error creating new Card!", e);
        }
    }

    public CardDTO findById(String id) {
        var cardResponse = this.cardRepository.findById(id);
        if (cardResponse.isPresent()){
            return cardConverter.toDTO(cardResponse.get());
        } else {
            throw new BusinessException("Error searching Card by ID: " + id);
        }
    }

    public String updateCard(CardDTO cardRequestDTO, CardDTO existingCard) {
        try {
            existingCard.setName(cardRequestDTO.getName());
            existingCard.setManaCost(cardRequestDTO.getManaCost());
            existingCard.setType(cardRequestDTO.getType());
            existingCard.setDescription(cardRequestDTO.getDescription());

            var cardRequest = cardConverter.toEntity(existingCard);
            cardRepository.save(cardRequest);
            return "Card updated successfully! ID: " + cardRequest.getId();
        } catch (Exception e){
            throw new BusinessException("Error updating Card!", e);
        }
    }

    public String deleteCardById(String id) {
        this.cardRepository.deleteById(id);
        return "Card deleted successfully! ID: " + id;
    }

    public ResponseEntity<List<CardDTO>> findAll(){
        var cardListResponse = cardConverter.convertListToDTO(this.cardRepository.findAll());
        return ResponseEntity.ok(cardListResponse);
    }

    public ResponseEntity<List<CardDTO>> findAllByType(String type) {
        var cardListResponse = cardConverter.convertListToDTO(this.cardRepository.findAllByTypeIgnoreCase(type));
        return ResponseEntity.ok(cardListResponse);
    }

}
