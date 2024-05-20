package com.api.Magic.Model;

public class ManaCost {
    private ManaType manaType;
    private int cost;

    public ManaCost(ManaType manaType, int cost) {
        this.manaType = manaType;
        this.cost = cost;
    }

    public void setManaCost(ManaType manaType, int cost){
        this.manaType = manaType;
        this.cost = cost;
    };

    public String getManaCostInfo(){
        return (this.cost + " - type: " + this.manaType);
    }
}
