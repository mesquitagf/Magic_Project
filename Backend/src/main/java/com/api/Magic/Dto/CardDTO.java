package com.api.Magic.Dto;

import com.api.Magic.Model.Entity.Card;
import com.api.Magic.Model.Entity.ManaCost;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class CardDTO {

    @NotBlank
    private String name;

    private List<ManaCost> manaCost;
    @NotBlank
    private String type;
    @NotBlank
    private String description;

    public Card toEntity(CardDTO cardDTO){
        var card = new Card();
        BeanUtils.copyProperties(cardDTO, card);
        return card;
    }
}
