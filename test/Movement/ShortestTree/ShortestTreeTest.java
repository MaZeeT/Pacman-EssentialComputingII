package Movement.ShortestTree;

import Entities.GameObject;
import Entities.MovableEntity;
import Maze.*;
import Movement.IMover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestTreeTest {

    private IMover shortTreeFalse;
    private IMover shortTreeTrue;
    private MovableEntity player;
    private GameObject wayPoint;
    private Explorer explorer;

    @Before
    public void setUp() {
        IMaze maze = new AITestMaze();
        this.player = maze.getPlayer();
        this.wayPoint = maze.getWayPoint();
        this.explorer = new Explorer();
        this.shortTreeFalse = new ShortestTree(maze, player, wayPoint, false);
        this.shortTreeTrue = new ShortestTree(maze, player, wayPoint, true);
    }
//todo write tests

    @Test
    public void LengthToTargetAITestMazeTrackingTargetOff() {
        int numOfMoves = 84;
        for (int i = 0; i <= numOfMoves; i++) {
            shortTreeFalse.move();
        }

        //System.out.print(player.getPosition().getX() + ","); System.out.println(player.getPosition().getY());
        //System.out.print(wayPoint.getPosition().getX() + ","); System.out.println(wayPoint.getPosition().getY());

        boolean actual = player.getPosition().equals(wayPoint.getPosition());
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void LengthToTargetAITestMazeTrackingTargetOn() {
        int numOfMoves = 84;
        for (int i = 0; i <= numOfMoves; i++) {
            shortTreeTrue.move();
        }

        //System.out.print(player.getPosition().getX() + ","); System.out.println(player.getPosition().getY());
        //System.out.print(wayPoint.getPosition().getX() + ","); System.out.println(wayPoint.getPosition().getY());

        boolean actual = player.getPosition().equals(wayPoint.getPosition());
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void runExplorerUpdateMethod() {

        boolean actual = explorer.update();
        boolean expected = false;
        assertEquals(expected, actual);
    }

}
