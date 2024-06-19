package com.api.Magic.Business;

import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Service.CardService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardBusiness {

    @Autowired
    CardService cardService;

    private final BusinessException businessException;

    public Card createCard(Card cardRequest) {
        try {
            return cardService.createCard(cardRequest);
        } catch (Exception e){
            throw new BusinessException("Error creating Card!", e);
        }
    }

    public Optional<Card> findById(String id) throws BusinessException {
        try {
            return this.cardService.findById(id);
        } catch (Exception e){
            throw new BusinessException("Error finding Card by ID: " + id, e);
        }
    }

    public Card updateCard(String id, Card cardRequest) {
        try {
            return this.cardService.updateCard(id, cardRequest);
        } catch (Exception e){
            throw new BusinessException("Error updating Card by ID: " + id, e);
        }
    }

    public String deleteCardById(String id) throws BusinessException{
        try {
            return this.cardService.deleteCardById(id);
        } catch (Exception e){
            throw new BusinessException("Error deleting Card by ID: " + id, e);
        }
    }

    public Page<Card> findAll(Pageable pageable){
        try {
            return this.cardService.findAll(pageable);
        } catch (Exception e){
            throw new BusinessException("Error finding Cards!", e);
        }
    }

    public Page<Card> findAllByType(String type, Pageable pageable) {
        try{
            return this.cardService.findAllByType(type, pageable);
        } catch (Exception e){
            throw new BusinessException("Error searching Card by type!", e);
        }
    }
}
