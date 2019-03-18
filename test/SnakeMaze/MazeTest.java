package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.Player;
import SnakeEntities.WayPoint;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {
    private IMaze maze;
    private int defX;
    private int defY;


    //TODO remove generateMaze from outside the class
    @Before
    public void setUp() {
        defX = 3;
        defY = 3;
        maze = new Maze(defX, defY);
    }

    @Test
    public void amountOfWalls() {
        int expected = defX * 2 + defY * 2 - 4;
        int actual = maze.getWalls().size();
        assertEquals(expected, actual);
    }

    @Test
    public void amountOfWallsHigh() {
        int x = 15;
        int y = 20;
        int expected = x * 2 + y * 2 - 4;
        int actual = new Maze(x, y).getWalls().size();
        assertEquals(expected, actual);
    }

    @Test
    public void amountOfWallsLow() {
        int x = 2;
        int y = 2;
        int expected = x * 2 + y * 2 - 4;
        int actual = new Maze(x, y).getWalls().size();
        assertEquals(expected, actual);
    }

    @Test
    public void makeMaze() {
        int x = 15;
        int y = 15;
        IMaze m = new Maze(x, y);
        m.generateMaze();

        int expected =
                x * 2 + y * 2 //walls
                        - 4 // corner overlays
                        + 5 // the middle walls
                        + 4 // bumped in corners
                        + 2 // player and wayPoint
                ;
        int actual = m.getMaze().size();
        assertEquals(expected, actual);
    }

    //TODO this test looks a little off, size from wall and maze...
    @Test
    public void listSizeComparedToGenerateReturn() {
        int x = 15;
        int y = 15;
        IMaze m = new Maze(x, y);
        m.generateMaze();

        int expected = m.getWalls().size();
        int actual = m.getMaze().size() -2;
        assertEquals(expected, actual);
    }

    @Test
    public void getPlayer() {
        int x = 15;
        int y = 15;
        IMaze m = new Maze(x, y);
        m.generateMaze();
        Player testPlayer = new Player(new Position(5, 7));

        int expected = 0;
        int actual = m.getPlayer().compareTo(testPlayer);
        assertEquals(expected, actual);
    }

    @Test
    public void getWayPoint() {
        int x = 15;
        int y = 15;
        IMaze m = new Maze(x, y);
        m.generateMaze();
        WayPoint testWayPoint = new WayPoint(new Position(7, 5));

        int expected = 0;
        int actual = m.getWayPoint().compareTo(testWayPoint);
        assertEquals(expected, actual);
    }

    @Test
    public void listSizeGameObjectComparedPositions() {
        int x = 15;
        int y = 15;
        IMaze m = new Maze(x, y);
        m.generateMaze();

        int expected = m.getMaze().size();
        int actual = m.getMazePositions().size();
        assertEquals(expected, actual);
    }

}
