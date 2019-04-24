package WorkInProgress.ShortestTree;

import Components.Position;
import Maze.*;
import Movement.IMover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestTreeTest {

    private IMover shortTree;

    @Before
    public void setUp() {
        IMaze maze = new ForkRoad();
        this.shortTree = new ShortestTree(maze, maze.getPlayer(), maze.getWayPoint(), false);
    }
//todo write tests
}