package com.api.Magic.Converter;

import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Model.Entity.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardConverter {
    public Card toEntity(CardDTO cardDTO){
        return Card.builder()
                .id(cardDTO.getId())
                .name(cardDTO.getName())
                .manaCost(cardDTO.getManaCost())
                .type(cardDTO.getType())
                .description(cardDTO.getDescription())
                .build();
    }

    public CardDTO toDTO(Card card){
        return CardDTO.builder()
                .id(card.getId())
                .name(card.getName())
                .manaCost(card.getManaCost())
                .type(card.getType())
                .description(card.getDescription())
                .build();
    }

    public List<CardDTO> convertListToDTO(List<Card> cardList) {
        List<CardDTO> cardListResponse = new ArrayList<>(List.of());
        CardDTO cardDTO;
        for (Card card : cardList) {
            cardDTO = CardDTO.builder()
                    .id(card.getId())
                    .name(card.getName())
                    .manaCost(card.getManaCost())
                    .type(card.getType())
                    .description(card.getDescription())
                    .build();

            cardListResponse.add(cardDTO);
        }
        return cardListResponse;
    }
}
