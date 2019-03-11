package SnakeMaze;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MazeTest {
    private IMaze maze;
    private int defX;
    private int defY;

    @Before
    public void setUp() {
        defX = 3;
        defY = 3;
        maze = new Maze(defX, defY);
    }

    @Test
    public void amountOfWalls() {
        int expected = defX * 2 + defY * 2 - 4;
        int actual = maze.getMaze().size();
        assertEquals(expected, actual);
    }

    @Test
    public void amountOfWallsHigh() {
        int x = 15;
        int y = 20;
        int expected = x * 2 + y * 2 - 4;
        int actual = new Maze(x, y).getMaze().size();
        assertEquals(expected, actual);
    }

    @Test
    public void amountOfWallsLow() {
        int x = 2;
        int y = 2;
        int expected = x * 2 + y * 2 - 4;
        int actual = new Maze(x, y).getMaze().size();
        assertEquals(expected, actual);
    }

    @Test
    public void makeMaze() {
        int x = 15;
        int y = 15;
        IMaze m = new Maze(x, y);

        int expected = x * 2 + y * 2 - 4 + 5 + 4;
        int actual = m.generateMaze();
        assertEquals(expected, actual);
    }

    @Test
    public void listSizeComparedToGenerateReturn() {
        int x = 15;
        int y = 15;
        IMaze m = new Maze(x, y);
        m.generateMaze();

        int expected = m.getMaze().size();
        int actual = m.generateMaze();
        assertEquals(expected, actual);
    }

}