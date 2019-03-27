package Maze;

import Entities.*;

import java.util.ArrayList;

//TODO write javaDoc

/**
 * The purpose of this class is to add a new maze with 2 rooms with a large amount of free space.
 * 1 room with the {@link Entities.Player} and the 2 room with the {@link Entities.WayPoint}.
 *
 * @author MaZeeT
 */
public class MazeObj extends MazeObjBased {

    private int sizeX;
    private int sizeY;


    public MazeObj(int width, int height) {
        this.sizeX = width;
        this.sizeY = height;
        this.walls = new ArrayList<>();
        maze = new GameObject[sizeX][sizeY];

        addPlayer(5, 7);
        addWayPoint(7, 5);

        borders();
        corners();
        diagonalWall(3, 8);
    }

    private void borders() {
        for (int i = 0; i < sizeX; i++) {
            addWall(i, 0);
            addWall(i, sizeY - 1);
        }

        for (int i = 0; i < sizeY; i++) {
            addWall(0, i);
            addWall(sizeX - 1, i);
        }
    }

    /**
     * Add a bumped in corner to the maze.
     */
    private void corners() {
        addWall(1, 1);
        addWall(1, sizeY - 2);
        addWall(sizeX - 2, 1);
        addWall(sizeX - 2, sizeY - 2);
    }

    /**
     * Add a diagonal line of {@link Wall}s to the maze.
     * @param start the start of the line at index start,start.
     * @param end the end of the line at index end,end.
     */
    private void diagonalWall(int start, int end) {
        for (int i = start; i < end; i++) {
            addWall(i, i);
        }
    }

}
