package SnakeLogic.Crawler;

import SnakeComponents.Position;
import SnakeEntities.Player;
import SnakeMaze.IMaze;
import SnakeMaze.Maze;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveClockWiseTest {

    private ICrawler movement;

    @Before
    public void setUp() {
        Player player = new Player(new Position(5, 3));
        IMaze maze = new Maze(10, 10);
        movement = new MoveClockWise(player, maze.getMaze());
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
        char expected = 'd';
        for (int i = 0; i <= 3; i++) movement.move('w');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveRightTurnDown() {
        char expected = 's';
        for (int i = 0; i <= 5; i++) movement.move('d');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveDownTurnLeft() {
        char expected = 'a';
        for (int i = 0; i <= 5; i++) movement.move('s');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeftTurnUp() {
        char expected = 'w';
        for (int i = 0; i <= 4; i++) movement.move('a');
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }
}