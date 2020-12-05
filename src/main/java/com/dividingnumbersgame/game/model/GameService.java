package com.dividingnumbersgame.game.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameService implements DefaultGameService{

    Logger log = LoggerFactory.getLogger(GameService.class);

    @Override
    public void startGame() {
        log.info("Starting a new game!");
    }

    @Override
    public void stopGame() {
        log.info("Stopped the game!");

    }
}
