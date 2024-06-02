package com.api.Magic.Model.Entity;


public class ManaCost {
    private String manaType;
    private int cost;

    public ManaCost(String manaType, int cost) {
        this.manaType = manaType;
        this.cost = cost;
    }

    public String getManaType() {
        return manaType;
    }

    public void setManaType(String manaType) {
        this.manaType = manaType;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}


