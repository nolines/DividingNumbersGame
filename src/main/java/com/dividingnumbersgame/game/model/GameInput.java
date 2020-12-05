package com.dividingnumbersgame.game.model;

public class GameInput {

    private int value;

    public GameInput(int value) throws Exception {
        validate(value);
        this.value = value;
    }

    public boolean validate(int value) throws Exception {
        if (value > 2) {
            return true;
        } else if (value < 0) {
            throw new Exception("Input parameter should not be negative!");
        } else {
            ///TODO: throw specific error
            throw new Exception("Input parameter is invalid!");
        }
    }

    public int getValue() {
        return value;
    }
}
