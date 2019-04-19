package Logic;

import DataStructures.*;
import Entities.*;
import Movement.*;//todo remove when rewritten the class javaDoc
import Maze.IMaze;
import UserControl.UserInput;

import java.util.*;

//todo check javadoc for changes since the implementation of IMover interface
/**
 * The purpose of this class is, to combine most of the components needed for the logic to work.
 * All the different types of {@link GameObject}s are access here.
 * The {@link Crawler} is combined with the {@link IMaze} and {@link IDataStructure}.
 * It is also possible to disable the {@link Crawler} to control with {@link UserInput} instead.
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
    public GameManager(IMaze maze) {
        walls = maze.getWalls();
        ghosts = maze.getGhosts();

        MovableEntity player = maze.getPlayer();
        this.player.add(player);
        wayPoints.add(maze.getWayPoint());
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
    public List<GameObject> getGameObjects() {
        return combineGameObjects();
    }

}
