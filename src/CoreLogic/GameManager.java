package CoreLogic;

import Entities.*;
import Maze.IMaze;

import java.util.*;

/**
 * The purpose of this class is, to combine most of the program specific logic.
 * All the different types of {@link GameObject}s are updated and past around from this class.
 *
 * @author MaZeeT
 */
public class GameManager {

    private List<GameObject> walls;
    private List<GameObject> wayPoints = new ArrayList<>();
    private List<GameObject> player = new ArrayList<>();
    private List<GameObject> ghosts;

    /**
     * Constructor of this class. It takes a {@link IMaze} as input.
     *
     * @param maze The {@link IMaze} is used to access all the different {@link GameObject}s in the {@link IMaze}.
     */
    GameManager(IMaze maze) {
        this.walls = maze.getWalls();
        this.ghosts = maze.getGhosts();
        this.player.add(maze.getPlayer());
        this.wayPoints.add(maze.getWayPoint());
    }

    /**
     * The update method, which is called each update tick.
     * Checks all {@link GameObject}s for the subtypes of {@link MovableEntity} and call update each.
     */
    public void update() {
        for (GameObject gameObject : combineGameObjects()) {
            if (gameObject instanceof MovableEntity) {
                ((MovableEntity) gameObject).update();
            }
        }
    }

    /**
     * Combines the different {@link GameObject}s in a list and returns this list.
     *
     * @return Returns a list of all the {@link GameObject}s combined.
     */
    private List<GameObject> combineGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(wayPoints);
        gameObjects.addAll(walls);
        gameObjects.addAll(player);
        if (ghosts != null) gameObjects.addAll(ghosts);

        return gameObjects;
    }

    /**
     * Get a list of {@link GameObject}s.
     *
     * @return Returns a list of {@link GameObject}s.
     */
    List<GameObject> getGameObjects() {
        return combineGameObjects();
    }

}
