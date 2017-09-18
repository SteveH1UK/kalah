package com.steveh1uk.kalah.application;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {


    @Test
    public void playFullGame() throws Exception {

        Game game = new Game();

        GameDto gameDto = game.newGameState();
        System.out.println("Initial setup" + gameDto);
        assertFalse(gameDto.isFinished());
        checkInitialBoard(gameDto);

        gameDto = game.play(4);
        System.out.println("First play" + gameDto);
        assertFalse(gameDto.isFinished());
        checkFirstPlay(gameDto);

        gameDto = game.play(5);
        System.out.println("Second play" + gameDto);
        assertFalse(gameDto.isFinished());
        checkSecondPlay(gameDto);

        gameDto = game.play(1);
        System.out.println("Third play" + gameDto);
        assertFalse(gameDto.isFinished());
        checkThirdPlay(gameDto);

        gameDto = game.play(1);
        System.out.println("Fourth play" + gameDto);
        assertFalse(gameDto.isFinished());
        checkFourthPlay(gameDto);
    }

    private void checkInitialBoard(final GameDto gameDto) {
        assertEquals(1, gameDto.getActivePlayerId());
        assertEquals(4, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[3]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[4]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[5]);
        assertEquals(0, gameDto.getPlayer1().getStore());
        assertTrue(gameDto.getPlayer1().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[3]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[4]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[5]);

        assertEquals(4, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[3]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[4]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[5]);
        assertEquals(0, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[3]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[4]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[5]);
    }


    private void checkFirstPlay(final GameDto gameDto) {
        assertEquals(2, gameDto.getActivePlayerId());
        assertEquals(4, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[3]);
        assertEquals(5, gameDto.getPlayer1().getHouses()[4]);
        assertEquals(5, gameDto.getPlayer1().getHouses()[5]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[3]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[4]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[5]);

        assertEquals(5, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[3]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[4]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[5]);
        assertEquals(0, gameDto.getPlayer2().getStore());
        assertTrue(gameDto.getPlayer2().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[2]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[3]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[4]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[5]);
    }

    private void checkSecondPlay(final GameDto gameDto) {
        assertEquals(1, gameDto.getActivePlayerId());
        assertEquals(5, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(5, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[3]);
        assertEquals(5, gameDto.getPlayer1().getHouses()[4]);
        assertEquals(5, gameDto.getPlayer1().getHouses()[5]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertTrue(gameDto.getPlayer1().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[3]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[4]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[5]);

        assertEquals(5, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[3]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[4]);
        assertEquals(5, gameDto.getPlayer2().getHouses()[5]);
        assertEquals(1, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[3]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[4]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[5]);
    }

    private void checkThirdPlay(final GameDto gameDto) {
        assertEquals(2, gameDto.getActivePlayerId());
        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(6, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(5, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer1().getHouses()[3]);
        assertEquals(6, gameDto.getPlayer1().getHouses()[4]);
        assertEquals(6, gameDto.getPlayer1().getHouses()[5]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[3]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[4]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[5]);

        assertEquals(5, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[3]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[4]);
        assertEquals(5, gameDto.getPlayer2().getHouses()[5]);
        assertEquals(1, gameDto.getPlayer2().getStore());
        assertTrue(gameDto.getPlayer2().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[2]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[3]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[4]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[5]);
    }

    private void checkFourthPlay(final GameDto gameDto) {
        assertEquals(1, gameDto.getActivePlayerId());
        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(6, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(5, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer1().getHouses()[3]);
        assertEquals(6, gameDto.getPlayer1().getHouses()[4]);
        assertEquals(6, gameDto.getPlayer1().getHouses()[5]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[3]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[4]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[5]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(5, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(5, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(5, gameDto.getPlayer2().getHouses()[3]);
        assertEquals(1, gameDto.getPlayer2().getHouses()[4]);
        assertEquals(6, gameDto.getPlayer2().getHouses()[5]);
        assertEquals(1, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[3]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[4]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[5]);
    }


    /*
     *  Smaller game to simplify testing scenarios
     *
     */
    @Test
    public void playTestGame () {
        TestGame game = new TestGame();

        GameDto gameDto = game.newGameState();
        System.out.println("Initial Setup" + gameDto);
        checkTestGameInitialBoard(gameDto);

        gameDto = game.play(3);
        System.out.println("First play" + gameDto);
        checkTestGameFirstPlay(gameDto);

        gameDto = game.play(1);
        System.out.println("Second play (test landing in store on last turn" + gameDto);
        checkTestGameSecondPlay(gameDto);

        gameDto = game.play(1);
        System.out.println("Third play (select house with no seeds)" + gameDto);
        checkTestGameThirdPlay(gameDto);

        gameDto = game.play(3);
        System.out.println("Fourth play" + gameDto);
        checkTestGameFourthPlay(gameDto);

        gameDto = game.play(1);
        System.out.println("Fifth play" + gameDto);
        checkTestGameFifthPlay(gameDto);

        gameDto = game.play(2);
        System.out.println("Sixth play" + gameDto);
        checkTestGameSixthPlay(gameDto);

        gameDto = game.play(2);
        System.out.println("Seventh play" + gameDto);
        checkTestGameSeventhPlay(gameDto);

        gameDto = game.play(1);
        System.out.println("Eighth play " + gameDto);
        checkTestGameEightPlay(gameDto);

        gameDto = game.play(1);
        System.out.println("Ninth play (gets opposite seeds as last seed lands on a seedless house) " + gameDto);
        checkTestGameNinthPlay(gameDto);

        gameDto = game.play(4);
        System.out.println("Tenth play (house number too big)" + gameDto);
        checkTestGameTenthPlay(gameDto);

        gameDto = game.play(3);
        System.out.println("Eleventh play " + gameDto);
        checkTestGameEleventhPlay(gameDto);

        gameDto = game.play(3);
        System.out.println("Twelfth play " + gameDto);
        checkTestGameTwelfthPlay(gameDto);
    }



    private void checkTestGameInitialBoard(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(1, gameDto.getActivePlayerId());

        assertEquals(2, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(0, gameDto.getPlayer1().getStore());
        assertTrue(gameDto.getPlayer1().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(2, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(2, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(0, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }


    private void checkTestGameFirstPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(2, gameDto.getActivePlayerId());

        assertEquals(2, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(3, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(2, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(0, gameDto.getPlayer2().getStore());
        assertTrue(gameDto.getPlayer2().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[2]);
    }

    private void checkTestGameSecondPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(2, gameDto.getActivePlayerId());

        assertEquals(2, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(3, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(3, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[2]);
    }

    private void checkTestGameThirdPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertFalse(gameDto.isValidMove());

        assertEquals("You can not use a house without seeds", gameDto.getMessage());
        assertEquals(2, gameDto.getActivePlayerId());

        assertEquals(2, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(3, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(3, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[2]);
    }

    private void checkTestGameFourthPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(1, gameDto.getActivePlayerId());

        assertEquals(3, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(3, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(1, gameDto.getPlayer1().getStore());
        assertTrue(gameDto.getPlayer1().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(3, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(2, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }


    private void checkTestGameFifthPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(1, gameDto.getActivePlayerId());

        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(1, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(2, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(3, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(2, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }


    private void checkTestGameSixthPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(2, gameDto.getActivePlayerId());

        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(3, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(1, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(4, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(2, gameDto.getPlayer2().getStore());
        assertTrue(gameDto.getPlayer2().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }


    private void checkTestGameSeventhPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(1, gameDto.getActivePlayerId());

        assertEquals(1, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(1, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(3, gameDto.getPlayer1().getStore());
        assertTrue(gameDto.getPlayer1().getHouseActive()[0]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(1, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(1, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(3, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }


    private void checkTestGameEightPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(2, gameDto.getActivePlayerId());

        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(3, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(1, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(1, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(3, gameDto.getPlayer2().getStore());
        assertTrue(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer2().getHouseActive()[2]);
    }

    private void checkTestGameNinthPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(1, gameDto.getActivePlayerId());

        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(3, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(1, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(6, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }


    private void checkTestGameTenthPlay(final GameDto gameDto) {
        assertFalse(gameDto.isFinished());
        assertFalse(gameDto.isValidMove());

        assertEquals("You can not select a house number outside the range of houses in the game", gameDto.getMessage());
        assertEquals(1, gameDto.getActivePlayerId());

        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(2, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(3, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertTrue(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(1, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(6, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }

    private void checkTestGameEleventhPlay(GameDto gameDto) {
        assertTrue(gameDto.isFinished());
        assertEquals("Player 2 wins", gameDto.getResult());
        assertTrue(gameDto.isValidMove());

        assertEquals(GameDto.BLANK_MESSAGE, gameDto.getMessage());
        assertEquals(2, gameDto.getActivePlayerId());

        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(4, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(8, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }

    private void checkTestGameTwelfthPlay(GameDto gameDto) {
        assertTrue(gameDto.isFinished());
        assertFalse(gameDto.isValidMove());

        assertEquals("Game is already over", gameDto.getMessage());
        assertEquals(2, gameDto.getActivePlayerId());

        assertEquals(0, gameDto.getPlayer1().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer1().getHouses()[2]);
        assertEquals(4, gameDto.getPlayer1().getStore());
        assertFalse(gameDto.getPlayer1().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer1().getHouseActive()[2]);

        assertEquals(0, gameDto.getPlayer2().getHouses()[0]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[1]);
        assertEquals(0, gameDto.getPlayer2().getHouses()[2]);
        assertEquals(8, gameDto.getPlayer2().getStore());
        assertFalse(gameDto.getPlayer2().getHouseActive()[0]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[1]);
        assertFalse(gameDto.getPlayer2().getHouseActive()[2]);
    }

}