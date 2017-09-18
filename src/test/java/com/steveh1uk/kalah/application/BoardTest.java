package com.steveh1uk.kalah.application;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    private int numberHouses = 6;
    private int numberSeeds = 4;

    @Test
    public void createBoard() {


        Board board = new Board.Builder().setHouses(numberHouses).setSeeds(numberSeeds).build();

        // check player 1 initial setup
        assertEquals("Player 1 Store Seeds Count", 0, board.getPlayer1().getStore().getSeeds());
        assertEquals("Player 1 Store has correct player", board.getPlayer1(), board.getPlayer1().getStore().getPlayer());

        for (House house:board.getPlayer1().getHouses()
             ) {
            assertEquals("House has correct number of initial seeds" , numberSeeds, house.getSeeds());
        }

        // check player 2 initial setup
        assertEquals("Player 2 Store Seeds Count", 0, board.getPlayer2().getStore().getSeeds());
        assertEquals("Player 2 Store has correct player", board.getPlayer2(), board.getPlayer2().getStore().getPlayer());

        for (House house:board.getPlayer2().getHouses()
                ) {
            assertEquals("House has correct number of initial seeds" , numberSeeds, house.getSeeds());
        }

        assertEquals("Initial active player", board.getPlayer1(), board.getActivePlayer());
    }

    @Test
    public void firstMove() {

        Board board = new Board.Builder().setHouses(numberHouses).setSeeds(numberSeeds).build();

        House house = board.retrieveCurrentHouse(5);

        assertEquals(board.getPlayer1(), house.getPlayer());
        assertEquals(numberSeeds, house.getSeeds());

        House houseSix = (House) board.retrieveNextPit();
        assertEquals(board.getPlayer1(), houseSix.getPlayer());
        assertEquals(numberSeeds, houseSix.getSeeds());

        Store player1Store = (Store) board.retrieveNextPit();
        assertEquals(board.getPlayer1(), player1Store.getPlayer());
        assertEquals(0, player1Store.getSeeds());

        House player2HouseOne = (House) board.retrieveNextPit();
        assertEquals(board.getPlayer2(), player2HouseOne.getPlayer());
        assertEquals(numberSeeds, player2HouseOne.getSeeds());

        House player2HouseTwo = (House) board.retrieveNextPit();
        assertEquals(board.getPlayer2(), player2HouseTwo.getPlayer());
        assertEquals(numberSeeds, player2HouseTwo.getSeeds());

    }

    @Test
    public void switchPlayer() {
        Board board = new Board.Builder().setHouses(numberHouses).setSeeds(numberSeeds).build();
        assertEquals("Initial active player", board.getPlayer1(), board.getActivePlayer());

        board.switchActivePlayer();
        assertEquals("Switched active player", board.getPlayer2(), board.getActivePlayer());

        board.switchActivePlayer();
        assertEquals("Switched back active player", board.getPlayer1(), board.getActivePlayer());

    }

}