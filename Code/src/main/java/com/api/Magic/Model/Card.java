package com.api.Magic.Model;

public class Card {
    private String name;
    private ManaCost manaCost;
    private CardType type;
    private String description;

    public Card(String name, CardType type, ManaCost manaCost, String description) {
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

    public ManaCost getManaCost() {
        return manaCost;
    }

    public void setManaCost(ManaCost manaCost) {
        this.manaCost = manaCost;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
