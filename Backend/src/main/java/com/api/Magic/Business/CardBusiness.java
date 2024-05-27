package com.api.Magic.Business;

import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardBusiness {

    @Autowired
    CardService cardService;

    public String createCard(CardDTO cardRequestDTO) {
        validateCreateCardRequest(cardRequestDTO);
        return cardService.createCard(cardRequestDTO);
    }

    public ResponseEntity<List<Card>> findAll(){
        return this.cardService.findAll();
    }

    public ResponseEntity<List<Card>> findAllByType(String type) {
        try{
            if (type != null){
                return this.cardService.findAllByType(type);
            } else {
                throw new BusinessException("Type null");
            }
        } catch (Exception e){
            throw new BusinessException("Erro ao buscar Card por type!", e);
        }
    }

    private void validateCreateCardRequest(CardDTO cardRequestDTO){
        if (cardRequestDTO.getName().isEmpty()){
            throw new BusinessException("Name is null!");
        } else if(cardRequestDTO.getType().isEmpty()){
            throw new BusinessException("Type is null!");
        }
    }
}
