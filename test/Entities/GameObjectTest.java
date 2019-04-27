package Entities;

import Components.Position;
import javafx.scene.paint.Color;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameObjectTest {

    private GameObject wayPoint;
    private GameObject player;
    private GameObject wall;

    private Position wayPointPos;
    private Position playerPos;
    private Position wallPos;

    @Before
    public void setUp() {
        wayPointPos = new Position(2, 5);
        playerPos = new Position(1, 3);
        wallPos = new Position(3, 4);

        wayPoint = new WayPoint(wayPointPos);
        player = new Player(playerPos);
        wall = new Wall(wallPos);
    }

    @Test
    public void getWayPointPosition() {
        Position wayPointExpected = wayPointPos;
        Position wayPointActual = wayPoint.getPosition();
        assertEquals(wayPointExpected, wayPointActual);
    }

    @Test
    public void getPlayerPosition() {
        Position playerExpected = playerPos;
        Position playerActual = player.getPosition();
        assertEquals(playerExpected, playerActual);
    }

    @Test
    public void getWallPosition() {
        Position wallExpected = wallPos;
        Position wallActual = wall.getPosition();
        assertEquals(wallExpected, wallActual);
    }

    @Test
    public void setWayPointPosition() {
        Position wayPointExpected = new Position(1, 3);
        wayPoint.setPosition(wayPointExpected);
        Position wayPointActual = wayPoint.getPosition();
        assertEquals(wayPointExpected, wayPointActual);
    }

    @Test
    public void setPlayerPosition() {
        Position playerExpected = new Position(2, 5);
        player.setPosition(playerExpected);
        Position playerActual = player.getPosition();
        assertEquals(playerExpected, playerActual);
    }

    @Test
    public void setWallPosition() {
        Position wallExpected = new Position(3, 4);
        wall.setPosition(wallExpected);
        Position wallActual = wall.getPosition();
        assertEquals(wallExpected, wallActual);
    }

    @Test
    public void getColorWayPoint() {

        Color wayPointExpected = Color.GREEN;
        Color wayPointActual = wayPoint.getColor();
        assertEquals(wayPointExpected, wayPointActual);
    }

    @Test
    public void getColorPlayer() {
        Color playerExpected = Color.BLACK;
        Color playerActual = player.getColor();
        assertEquals(playerExpected, playerActual);
    }

    @Test
    public void getColorWall() {
        Color wallExpected = Color.GREY;
        Color wallActual = wall.getColor();
        assertEquals(wallExpected, wallActual);
    }

    @Test
    public void setColorWayPoint() {
        Color wayPointExpected = Color.BLUE;
        wayPoint.setColor(wayPointExpected);
        Color wayPointActual = wayPoint.getColor();
        assertEquals(wayPointExpected, wayPointActual);
    }

    @Test
    public void setColorPlayer() {
        Color playerExpected = Color.GREEN;
        player.setColor(playerExpected);
        Color playerActual = player.getColor();
        assertEquals(playerExpected, playerActual);

    }

    @Test
    public void setColorWalls() {
        Color wallExpected = Color.RED;
        wall.setColor(wallExpected);
        Color wallActual = wall.getColor();
        assertEquals(wallExpected, wallActual);
    }

    @Test
    public void isEqual() {
        int x = 9;
        int y = 6;
        GameObject go1 = new Wall(x, y);
        GameObject go2 = new Wall(x, y);

        boolean expected = true;
        boolean actual = go1.equals(go2);
        assertEquals(expected, actual);
    }

    @Test
    public void isNotEqual() {
        int x = 9;
        int y = 9;
        GameObject go1 = new Wall(x, y);
        GameObject go2 = new Wall(x + 1, y + 1);

        boolean expected = false;
        boolean actual = go1.equals(go2);
        assertEquals(expected, actual);
    }

    @Test
    public void isEqualWrongTypeString() {
        int x = 3;
        int y = 1;
        GameObject go1 = new Wall(x, y);
        String string = "test";

        boolean expected = false;
        boolean actual = go1.equals(string);
        assertEquals(expected, actual);
    }

    @Test
    public void isEqualWrongGameObjectSubType() {
        int x = 4;
        int y = 7;
        GameObject go1 = new Wall(x, y);
        GameObject go2 = new WayPoint(new Position(x, y));

        boolean expected = false;
        boolean actual = go1.equals(go2);
        assertEquals(expected, actual);
    }

    @Test
    public void notEqualHashcode() {

        GameObject go1 = new Wall(3, 7);
        GameObject go2 = new Wall(4, 6);

        boolean expected = false;
        boolean actual = go1.hashCode() == go2.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    public void equalHashcode() {
        int x = 5;
        int y = 11;
        GameObject go1 = new Wall(x, y);
        GameObject go2 = new Wall(x, y);

        boolean expected = true;
        boolean actual = go1.hashCode() == go2.hashCode();
        assertEquals(expected, actual);
    }

}
