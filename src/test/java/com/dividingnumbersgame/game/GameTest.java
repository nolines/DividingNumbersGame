package com.dividingnumbersgame.game;

import com.dividingnumbersgame.game.Game.Game;
import com.dividingnumbersgame.game.Player.Human;
import com.dividingnumbersgame.game.Player.Player;
import com.dividingnumbersgame.game.Player.PlayerService;
import com.dividingnumbersgame.game.Player.PlayerType;
import com.dividingnumbersgame.game.Round.Round;
import com.dividingnumbersgame.game.Round.RoundInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class GameTest {

    @Mock
    private Round roundMock;
    @Mock
    private PlayerService playerServiceMock;

    private Game underTest;

    public void setup(){
        underTest = new Game(roundMock, playerServiceMock);
    }

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

    @Test
    public void shouldHaveWinnerAndStatusIsFinish() throws Exception {

        Human human = new Human("human1", PlayerType.HUMAN);
        List<Player> players = new ArrayList<>();
        players.add(human);

        when(roundMock.getRoundInput()).thenReturn(new RoundInput(3));
        when(roundMock.getPlayer()).thenReturn(human);
        when(playerServiceMock.getPlayers()).thenReturn(players);

        Game expected = new Game(roundMock, playerServiceMock);
        assertEquals(expected.getGameStatus(), Game.Status.FINISH);
        assertTrue(expected.isWinner(3));
    }

}
