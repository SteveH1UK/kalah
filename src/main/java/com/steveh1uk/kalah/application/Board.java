package com.steveh1uk.kalah.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    private final CircularList<Pit> circularList;

    private final Player player1 = new Player(1);
    private final Player player2 = new Player(2);

    private Player activePlayer = player1;

    // creates the board for the game
    private Board(int houses, int seeds) {

        for (Player player: getPlayers()
             ) {
            for (int i = 0; i < houses; i++) {
                player.addHouse(seeds);
            }
        }

        player1.calculateOppositeHouses(player2);
        player2.calculateOppositeHouses(player1);

        List<Pit> pits = new ArrayList<>();
        pits.addAll(player1.getHouses());
        pits.add(player1.getStore());
        pits.addAll(player2.getHouses());
        pits.add(player2.getStore());
        circularList =  new CircularList<>(pits);
    }

    House retrieveCurrentHouse(int houseNumber) {
        if (houseNumber < 1 || houseNumber > player1.getHouses().size()) {
            return null;
        }
        int index = houseNumber - 1;
        if (activePlayer.equals(player2)) {
            index = index + player1.getHouses().size() + 1; // add one for the store
        }
        return (House) circularList.retrieveCurrentItem(index);
    }

    Pit retrieveNextPit() {
        return circularList.retrieveNextItem();
    }

    void switchActivePlayer() {
        if (activePlayer.equals(player1)) {
            activePlayer = player2;
        }
        else {
            activePlayer = player1;
        }
    }

    static class Builder {
        private int houses;
        private int seeds;

        Builder setHouses(int houses) {
            this.houses = houses;
            return this;
        }

        Builder setSeeds(int seeds) {
            this.seeds = seeds;
            return this;
        }

        Board build() {
            return new Board(houses, seeds);
        }
    }


    Player getPlayer1() {
        return player1;
    }

    Player getPlayer2() {
        return player2;
    }

    Player getActivePlayer() {
        return activePlayer;
    }

    private List<Player> getPlayers() {
        return Arrays.asList(player1, player2);
    }

}
