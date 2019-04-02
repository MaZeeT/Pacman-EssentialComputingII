package Maze;

import Entities.*;

import java.util.ArrayList;

/**
 * The purpose of this class is to add a new maze with 2 rooms with a large amount of free space.
 * 1 room with the {@link Entities.Player} and the 2 room with the {@link Entities.WayPoint}.
 *
 * @author MaZeeT
 */
public class TwoHalls extends MazeObjBased {

    private int sizeX;
    private int sizeY;

    /**
     * The size of the maze can be resized by the 2 parameters width and height.
     * A {@link Player} and a {@link WayPoint} will be added to the maze.
     * Afterwards borders, bumped in corners and a diagonal wall are added.
     *
     * @param width  The width of the maze.
     * @param height The height of the maze.
     */
    public TwoHalls(int width, int height) {
        this.sizeX = width;
        this.sizeY = height;
        maze = new GameObject[sizeX][sizeY];
        borders(sizeX, sizeY);
        corners();

        addPlayer(5, 7);
        addPlayer(6, 7);
        addWayPoint(7, 5);
        diagonalWall(3, 8);
    }

    /**
     * Add a bumped in the corners to the maze.
     */
    private void corners() {
        addWall(1, 1);
        addWall(1, sizeY - 2);
        addWall(sizeX - 2, 1);
        addWall(sizeX - 2, sizeY - 2);
    }

    /**
     * Add a diagonal line of {@link Wall}s to the maze.
     *
     * @param start the start of the line at index start,start.
     * @param end   the end of the line at index end,end.
     */
    private void diagonalWall(int start, int end) {
        for (int i = start; i < end; i++) {
            addWall(i, i);
        }
    }

}
