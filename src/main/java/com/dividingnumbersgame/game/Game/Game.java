package com.dividingnumbersgame.game.Game;

import com.dividingnumbersgame.game.Player.Human;
import com.dividingnumbersgame.game.Player.Player;
import com.dividingnumbersgame.game.Player.PlayerService;
import com.dividingnumbersgame.game.Round.Round;
import com.dividingnumbersgame.game.Round.RoundInput;
import com.dividingnumbersgame.game.Round.RoundResult;

import java.util.Scanner;

import static com.dividingnumbersgame.game.utils.GameConstants.DIVIDING_NUMBER;
import static com.dividingnumbersgame.game.utils.GameConstants.WINNER_NUMBER;

public class Game {

    private Status gameStatus;
    private Round round;
    private PlayerService playerService;

    public Status getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(Status gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    /**
     * Base game logic
     */
    public void play() throws Exception {
        Scanner scanner = new Scanner(System.in);

        RoundInput roundInput = this.round.getRoundInput();

        int calculatedResult = calculateResult(scanner, roundInput);
        RoundResult roundResult = new RoundResult(calculatedResult);

        playerService = this.playerService.next();
        int idx = playerService.getIdx();
        Player nextPlayer = playerService.getPlayers().get(idx);
        checkWinner(calculatedResult, roundResult, nextPlayer);
    }

    /**
     * It calculates result according to @PlayerType
     */
    private int calculateResult(Scanner scanner, RoundInput roundInput) {
        int calculatedResult;
        if(playerService.getPlayers().get(playerService.getIdx()) instanceof Human){
            // 0, -1, 1
            System.out.println("Enter your action [0, -1, 1]");
            int operation = scanner.nextInt();
            calculatedResult = roundInput.getValue() + (operation);
        } else {
            calculatedResult = this.round.findNearestDividedNumber(roundInput.getValue());
        }
        return calculatedResult;
    }

    /**
     * Check if there is an winner on the round
     * Works like post-validator
     */
    private void checkWinner(int calculatedResult, RoundResult roundResult, Player nextPlayer) throws Exception {
        RoundInput roundInput;
        if (!isWinner(calculatedResult)) {
            roundInput = new RoundInput(roundResult.getResult());
            this.round = new Round(nextPlayer, roundInput);
            new Game(this.round, playerService);
        } else {
            //Game win event needs to be thrown
            System.out.println(nextPlayer.getName() + " won the game!");
        }
    }

    /**
     * Stores game status
     * WAITING = waiting players
     * IN_PROGRESS = creating instance
     * WON = There is a winner, end event should be triggered
     */
    public enum Status {
        WAITING, IN_PROGRESS, FINISH
    }

    public Game(Round round, PlayerService playerService) {
        System.out.println(round.getPlayer().getName() + " 's turn playing with number: " + round.getRoundInput().getValue());
        this.gameStatus = Status.IN_PROGRESS;
        this.round = round;
        this.playerService = playerService;
        isWinner(round.getRoundInput().getValue());
    }

    /**
     * checks the current round with the new value
     * result if the player is winner
     */
    public boolean isWinner(int value) {
        if ((value / DIVIDING_NUMBER) == WINNER_NUMBER) {
            this.gameStatus = Status.FINISH;
            return true;
        } else return false;
    }
}
