package Maze;

import Components.Position;
import Entities.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to provide som helper methods to its sub classes.
 * The helper methods are made for mazes based on a 2D array to build the maze.
 *
 * @author MaZeeT
 */
abstract class MazeArrayBased extends Maze {

    int height;
    int width;

    /**
     * A empty constructor to enable mazes with a hardcoded size to be instantiated without giving unused width and height values.
     */
    MazeArrayBased() {

    }

    /**
     * A default constructor to define the size of a ArrayBased maze.
     *
     * @param width  The width of the maze.
     * @param height The height of the maze.
     */
    MazeArrayBased(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Scan the 2D array "arr" of the sub class for the int 3.
     * and instantiate a new {@link WayPoint} at the i, j position in the Array at the given indexes.
     *
     * @param arr The array that needs to have the {@link WayPoint} instantiated.
     * @return Returns the {@link WayPoint} if a 3 is in the array, else returns null.
     */
    WayPoint wayPoint(int[][] arr) {
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (arr[i][j] == 3) return new WayPoint(new Position(i, j));
            }
        }
        return null;
    }

    /**
     * Scan the 2D array "arr" of the sub class for the int 2.
     * and instantiate a new {@link Player} at the i, j position in the Array at the given indexes.
     *
     * @param arr The array that needs to have the {@link Player} instantiated.
     * @return Returns the {@link Player} if a 2 is in the array, else returns null.
     */
    Player player(int[][] arr) {
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (arr[i][j] == 2) return new Player(new Position(i, j));
            }
        }
        return null;
    }

    /**
     * Scan the 2D array "arr" of the sub class for the ints 1.
     * and instantiate a new {@link Wall} at the i, j position in the Array at the given indexes.
     *
     * @param arr The array that needs to have the {@link Wall}s instantiated.
     * @return Returns all the {@link Wall}s in the array as list of {@link GameObject}s.
     */
    List<GameObject> walls(int[][] arr) {
        List<GameObject> walls = new ArrayList<>();
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (arr[i][j] == 1) walls.add(new Wall(new Position(i, j)));
            }
        }
        return walls;
    }

}
