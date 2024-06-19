package com.api.Magic.Service;

import com.api.Magic.Exception.BusinessException;
import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {

    @Autowired
    CardRepository cardRepository;

    public Card createCard(Card cardRequest) {
        cardRequest.setId(UUID.randomUUID().toString());
        return cardRepository.save(cardRequest);
    }

    public Optional<Card> findById(String id) {
        return this.cardRepository.findById(id);
    }

    public Card updateCard(String id, Card cardRequest) {
        var existingCard = this.cardRepository.findById(id).orElseThrow(() -> new BusinessException("Card not found!"));
        BeanUtils.copyProperties(cardRequest, existingCard);
        existingCard.setId(id);
        return cardRepository.save(existingCard);
    }

    public String deleteCardById(String id) {
        var existingCard = this.cardRepository.findById(id).orElseThrow(() -> new BusinessException("Card not found!"));
        this.cardRepository.deleteById(existingCard.getId());
        return "Card deleted successfully! ID: " + id;
    }

    public Page<Card> findAll(Pageable pageable) {
        return this.cardRepository.findAll(pageable);
    }

    public Page<Card> findAllByType(String type, Pageable pageable) {
        return this.cardRepository.findAllByTypeIgnoreCase(type, pageable);
    }

}
