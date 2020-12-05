package com.dividingnumbersgame.game;

import com.dividingnumbersgame.game.model.GameInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class GameInputTest {

    private GameInput gameInput;

    @Test
    public void shouldGameInputBiggerThanInitialLimit() throws Exception {
        GameInput expected = new GameInput(3);
        assertNotNull(expected);
    }

    @Test
    public void shouldThrowExceptionWhenGameInputLowerThanInitialLimit() throws Exception {
        assertThrows(Exception.class, () ->  new GameInput(1).validate(1),"Input parameter is invalid!");
    }

    @Test
    public void shouldThrowExceptionWhenGameInputIfInputIsNegative() throws Exception {
        assertThrows(Exception.class, () ->  new GameInput(1).validate(1),"Input parameter should not be negative!");
    }

}
