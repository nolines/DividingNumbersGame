package com.dividingnumbersgame.game;

import com.dividingnumbersgame.game.Game.Game;
import com.dividingnumbersgame.game.Player.Human;
import com.dividingnumbersgame.game.Player.Player;
import com.dividingnumbersgame.game.Player.PlayerService;
import com.dividingnumbersgame.game.Player.PlayerType;
import com.dividingnumbersgame.game.Round.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
public class GameTest {

    @Test
    public void shouldGameHasWinnerAndStatusIsFinish() throws Exception {

        Human human = new Human("human1", PlayerType.HUMAN);
        RoundInput roundInput = new RoundInput(3);
        List<Player> players = new ArrayList<>();
        players.add(human);
        Game expected = new Game( new Round(human, roundInput), new PlayerService(players, 0));

        assertEquals(expected.getGameStatus(), Game.Status.FINISH);
    }

    @Test
    public void shouldGameHasNoWinnerAndStatusInProgress() throws Exception {
        Human human = new Human("human1", PlayerType.HUMAN);
        RoundInput roundInput = new RoundInput(8);
        List<Player> players = new ArrayList<>();
        players.add(human);
        Game expected = new Game( new Round(human, roundInput), new PlayerService(players, 0));
        assertEquals(expected.getGameStatus(), Game.Status.IN_PROGRESS);
    }

}
