package com.dividingnumbersgame.game.Game;

import org.springframework.stereotype.Service;

@Service
public class GameService implements DefaultGameService {

    @Override
    public void startGame(Game game) throws Exception {
        while (!game.getGameStatus().equals(Game.Status.FINISH)) {
            game.play();
        }
    }

    @Override
    public void stopGame() {
        System.out.println("Stopped the game!");
    }

    @Override
    public void addComputer() {

    }

    @Override
    public void addHuman() {

    }
}
