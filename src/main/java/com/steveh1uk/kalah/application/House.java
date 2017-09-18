package com.steveh1uk.kalah.application;

public class House extends Pit {

    private House oppositeHouse;

    public House(int initialSeeds, Player player) {
        super(initialSeeds, player);
    }

    public void setOppositeHouse(House oppositeHouse) {
        this.oppositeHouse = oppositeHouse;
    }


    public int removeOppositeHouseSeeds() {
        int opponentsSeeds = oppositeHouse.getSeeds();
        oppositeHouse.removeAllSeeds();
        return opponentsSeeds;
    }
}
