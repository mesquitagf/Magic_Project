package com.api.Magic.Business;

import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("CardBusiness")
public class CardBusiness {

    @Autowired
    CardService cardService;

    public void createCard(Card cardRequest) {
        try {
            var validateRequest = validateCreateCardRequest(cardRequest);

            if (validateRequest == null){
                cardService.createCard(cardRequest);
            } else {
                throw new BusinessException(validateRequest);
            }
        } catch (Exception e){
            throw new BusinessException("Erro ao inserir novo Card!", e);
        }
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

    private final String validateCreateCardRequest(Card cardRequest){
        var errorsList = new ArrayList<>();

        if (cardRequest.getName() == null){
            errorsList.add("Name null");
        }
        if(cardRequest.getType() == null){
            errorsList.add("Type null");
        }
        return errorsList.toString();
    }
}
