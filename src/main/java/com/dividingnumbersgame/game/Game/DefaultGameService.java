package com.dividingnumbersgame.game.Game;

public interface DefaultGameService {

    /**
     * Game starts
     */
    void startGame(Game game) throws Exception;

    /**
     * Game stops
     */
    void stopGame();

    /**
     * adds computer player
     */
    void addComputer();

    /**
     * add human player
     */
    void addHuman();
}
