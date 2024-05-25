package com.api.Magic.Model.Entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Card")
public class Card {
    private String name;
    private List<ManaCost> manaCost;
    private String type;
    private String description;

    public Card(String name, List<ManaCost> manaCost, String type, String description) {
        this.name = name;
        this.manaCost = manaCost;
        this.type = type;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ManaCost> getManaCost() {
        return manaCost;
    }

    public void setManaCost(List<ManaCost> manaCost) {
        this.manaCost = manaCost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}