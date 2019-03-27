package Maze;

import Components.Position;
import Entities.GameObject;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ManyRoadsTest{

    private Position playerPosition;
    private Position wayPointPosition;
    private List<GameObject> walls;

    @Before
    public void setUp(){
        IMaze maze = new ManyRoads();
        this.playerPosition = maze.getPlayer().getPosition();
        this.wayPointPosition = maze.getWayPoint().getPosition();
        this.walls = maze.getWalls();
    }

    @Test
    public void checkWalls(){
        int expected = 57;
        int actual = walls.size();
        assertEquals(expected, actual);
    }

    @Test
    public void checkWayPoint(){
        Position position = new Position(3,9);
        int expected = 0;
        int actual = wayPointPosition.compareTo(position);
        assertEquals(expected, actual);
    }

    @Test
    public void checkPlayer(){
        Position position = new Position(1,1);
        int expected = 0;
        int actual = playerPosition.compareTo(position);
        assertEquals(expected, actual);
    }
}