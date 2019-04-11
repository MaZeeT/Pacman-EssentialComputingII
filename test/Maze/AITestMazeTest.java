package Maze;

import Components.Position;
import Entities.GameObject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AITestMazeTest {

    private Position playerPosition;
    private Position wayPointPosition;
    private List<GameObject> walls;

    @Before
    public void setUp(){
        IMaze maze = new AITestMaze();
        this.playerPosition = maze.getPlayer().getPosition();
        this.wayPointPosition = maze.getWayPoint().getPosition();
        this.walls = maze.getWalls();
    }

    @Test
    public void checkWalls(){
        int expected = 472;
        int actual = walls.size();
        assertEquals(expected, actual);
    }

    @Test
    public void checkWayPoint(){
        Position position = new Position(27,3);
        int expected = 0;
        int actual = wayPointPosition.compareTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPlayer(){
        Position position = new Position(3,3);
        int expected = 0;
        int actual = playerPosition.compareTo(position);
        assertEquals(expected, actual);
    }

}
