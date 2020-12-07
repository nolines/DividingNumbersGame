package com.dividingnumbersgame.game.Game;

import com.dividingnumbersgame.game.Player.Computer;
import com.dividingnumbersgame.game.Player.Player;
import com.dividingnumbersgame.game.Player.PlayerService;
import com.dividingnumbersgame.game.Player.PlayerType;
import com.dividingnumbersgame.game.Round.Round;
import com.dividingnumbersgame.game.Round.RoundInput;
import com.dividingnumbersgame.game.Round.RoundResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
public class GameExecutor {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    private int ROOT_INDEX = 0;

    private GameService gameService;

    private PlayerService playerService;

    public GameExecutor() {
    }

    @MessageMapping("/message")
    @SendToUser("/queue/reply")
    public String processMessageFromClient(@Payload String message, Principal principal) throws Exception {
        String name = new Gson().fromJson(message, Map.class).get("name").toString();
        messagingTemplate.convertAndSendToUser(principal.getName(), "/queue/reply", name);
        return name;
    }

    @MessageExceptionHandler
    @SendToUser("/queue/errors")
    public String handleException(Throwable exception) {
        return exception.getMessage();
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
