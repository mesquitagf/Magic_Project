package com.api.Magic.Model.Entity;

import jakarta.persistence.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document("ManaType")
public class ManaType {

    @Id
    private ObjectId id;

    private String manaType;

    public ManaType(ObjectId id, String manaType) {
        this.id = id;
        this.manaType = manaType;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getManaType() {
        return manaType;
    }

    public void setManaType(String manaType) {
        this.manaType = manaType;
    }
}
