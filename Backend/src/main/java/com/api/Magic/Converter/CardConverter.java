package com.api.Magic.Converter;

import com.api.Magic.Dto.CardDTO;
import com.api.Magic.Model.Entity.Card;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CardConverter {
    public Card toEntity(CardDTO cardDTO){
        return Card.builder()
                .id(UUID.randomUUID().toString())
                .name(cardDTO.getName())
                .manaCost(cardDTO.getManaCost())
                .type(cardDTO.getType())
                .description(cardDTO.getDescription())
                .build();
    }
}
