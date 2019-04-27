package Entities;

import Components.Position;
import DataStructures.Greedy;
import Maze.*;
import Movement.DataStructureCrawlers.Crawler;
import Movement.IMover;
import Movement.UserControlled.MoveClockWise;
import javafx.scene.paint.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovableEntityEqualsTest {

    @Test
    public void isEqual() {
        Position pos = new Position(9, 6);
        Color c = Color.GREEN;
        MovableEntity me1 = new Ghost(pos, c);
        MovableEntity me2 = new Ghost(pos, c);

        boolean expected = true;
        boolean actual = me1.equals(me2);
        assertEquals(expected, actual);
    }

    @Test
    public void isNotEqualPosition() {
        Position pos1 = new Position(9, 6);
        Position pos2 = new Position(7, 3);
        Color c = Color.GREEN;
        MovableEntity me1 = new Ghost(pos1, c);
        MovableEntity me2 = new Ghost(pos2, c);

        boolean expected = false;
        boolean actual = me1.equals(me2);
        assertEquals(expected, actual);
    }

    @Test
    public void isNotEqualOneMover() {
        IMaze maze = new AITestMaze();
        IMover mover = new MoveClockWise(maze, maze.getPlayer());
        Position pos = new Position(9, 6);
        Color c = Color.GREEN;
        MovableEntity me1 = new Ghost(pos, c);
        MovableEntity me2 = new Ghost(pos, c);
        me1.setMover(mover);

        boolean expected = false;
        boolean actual = me1.equals(me2);
        assertEquals(expected, actual);
    }

    @Test
    public void isNotEqualTwoMovers() {
        IMaze maze = new AITestMaze();
        IMover mover1 = new MoveClockWise(maze, maze.getPlayer());
        IMover mover2 = new Crawler(maze, maze.getPlayer(), new Greedy(maze.getPlayer().getPosition()));
        Position pos = new Position(9, 6);
        Color c = Color.GREEN;
        MovableEntity me1 = new Ghost(pos, c);
        MovableEntity me2 = new Ghost(pos, c);
        me1.setMover(mover1);
        me2.setMover(mover2);

        boolean expected = false;
        boolean actual = me1.equals(me2);
        assertEquals(expected, actual);
    }

    @Test
    public void isNotEqualColor() {
        Position pos = new Position(9, 6);
        Color c1 = Color.GREEN;
        Color c2 = Color.RED;
        MovableEntity me1 = new Ghost(pos, c1);
        MovableEntity me2 = new Ghost(pos, c2);

        boolean expected = false;
        boolean actual = me1.equals(me2);
        assertEquals(expected, actual);
    }

    @Test
    public void isEqualWrongTypeString() {
        MovableEntity me = new Ghost(new Position(3, 1), Color.BLUE);
        String string = "test";

        boolean expected = false;
        boolean actual = me.equals(string);
        assertEquals(expected, actual);
    }

    @Test
    public void isEqualWrongGameObjectSubType() {
        Position pos = new Position(4, 7);
        MovableEntity me1 = new Ghost(pos, Color.GREY);
        MovableEntity me2 = new Player(pos);

        boolean expected = false;
        boolean actual = me1.equals(me2);
        assertEquals(expected, actual);
    }

    @Test
    public void notEqualHashcodePosition() {
        Position pos1 = new Position(9, 6);
        Position pos2 = new Position(7, 3);
        Color c = Color.GREEN;
        MovableEntity me1 = new Ghost(pos1, c);
        MovableEntity me2 = new Ghost(pos2, c);

        boolean expected = false;
        boolean actual = me1.hashCode() == me2.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    public void notEqualHashcodeColor() {
        Position pos = new Position(9, 6);
        Color c1 = Color.GREEN;
        Color c2 = Color.BLUE;
        MovableEntity me1 = new Ghost(pos, c1);
        MovableEntity me2 = new Ghost(pos, c2);

        boolean expected = false;
        boolean actual = me1.hashCode() == me2.hashCode();
        assertEquals(expected, actual);
    }

    @Test
    public void equalHashcode() {
        Position pos = new Position(9, 6);
        Color c = Color.RED;
        MovableEntity me1 = new Ghost(pos, c);
        MovableEntity me2 = new Ghost(pos, c);

        boolean expected = true;
        boolean actual = me1.hashCode() == me2.hashCode();
        assertEquals(expected, actual);
    }

}
