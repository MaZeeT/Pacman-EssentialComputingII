package Maze;

import Components.Position;
import Entities.Player;
import Entities.WayPoint;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MazeObjTest {
    private IMaze maze;
    private int defX;
    private int defY;

    @Before
    public void setUp() {
        defX = 8;
        defY = 8;
        maze = new MazeObjTestable(defX, defY);
    }

    @Test
    public void amountOfWalls() {
        int expected =
                defX * 2 + defY * 2 //walls
                        - 4 // corner overlays
                ;
        int actual = maze.getWalls().size();
        assertEquals(expected, actual);
    }

    @Test
    public void amountOfWallsHigh() {
        int x = 15;
        int y = 20;
        int expected =
                x * 2 + y * 2 //walls
                        - 4 // corner overlays

                ;
        Maze mazeObj = new MazeObjTestable(x, y);
        int actual = mazeObj.getWalls().size();
        assertEquals(expected, actual);
    }

    @Test
    public void amountOfWallsLow() {
        int x = 5;
        int y = 5;
        int expected =
                x * 2 + y * 2 //walls
                        - 4 // corner overlays
                ;

        int actual = new MazeObjTestable(x, y).getWalls().size();
        assertEquals(expected, actual);
    }

    @Test
    public void makeMaze() {
        int x = 15;
        int y = 15;
        IMaze m = new MazeObjTestable(x, y);

        int expected =
                x * 2 + y * 2 //walls
                        - 4 // corner overlays
                        + 2 // player and wayPoint
                ;
        int actual = m.getMaze().size();
        assertEquals(expected, actual);
    }

    @Test
    public void listSizeComparedToGenerateReturn() {
        int x = 15;
        int y = 15;
        IMaze m = new MazeObjTestable(x, y);

        int expected = m.getWalls().size();
        int actual = m.getMaze().size() - 2;
        assertEquals(expected, actual);
    }

    @Test
    public void getPlayer() {
        int x = 15;
        int y = 15;
        IMaze m = new MazeObjTestable(x, y);
        Player testPlayer = new Player(new Position(2, 2));

        int expected = 0;
        int actual = m.getPlayer().compareTo(testPlayer);
        assertEquals(expected, actual);
    }

    @Test
    public void getWayPoint() {
        int x = 15;
        int y = 15;
        IMaze m = new MazeObjTestable(x, y);
        WayPoint testWayPoint = new WayPoint(new Position(2, 3));

        int expected = 0;
        int actual = m.getWayPoint().compareTo(testWayPoint);
        assertEquals(expected, actual);
    }

    @Test
    public void listSizeGameObjectComparedPositions() {
        int x = 15;
        int y = 15;
        IMaze m = new MazeObjTestable(x, y);

        int expected = m.getMaze().size();
        int actual = m.getMazePositions().size();
        assertEquals(expected, actual);
    }

}
