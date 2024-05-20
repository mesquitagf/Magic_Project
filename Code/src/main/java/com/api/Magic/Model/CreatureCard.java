package com.api.Magic.Model;

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
                                    "\nCardType: " + this.getType() + " " + this.creatureType);;
    }
}
