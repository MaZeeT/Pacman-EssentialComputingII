package Movement;

import Components.Position;
import Entities.MovableEntity;
import Maze.IMaze;
import Maze.TwoHalls;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveClockWiseTest {

    private IMoverControlled movement;
    private MovableEntity player;

    @Before
    public void setUp() {
        IMaze maze = new TwoHalls(10, 10);
        player = maze.getPlayer();
        movement = new MoveClockWise(maze, maze.getPlayer());
    }

    @Test
    public void direction() {
        char expected = 'a';
        movement.setDirection(expected);
        movement.move();
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveUpTurnRight() {
        player.setPosition(new Position(1, 3));
        char expected = 'd';
        movement.setDirection('w');
        for (int i = 0; i <= 3; i++) movement.move();
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveRightTurnDown() {
        player.setPosition(new Position(6, 1));
        char expected = 's';
        movement.setDirection('d');
        for (int i = 0; i <= 3; i++) movement.move();
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveDownTurnLeft() {
        player.setPosition(new Position(5, 7));
        char expected = 'a';
        movement.setDirection('s');
        for (int i = 0; i <= 3; i++) movement.move();
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void moveLeftTurnUp() {
        player.setPosition(new Position(3, 8));
        char expected = 'w';
        movement.setDirection('a');
        for (int i = 0; i <= 3; i++) movement.move();
        char actual = movement.getDirection();
        assertEquals(expected, actual);
    }
}