package com.steveh1uk.kalah.application;

import java.util.Arrays;

/**
 * Displays the players seeds to a client
 */
public class PlayerDto {

    private final int Store;
    private final int[] houses;
    private final boolean[] houseActive;


    public PlayerDto(final Player player, boolean isActivePlayer) {
        Store = player.getStore().getSeeds();
        // TODO - use Java 8 streams?
        int numberOfHouses = player.getHouses().size();
        houses = new int[numberOfHouses];
        houseActive = new boolean[numberOfHouses];
        for (int index = 0; index < numberOfHouses; index ++) {
            houses[index] = player.getHouses().get(index).getSeeds();
            houseActive[index] = isActivePlayer && player.getHouses().get(index).getSeeds() > 0;
        }
    }

    public int getStore() {
        return Store;
    }
    

    public int[] getHouses() {
        return houses;
    }


    public boolean[] getHouseActive() {
        return houseActive;
    }

    @Override
    public String toString() {
        return "PlayerDto{" +
                "Store=" + Store +
                ", houses=" + Arrays.toString(houses) +
                ", houseActive=" + Arrays.toString(houseActive) +
                '}';
    }
}
