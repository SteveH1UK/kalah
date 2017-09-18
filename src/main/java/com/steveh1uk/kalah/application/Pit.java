package com.steveh1uk.kalah.application;

class Pit {

     private final Player player;
     int seeds;


    Pit(int initialSeeds, Player player) {
        this.seeds = initialSeeds;
        this.player = player;
    }

    Player getPlayer() {
        return player;
    }

    int getSeeds() {
        return seeds;
    }

    int removeAllSeeds() {
        int seedsBeforeRemoval = seeds;
        seeds = 0;
        return seedsBeforeRemoval;
    }

    void incrementSeeds() {
        seeds++;
    }
}
