package com.api.Magic.Model.Entity;

import com.api.Magic.Model.Enum.CardType;
import com.api.Magic.Model.Enum.CreatureType;

public class CreatureCard extends Card{
    private CreatureType creatureType;
    private String defense;
    private String power;

    public CreatureCard(String name, CardType cardType, CreatureType creatureType, ManaCost manaCost, String description,
                        String power, String defense) {
        super(name, cardType, manaCost, description);

        this.creatureType = creatureType;
        this.power = power;
        this.defense = defense;
    }

    public void getInfo(){

        String infoName = this.getName();

        System.out.println("Card Info \nName: " + infoName +
                                    "\nCardType: " + this.getType() + " - " + this.creatureType +
                                    "\nMana Cost: " + this.getManaCost().getManaCostInfo() +
                                    "\nDescription: " + this.getDescription() +
                                    "\nPower: " + this.power + " - Defense: " + this.defense);
    }
}
