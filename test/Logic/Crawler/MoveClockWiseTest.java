package Logic.Crawler;

import Components.Position;
import Entities.Player;
import Maze.IMaze;
import Maze.MazeObj;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveClockWiseTest {

    private MoveClockWise movement;
    private Player player;

    @Before
    public void setUp() {
        IMaze maze = new MazeObj(10, 10);
        player = maze.getPlayer();
        movement = new MoveClockWise(maze);
    }

    @Test
    public void direction() {
        char expected = 'a';
        movement.move(expected);
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveUpTurnRight() {
        player.setPosition(new Position(1, 3));
        char expected = 'd';
        for (int i = 0; i <= 3; i++) movement.move('w');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveRightTurnDown() {
        player.setPosition(new Position(6, 1));
        char expected = 's';
        for (int i = 0; i <= 3; i++) movement.move('d');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveDownTurnLeft() {
        player.setPosition(new Position(5, 7));
        char expected = 'a';
        for (int i = 0; i <= 3; i++) movement.move('s');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeftTurnUp() {
        player.setPosition(new Position(3, 8));
        char expected = 'w';
        for (int i = 0; i <= 3; i++) movement.move('a');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }
}