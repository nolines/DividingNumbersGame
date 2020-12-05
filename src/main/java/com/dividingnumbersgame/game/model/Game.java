package com.dividingnumbersgame.game.model;

import static com.dividingnumbersgame.game.utils.GameConstants.DIVIDING_NUMBER;
import static com.dividingnumbersgame.game.utils.GameConstants.WINNER_NUMBER;

public class Game {

    private int Id;
    private Status gameStatus;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Status getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Status gameStatus) {
        this.gameStatus = gameStatus;
    }


    /**
     *  Stores game status
     *  WAITING = waiting players
     *  IN_PROGRESS = creating instance
     *  WON = There is a winner, end event should be triggered
     * */
    public enum Status {
        WAITING, IN_PROGRESS, WON
    }

    public Game(GameInput gameInput) {
        if (isWinnerMove(gameInput)) {
            this.gameStatus = Status.WON;
        } else {
            this.gameStatus = Status.IN_PROGRESS;
        }
        //TODO: game will be validated with player and its turn
    }

    private boolean isWinnerMove(GameInput gameInput) {
        return (gameInput.getValue() / DIVIDING_NUMBER) == WINNER_NUMBER;
    }

}
