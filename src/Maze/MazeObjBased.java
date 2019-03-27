package Maze;

import Components.Position;
import Entities.*;

/**
 * The purpose of this class is to provide som helper methods to its sub classes.
 * The helper methods are made for mazes based on instantiation of {@link GameObject}s to build the maze.
 *
 * @author MaZeeT
 */
abstract class MazeObjBased extends Maze {

    GameObject[][] maze;

    /**
     * This will add a new instantiation of a {@link WayPoint} to the 2D array in this class,
     * link it to the super classes "wayPoint" variable.
     *
     * @param x The x position in the maze.
     * @param y The y position in the maze.
     */
    void addWayPoint(int x, int y) {
        if (maze[x][y] == null) {
            wayPoint = new WayPoint(new Position(x, y));
            maze[x][y] = wayPoint;
        }
    }

    /**
     * This will add a new instantiation of a {@link Player} to the 2D array in this class,
     * link it to the super classes "player" variable.
     *
     * @param x The x position in the maze.
     * @param y The y position in the maze.
     */
    void addPlayer(int x, int y) {
        if (maze[x][y] == null) {
            player = new Player(new Position(x, y));
            maze[x][y] = player;
        }
    }

    /**
     * This will add a new instantiation of a {@link Wall} to a list of walls and the 2D array in this class.
     *
     * @param x The x position in the maze.
     * @param y The y position in the maze.
     */
    void addWall(int x, int y) {
        if (maze[x][y] == null) {
            Wall w = new Wall(x, y);
            maze[x][y] = w;
            walls.add(w);
        }
    }

    /**
     * A default method to instantiate a border of {@link Wall}s around the maze.
     */
    void borders(int sizeX, int sizeY) {
        for (int i = 0; i < sizeX; i++) {
            addWall(i, 0);
            addWall(i, sizeY - 1);
        }

        for (int i = 0; i < sizeY; i++) {
            addWall(0, i);
            addWall(sizeX - 1, i);
        }
    }

}
