package com.dividingnumbersgame.game.Round;

import java.util.Random;

public class RoundResult {
    private final int result;

    public RoundResult(int result) {
        this.result = result;
        printMessage(result);
    }

    public int getResult() {
        return result;
    }

    private void printMessage(int result) {
        System.out.println("The result number is " + result);
    }

    public static int getRandomInitialNumber() {
        Random r = new Random();
        int low = 10;
        int high = 100;
        return r.nextInt(high - low) + low;
    }
}
