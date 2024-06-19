package com.api.Magic.Model.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import java.util.List;

@Document("Card")
@Data
public class Card {
    @Id
    private String id;
    @Field(name = "name")
    private String name;
    private List<ManaCost> manaCost;
    @Field(name = "type")
    private String type;
    private String description;
}