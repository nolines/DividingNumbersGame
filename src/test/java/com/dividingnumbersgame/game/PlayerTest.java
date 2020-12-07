package com.dividingnumbersgame.game;

import com.dividingnumbersgame.game.Player.Computer;
import com.dividingnumbersgame.game.Player.Human;
import com.dividingnumbersgame.game.Player.Player;
import com.dividingnumbersgame.game.Player.PlayerType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@ExtendWith(SpringExtension.class)
public class PlayerTest {

    @Test
    public void shouldAddHumanPlayer(){
        Human human = new Human("human1", PlayerType.HUMAN);

        assertTrue(human instanceof Player);
        assertNotNull(human.getId());
    }

    @Test
    public void shouldAddComputerPlayer(){
        Computer computer = new Computer("computer1", PlayerType.COMPUTER);

        assertTrue(computer instanceof Player);
        assertNotNull(computer.getId());
    }
}
