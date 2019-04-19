package CoreLogic;

import Entities.GameObject;
import Maze.ForkRoad;
import Maze.IMaze;
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
        gameManager = new GameManager(maze);
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
    public void getGameObjects() {
        List<GameObject> actual = gameManager.getGameObjects();
        assertNotNull(actual);
    }

}
