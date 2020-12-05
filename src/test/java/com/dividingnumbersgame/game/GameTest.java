package com.dividingnumbersgame.game;

import com.dividingnumbersgame.game.model.Game;
import com.dividingnumbersgame.game.model.GameInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
public class GameTest {

    @Test
    public void shouldGameHasWinnerAndStatusIsWon() throws Exception {
        Game expected = new Game( new GameInput(3));

        assertEquals(expected.getGameStatus(), Game.Status.WON);
    }

    @Test
    public void shouldGameHasNoWinnerAndStatusInProgress() throws Exception {
        Game expected = new Game( new GameInput(8));

        assertEquals(expected.getGameStatus(), Game.Status.IN_PROGRESS);
    }

}
