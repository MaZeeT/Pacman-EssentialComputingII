package Maze;

import Components.Position;
import Entities.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The purpose of this class is to make some general methods which all mazes can utilize.
 * All the methods in this class is based on the 3 fields.
 * walls, a list of all {@link Wall}s in the maze.
 * Player, the {@link Player} in the maze.
 * WayPoint, the {@link WayPoint} in the maze, typical used as exit.
 *
 * @author MaZeeT
 */
public abstract class Maze implements IMaze {

    List<GameObject> walls;
    Player player;
    WayPoint wayPoint;
    List<MovableEntity> ghosts;

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    public List<GameObject> getMaze() {
        List<GameObject> gameObjects = new ArrayList<>();
        for (GameObject wall : walls) { //TODO rewrite class to include walls.contain(wall) method.
            if (!gameObjects.contains(wall)) gameObjects.add(wall);
        }
        gameObjects.add(player);
        gameObjects.add(wayPoint);
        return gameObjects;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    public List<Position> getMazePositions() {
        List<Position> list = new ArrayList<>();
        for (GameObject gameObject : getMaze()) {
            list.add(gameObject.getPosition());
        }
        return list;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    public WayPoint getWayPoint() {
        return wayPoint;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    public List<GameObject> getWalls() {
        return walls;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    public List<MovableEntity> getGhosts() {
        return ghosts;
    }

}
