package com.dividingnumbersgame.game.Player;

import java.util.UUID;

public class Computer extends Player {
    public Computer(String name, PlayerType type) {
        super(UUID.randomUUID(), name, type);
    }
}
