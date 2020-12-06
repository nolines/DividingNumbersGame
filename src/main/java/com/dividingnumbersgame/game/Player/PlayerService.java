package com.dividingnumbersgame.game.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PlayerService implements Iterator<PlayerService> {
    private List<Player> players = new ArrayList<>();
    private int idx;

    public PlayerService(List<Player> players, int idx) {
        this.players = players;
        this.idx = idx;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getIdx() {
        return this.idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public PlayerService addPlayer(final Player player) {
        List<Player> playerList = new ArrayList<>(players);
        playerList.add(player);
        return new PlayerService(Collections.unmodifiableList(playerList), playerList.indexOf(player));
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public PlayerService next() {
        return new PlayerService(players, (idx + 1) % players.size());
    }
}
