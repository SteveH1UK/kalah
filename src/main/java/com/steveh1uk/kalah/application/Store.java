package com.steveh1uk.kalah.application;

public class Store extends Pit {
    public Store(int initialSeeds, Player player) {
        super(initialSeeds, player);
    }

    void addSeeds(int extraSeeds) {
        seeds = seeds + extraSeeds;
    }
}
