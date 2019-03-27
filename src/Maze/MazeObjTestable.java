package Maze;

import Entities.*;

import java.util.ArrayList;

/**
 * The purpose of this class is to provide a default maze to instantiate the direct super test with.
 * By instantiating this class your are able to run tests against the superclass.
 *
 * @author MaZeeT
 */
class MazeObjTestable extends MazeObjBased {

    private int width;
    private int height;

    /**
     * This constructor takes a width and a height to define the size of the maze.
     * It will than add a {@link Player}, a {@link WayPoint} and a border of {@link Wall}s to the maze.
     *
     * @param width  The width of the maze.
     * @param height The height of the maze.
     */
    MazeObjTestable(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new GameObject[width][height];
        this.walls = new ArrayList<>();
        addPlayer(2, 2);
        addWayPoint(2, 3);
        borders();
    }

    /**
     * Instantiate a border of {@link Wall}s around the maze, when called.
     */
    private void borders() {
        for (int i = 0; i <= width - 1; i++) {
            addWall(i, 0);
            addWall(i, height - 1);
        }

        for (int i = 0; i <= height - 1; i++) {
            addWall(0, i);
            addWall(width - 1, i);
        }
    }

}
