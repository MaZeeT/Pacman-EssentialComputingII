package Maze;

import Components.Position;
import Entities.*;

import java.util.List;

/**
 * The purpose of this interface is to define the functions that is needed to interact with all the different mazes.
 *
 * @author MaZeeT
 */
public interface IMaze {

    /**
     * Get all the {@link GameObject}s in the maze.
     *
     * @return Return a list of all {@link GameObject}s in the maze.
     */
    List<GameObject> getMaze();

    /**
     * Get all the {@link GameObject}'s {@link Position} in the maze.
     *
     * @return Return a list of all the {@link Position}s in the maze.
     */
    List<Position> getMazePositions();

    /**
     * Get the {@link Player} in the maze as its superclass {@link MovableEntity}.
     *
     * @return Return the {@link Player} of the maze as its superclass {@link MovableEntity}.
     */
    MovableEntity getPlayer();

    /**
     * Get the {@link WayPoint} in the maze.
     *
     * @return Return the {@link WayPoint} of the maze.
     */
    WayPoint getWayPoint();

    /**
     * Get all the {@link GameObject} of the {@link Wall} type.
     *
     * @return Return a list of all the {@link Wall}s in the maze.
     */
    List<GameObject> getWalls();

    /**
     * Get all the {@link Ghost}s in the maze.
     *
     * @return Return a list of all the {@link Ghost}s in the maze.
     */
    List<GameObject> getGhosts();

    /**
     * Get all {@link MovableEntity} in the maze.
     * Both {@link Player} and {@link Ghost}s are included in the list.
     *
     * @return Returns a list of all {@link MovableEntity} in the maze.
     */
    List<MovableEntity> getMovables();

}
