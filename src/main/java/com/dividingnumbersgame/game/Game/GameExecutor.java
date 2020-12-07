package com.dividingnumbersgame.game.Game;

import com.dividingnumbersgame.game.Player.Computer;
import com.dividingnumbersgame.game.Player.Player;
import com.dividingnumbersgame.game.Player.PlayerService;
import com.dividingnumbersgame.game.Player.PlayerType;
import com.dividingnumbersgame.game.Round.Round;
import com.dividingnumbersgame.game.Round.RoundInput;
import com.dividingnumbersgame.game.Round.RoundResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class GameExecutor {

    private int ROOT_INDEX = 0;

    private GameService gameService;

    private PlayerService playerService;

    public GameExecutor() {
    }

    public void play() throws Exception {

        List<Player> players = new ArrayList<>();
        players.add(new Computer("computer1", PlayerType.COMPUTER));
        playerService = new PlayerService(players, 0);
        players.add(new Computer("computer2", PlayerType.COMPUTER));
        playerService = new PlayerService(players, 1);

        Round round = new Round();
        round.setPlayer(playerService.getPlayers().get(ROOT_INDEX));
        int initialNumber = RoundResult.getRandomInitialNumber();
        round.setRoundInput(new RoundInput(initialNumber));
        System.out.println("Game started with number: " + initialNumber);

        playerService.setIdx(ROOT_INDEX);
        Game game = new Game(round, playerService);
        new GameService().startGame(game);
    }
}
