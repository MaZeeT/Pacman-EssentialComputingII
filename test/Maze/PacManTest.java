package Maze;

import Components.Position;
import Entities.GameObject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PacManTest {

    private Position playerPosition;
    private Position wayPointPosition;
    private List<GameObject> walls;
    private List<GameObject> ghosts;

    @Before
    public void setUp(){
        IMaze maze = new PacMan();
        this.playerPosition = maze.getPlayer().getPosition();
        this.wayPointPosition = maze.getWayPoint().getPosition();
        this.walls = maze.getWalls();
        this.ghosts = maze.getGhosts();
    }

    @Test
    public void checkWalls(){
        int expected = 672;
        int actual = walls.size();
        assertEquals(expected, actual);
    }

    @Test
    public void checkWayPoint(){
        Position position = new Position(15,14);
        int expected = 0;
        int actual = wayPointPosition.compareTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPlayer(){
        Position position = new Position(15,24);
        int expected = 0;
        int actual = playerPosition.compareTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void checkGhosts(){
        int expected = 3;
        int actual = ghosts.size();
        assertEquals(expected, actual);
        assertEquals(expected, actual);
    }

}
