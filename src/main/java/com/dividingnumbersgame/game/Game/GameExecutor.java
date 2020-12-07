package com.dividingnumbersgame.game.Game;

import com.dividingnumbersgame.game.Player.*;
import com.dividingnumbersgame.game.Round.Round;
import com.dividingnumbersgame.game.Round.RoundInput;
import com.dividingnumbersgame.game.Round.RoundResult;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameExecutor {

    private int ROOT_INDEX = 0;

    private GameService gameService;

    private PlayerService playerService;

    public GameExecutor() throws Exception {
    }

    public Game.Status playComputers(Computer computer1, Computer computer2) throws Exception {

        List<Player> players = new ArrayList<>();
        players.add(computer1);
        playerService = new PlayerService(players, 0);
        players.add(computer2);
        playerService = new PlayerService(players, 1);

        Round round = new Round();
        round.setPlayer(playerService.getPlayers().get(ROOT_INDEX));
        int initialNumber = RoundResult.getRandomInitialNumber();
        round.setRoundInput(new RoundInput(initialNumber));
        System.out.println("Game started with number: " + initialNumber);

        playerService.setIdx(ROOT_INDEX);
        Game game = new Game(round, playerService);
        return new GameService().startGame(game);
    }

    public Game.Status playAgainstComputer(Human human) throws Exception {
        List<Player> players = new ArrayList<>();
        players.add(human);
        playerService = new PlayerService(players, 0);
        Computer computer1 = new Computer("computer1", PlayerType.COMPUTER);
        players.add(computer1);
        playerService = new PlayerService(players, 1);

        Round round = new Round();
        round.setPlayer(playerService.getPlayers().get(ROOT_INDEX));
        int initialNumber = RoundResult.getRandomInitialNumber();
        round.setRoundInput(new RoundInput(initialNumber));
        System.out.println("Game started with number: " + initialNumber);

        playerService.setIdx(ROOT_INDEX);
        Game game = new Game(round, playerService);
        return new GameService().startGame(game);
    }
}
