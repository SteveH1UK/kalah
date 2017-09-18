package com.steveh1uk.kalah.application;

/**
 * Smaller game to limit the number of tests I have to write
 * to cover different game scenarios
 */
public class TestGame extends Game {


    private final static int NUMBER_OF_HOUSES = 3;
    private final static int NUMBER_OF_SEEDS = 2;

    public TestGame() {

        board = new Board.Builder().setHouses(NUMBER_OF_HOUSES).setSeeds(NUMBER_OF_SEEDS).build();
    }
}
