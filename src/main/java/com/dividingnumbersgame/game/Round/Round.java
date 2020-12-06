package com.dividingnumbersgame.game.Round;

import com.dividingnumbersgame.game.Player.Player;

import static com.dividingnumbersgame.game.utils.GameConstants.*;

public class Round {
    private Player player;
    private RoundInput roundInput;

    public Round(Player player, RoundInput roundInput) {
        this.player = player;
        this.roundInput = roundInput;
    }

    public Round() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public RoundInput getRoundInput() {
        return roundInput;
    }

    public void setRoundInput(RoundInput roundInput) {
        this.roundInput = roundInput;
    }

    public int findNearestDividedNumber(int value) {
        return (value + OPERATIONS[value % DIVIDING_NUMBER]) / DIVIDING_NUMBER;
    }

    private boolean isWinnerMove(RoundInput roundInput) {
        return (roundInput.getValue() / DIVIDING_NUMBER) == WINNER_NUMBER;
    }
}
