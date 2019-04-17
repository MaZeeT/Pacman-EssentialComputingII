package Logic;

import DataStructures.IDataStructure;
import Entities.GameObject;
import Entities.MovableEntity;
import Logic.Crawler.Crawler;
import Logic.Crawler.MoveClockWise;
import Maze.IMaze;

import java.util.*;
//todo check javadoc for changes since the implementation of IMove interface
/**
 * The purpose of this class is, to combine most of the components needed for the logic to work.
 * All the different types of {@link GameObject}s are access here.
 * The {@link Crawler} is combined with the {@link IMaze} and {@link IDataStructure}.
 * It is also possible to disable the {@link Crawler} to control with {@link UserControl.UserControl} instead.
 *
 * @author MaZeeT
 */
public class GameManager {

    private List<GameObject> walls;
    private List<GameObject> wayPoints = new ArrayList<>();
    private List<GameObject> snake = new ArrayList<>();
    private List<GameObject> ghosts;

    private char direction; //todo direction can be removed if we can bridge the input with the moveClockWise class.
    private MoveClockWise movement;
    private Crawler crawler;
    private Crawler ghostA;
    private Crawler ghostB;

    private boolean crawl = false;

    /**
     * Constructor of this class. It takes a {@link IMaze} and a {@link IDataStructure} as input.
     *
     * @param maze          The {@link IMaze} is used to access all the different {@link GameObject}s in the {@link IMaze}.
     * @param dataStructure The {@link IDataStructure} is used to store each possible movement, and returns the next move.
     */
    public GameManager(IMaze maze, IDataStructure dataStructure) {
        walls = maze.getWalls();
        ghosts = maze.getGhosts();

        MovableEntity player = maze.getPlayer();
        snake.add(player);
        wayPoints.add(maze.getWayPoint());


        movement = new MoveClockWise(maze);
        crawler = new Crawler(maze, dataStructure);
        ghostA = new Crawler(maze, dataStructure);
        ghostB = new Crawler(maze, dataStructure);
    }

    /**
     * The move method, which is called each move tick.
     */
    public void update() {
        movement.setDirection(direction);
        movement.move();
        direction = movement.getDirection(); //todo make a common interface for crawler and user controls of movableGameObjects
        if (crawl){
            crawler.move();
            ghostA.move();
            ghostB.move();
        }

    }

    /**
     * Set the direction.
     *
     * @param direction The direction as a char.
     */
    public void setDirection(char direction) {
        this.direction = direction;
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
        gameObjects.addAll(snake);
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
