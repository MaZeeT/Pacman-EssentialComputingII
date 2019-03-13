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
        List<GameObject> actual;
        List<GameObject> expected;

        actual = gameManager.getGameObjects();
        //expected = new ArrayList<GameObject>();
        assertNotNull(actual);
    }
}