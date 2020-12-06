package com.dividingnumbersgame.game.Player;

import java.util.UUID;

public class Human extends Player {
    public Human(String name, PlayerType type) {
        super(UUID.randomUUID(), name, type);
    }
}
