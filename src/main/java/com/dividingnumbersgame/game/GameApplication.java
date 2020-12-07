package com.dividingnumbersgame.game;

import com.dividingnumbersgame.game.Game.GameExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameApplication {

    private static GameExecutor gameExecutor;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GameApplication.class, args);

//        new GameExecutor().play();
    }

}
