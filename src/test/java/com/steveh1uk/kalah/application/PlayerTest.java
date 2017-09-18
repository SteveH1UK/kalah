package com.steveh1uk.kalah.application;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void countSeedsInHouses() throws Exception {
        Player player = new Player(1);
        player.addHouse(3);
        player.addHouse(9);
        player.addHouse(8);

        assertEquals("Expected count of seeds", 20, player.countSeedsInHouses());
    }


    @Test
    public void removeAllSeedsInHouses() throws Exception {
        Player player = new Player(1);
        player.addHouse(5);
        player.addHouse(3);
        player.addHouse(2);

        player.moveRemainingSeedsToStore();

        assertEquals("Expected count of seeds in houses", 0, player.countSeedsInHouses());
        assertEquals("Expected count of seeds in Store", 10, player.getStore().getSeeds());

    }

}