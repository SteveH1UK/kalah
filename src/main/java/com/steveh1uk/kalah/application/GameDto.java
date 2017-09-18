package com.steveh1uk.kalah.application;


/**
 *  This class is used to display the current state of the game to clients
 */
public class GameDto {

    public static final String BLANK_MESSAGE = "";

    private final int activePlayerId;

    private final PlayerDto player1;

    private final PlayerDto player2;

    private final boolean finished;

    private final String result;

    private final boolean validMove;

    private final String message;

    public GameDto(Board board, boolean finished, int winner, boolean validMove, String message) {

        activePlayerId = board.getActivePlayer().getId();
        player1 = new PlayerDto(board.getPlayer1(), 1 == activePlayerId);
        player2 = new PlayerDto(board.getPlayer2(), 2 == activePlayerId);
        this.finished = finished;
        this.validMove = validMove;
        this.message = message;
        switch (winner) {
            case -1:
                result = "Undecided";
                break;
            case 0:
                result = "Draw";
                break;
            case 1:
            case 2:
                result = "Player " + winner + " wins";
                break;
            default:
                throw new IllegalArgumentException("unexpected winner value " + winner);

        }
    }

    public int getActivePlayerId() {
        return activePlayerId;
    }

    public PlayerDto getPlayer1() {
        return player1;
    }

    public PlayerDto getPlayer2() {
        return player2;
    }

    public boolean isFinished() {
        return finished;
    }

    public String getResult() {
        return result;
    }

    public boolean isValidMove() {
        return validMove;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "GameDto{" +
                "activePlayerId=" + activePlayerId +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", finished=" + finished +
                ", result='" + result + '\'' +
                ", validMove=" + validMove +
                ", message='" + message + '\'' +
                '}';
    }
}
