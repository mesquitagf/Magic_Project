package com.api.Magic.Business;

import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Service.CardService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CardBusiness {

    @Autowired
    CardService cardService;

    private final BusinessException businessException;

    public String createCard(CardDTO cardRequestDTO) {
        validateCreateCardRequest(cardRequestDTO);
        return cardService.createCard(cardRequestDTO);
    }

    public ResponseEntity<List<Card>> findAll(){
        return this.cardService.findAll();
    }

    public String deleteCardById(String id) throws BusinessException{
        businessException.validateIdField(id);
        return this.cardService.deleteCardById(id);
    }

    public ResponseEntity<List<Card>> findAllByType(String type) {
        try{
            validateTypeEmpty(type);
            var cardList = this.cardService.findAllByType(type);
            validateCardNotFoundByType(cardList);
            return cardList;
        } catch (Exception e){
            throw new BusinessException("Error searching Card by type!", e);
        }
    }

    public ResponseEntity<Card> findById(String id) {
        return this.cardService.findById(id);
    }

    private void validateCreateCardRequest(CardDTO cardRequestDTO){
        if (cardRequestDTO.getName().isEmpty()){
            throw new BusinessException("Name is null!");
        } else if(cardRequestDTO.getType().isEmpty()){
            throw new BusinessException("Type is null!");
        }
    }

    private void validateTypeEmpty(String type) {
        if (type.isEmpty() || type == null){
            throw new BusinessException("Type null");
        } 
    }

    private void validateCardNotFoundByType(ResponseEntity<List<Card>> response) {
        if(response.getBody().isEmpty()) {
            throw new BusinessException("No Cards where found with this type");
        }
    }

}
