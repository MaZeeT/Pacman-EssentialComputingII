package SnakeLogic;

import SnakeDataStructures.DepthFirst;
import SnakeDataStructures.IDataStructure;
import SnakeEntities.GameObject;
import SnakeMaze.ForkRoad;
import SnakeMaze.IMaze;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameManagerTest {

    private GameManager gameManager;

    @Before
    public void setUp() {
        IMaze maze = new ForkRoad();
        IDataStructure dataStructure = new DepthFirst();
        gameManager = new GameManager(maze, dataStructure);
    }

    @Test
    public void update() {
        List<GameObject> old = new ArrayList<>();
        old.addAll(gameManager.getGameObjects());

        for (int i = 0; i < 100; i++) {
            gameManager.update();
        }
        List<GameObject> expected = old;
        List<GameObject> actual = gameManager.getGameObjects();
        assertEquals(expected, actual);
    }

    @Test
    public void setGetDirection() {
        char expected = 'a';
        gameManager.setDirection(expected);
        char actual = gameManager.getDirection();
        assertEquals(expected, actual);
    }


    @Test
    public void getGameObjects() {
        List<GameObject> actual = gameManager.getGameObjects();
        assertNotNull(actual);
    }
}