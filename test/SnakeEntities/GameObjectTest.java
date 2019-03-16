package SnakeEntities;

import SnakeComponents.Position;
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
    public void getColor() {

        //test wayPoint
        Color wayPointExpected = Color.YELLOW;
        Color wayPointActual = wayPoint.getColor();
        assertEquals(wayPointExpected, wayPointActual);

        //test player
        Color playerExpected = Color.BLACK;
        Color playerActual = player.getColor();
        assertEquals(playerExpected, playerActual);

        //test wall
        Color wallExpected = Color.GREY;
        Color wallActual = wall.getColor();
        assertEquals(wallExpected, wallActual);
    }


    @Test
    public void setColor() {

        //test wayPoint
        Color wayPointExpected = Color.BLUE;
        wayPoint.setColor(wayPointExpected);
        Color wayPointActual = wayPoint.getColor();
        assertEquals(wayPointExpected, wayPointActual);

        //test player
        Color playerExpected = Color.GREEN;
        player.setColor(playerExpected);
        Color playerActual = player.getColor();
        assertEquals(playerExpected, playerActual);

        //test walls
        Color wallExpected = Color.RED;
        wall.setColor(wallExpected);
        Color wallActual = wall.getColor();
        assertEquals(wallExpected, wallActual);
    }


}