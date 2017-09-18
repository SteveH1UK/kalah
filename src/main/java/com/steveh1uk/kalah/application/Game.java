package com.steveh1uk.kalah.application;

/**
 *  This controls the playing of the  game
 */
public class Game {

    private final static int NUMBER_OF_HOUSES = 6;
    private final static int NUMBER_OF_SEEDS = 4;

    private final static boolean INVALID_MOVE = false;
    private final static boolean VALID_MOVE = true;

    Board board;

    private boolean isFinished = false;
    private int winner = -1; // -1 = undecided, 0 = draw, 1 = player 1, 2 = player 2


    public Game() {

        board = new Board.Builder().setHouses(NUMBER_OF_HOUSES).setSeeds(NUMBER_OF_SEEDS).build();
    }

    /**
     * A player makes a move - this algorithm is at the heart of the game
     *
     * @param houseNumber - the house number (from 1) for the active player
     */
    public GameDto play(int houseNumber) {

        String message = GameDto.BLANK_MESSAGE;
        if (isFinished) {
            return new GameDto(board, true, winner, INVALID_MOVE, "Game is already over");
        }

        House house = board.retrieveCurrentHouse(houseNumber);
        if (house == null) {
            return new GameDto(board, isFinished, winner, INVALID_MOVE, "You can not select a house number outside the range of houses in the game");
        }
        if (house.getSeeds() == 0) {
            return new GameDto(board, isFinished, winner, INVALID_MOVE, "You can not use a house without seeds");
        }

        Player currentPlayer = house.getPlayer();

        int seedsInSelectedHouse =  house.removeAllSeeds();

        Pit currentPit = null;
        while (seedsInSelectedHouse > 0) {
            currentPit = board.retrieveNextPit();

            if (currentPit instanceof House) {
                House currentHouse = (House) currentPit;
                if (emptyOwnHouseAndLastSeed(currentPlayer, seedsInSelectedHouse, currentHouse)) {
                    int opponentsSeeds = currentHouse.removeOppositeHouseSeeds();
                    currentPlayer.getStore().addSeeds(opponentsSeeds);
                    currentPlayer.getStore().incrementSeeds();
                }
                else {
                    currentPit.incrementSeeds();
                }
            }
            else { // a store
                if (currentPit.getPlayer().equals(currentPlayer)) {
                    currentPit.incrementSeeds();
                }
            }

            seedsInSelectedHouse--;
        }

        if ( ! lastSeedOwnStore(currentPlayer, currentPit)) {
            board.switchActivePlayer();
        }

        if (aPlayerHasNoSeedsInHouses(board)) {

            isFinished = true;
            winner = calculateWinner(board);
        }

        return new GameDto(board, isFinished, winner, VALID_MOVE, message);
    }

    public GameDto newGameState() {
        return new GameDto(board, isFinished, winner, VALID_MOVE, GameDto.BLANK_MESSAGE);
    }


    private int calculateWinner(Board board) {
        int player1SeedsInStore = board.getPlayer1().getStore().getSeeds();
        int player2SeedsInStore = board.getPlayer2().getStore().getSeeds();

        if (player1SeedsInStore > player2SeedsInStore) {
            return 1;
        }
        else if (player1SeedsInStore < player2SeedsInStore) {
            return 2;
        }
        else {
            return 0; // draw
        }
    }

    private boolean aPlayerHasNoSeedsInHouses(Board board) {
        // check both players since a player might loss all houses in another players turn with the "opposite house" rule

        if (board.getPlayer1().countSeedsInHouses() == 0) {
            board.getPlayer2().moveRemainingSeedsToStore();
            return true;
        }

        if (board.getPlayer2().countSeedsInHouses() == 0) {
            board.getPlayer1().moveRemainingSeedsToStore();
            return true;
        }

        return false;
    }

    private boolean emptyOwnHouseAndLastSeed(Player currentPlayer, int seedsLeftToDistribute, House currentHouse) {

        if ( currentPlayer.equals(currentHouse.getPlayer())
                && currentHouse.getSeeds() == 0
                && seedsLeftToDistribute == 1) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean lastSeedOwnStore(Player currentPlayer, Pit currentPit) {
        if (currentPit == null) {
            // occurs when no seeds are present in selected house
            return  false;
        }
        if (currentPit instanceof Store) {
            return currentPlayer.equals(currentPit.getPlayer());
        }
        else {
            return false;
        }
    }
}
