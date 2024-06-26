package com.api.Magic.Model.Entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("ManaType")
@Data
public class ManaType{

    @Id
    private String id;

    @Field(name = "manaType")
    private String manaType;
}
