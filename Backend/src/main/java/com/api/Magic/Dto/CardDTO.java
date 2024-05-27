package com.api.Magic.Dto;

import com.api.Magic.Model.Entity.ManaCost;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CardDTO {

    private String id;
    private String name;
    private List<ManaCost> manaCost;
    private String type;
    private String description;
}
