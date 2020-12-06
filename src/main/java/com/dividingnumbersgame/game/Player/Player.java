package com.dividingnumbersgame.game.Player;

import java.util.UUID;

public class Player {

    private final UUID id;
    private final String name;
    private final PlayerType type;

    public Player(UUID id, String name, PlayerType type) {
        String name1;
        if(this instanceof Computer){
            name1 = name + id.toString();
        }
        this.id = id;
        name1 = name;
        this.name = name1;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public PlayerType getType() {
        return type;
    }

    public UUID getId() {
        return id;
    }

}
