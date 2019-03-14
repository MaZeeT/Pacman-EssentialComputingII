package SnakeLogic;

import SnakeEntities.GameObject;
import SnakeGUI.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameManagerTest {

    GameManager gameManager;

    @Before
    public void setUp() {
        //gameManager = new GameManager();
    }

    @Test
    public void update() {
    }

    @Test
    public void setDirection() {
    }

    @Test
    public void getGameObjects() {
        int actual;
        int expected;

        actual = gameManager.getGameObjects().size();
        expected = 5;
        assertNotNull(actual);
    }
}