package com.api.Magic.Business;

import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Exception.BusinessException;
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

    public CardDTO findById(String id) throws BusinessException {
        businessException.validateIdField(id);
        return this.cardService.findById(id);
    }

    public ResponseEntity<List<CardDTO>> findAll(){
        return this.cardService.findAll();
    }

    public ResponseEntity<List<CardDTO>> findAllByType(String type) {
        try{
            validateTypeEmpty(type);
            var cardList = this.cardService.findAllByType(type);
            validateCardNotFoundByType(cardList);
            return cardList;
        } catch (Exception e){
            throw new BusinessException("Error searching Card by type!", e);
        }
    }

    public String deleteCardById(String id) throws BusinessException{
        businessException.validateIdField(id);
        return this.cardService.deleteCardById(id);
    }

    private void validateCreateCardRequest(CardDTO cardRequestDTO){
        if (cardRequestDTO.getName().isEmpty()){
            throw new BusinessException("Name is null!");
        } else if(cardRequestDTO.getType().isEmpty()){
            throw new BusinessException("Type is null!");
        }
    }

    private void validateTypeEmpty(String type) {
        if (type.isEmpty()){
            throw new BusinessException("Type null");
        } 
    }

    private void validateCardNotFoundByType(ResponseEntity<List<CardDTO>> response) {
        if(response.getBody().isEmpty()) {
            throw new BusinessException("No Cards where found with this type");
        }
    }


}
