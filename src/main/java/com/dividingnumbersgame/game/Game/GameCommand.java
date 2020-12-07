package com.dividingnumbersgame.game.Game;

public class GameCommand {

    private String commmand;

    public GameCommand() {}

    public GameCommand(String commmand)
    {
        this.commmand = commmand;
    }

    public String getCommmand()
    {
        return commmand;
    }

    public void setCommmand(String text)
    {
        this.commmand = text;
    }
}
