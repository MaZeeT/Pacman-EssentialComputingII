package Logic;

import DataStructures.*;
import Entities.*;
import Movement.*;
import Maze.IMaze;

import java.util.*;
//todo check javadoc for changes since the implementation of IMover interface

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
    private IMoverControlled playerMovement;
    private IMover playerCrawler;

    private boolean playerControlled = true;
    private boolean ghostCanMove = true;

    /**
     * Constructor of this class. It takes a {@link IMaze} and a {@link IDataStructure} as input.
     *
     * @param maze          The {@link IMaze} is used to access all the different {@link GameObject}s in the {@link IMaze}.
     * @param dataStructure The {@link IDataStructure} is used to store each possible playerMovement, and returns the next move.
     */
    public GameManager(IMaze maze, IDataStructure dataStructure) {
        walls = maze.getWalls();
        ghosts = maze.getGhosts();

        MovableEntity player = maze.getPlayer();
        snake.add(player);
        wayPoints.add(maze.getWayPoint());

//todo fix movableEntity
        playerMovement = new MoveClockWise(maze);
        playerCrawler = new Crawler(maze, maze.getPlayer(), dataStructure);
        if (ghosts != null) {
            ((Ghost)ghosts.get(0)).setMover(
                    new Crawler(maze, (MovableEntity) ghosts.get(0), new Greedy(player.getPosition())));
            ((Ghost)ghosts.get(1)).setMover(
                    new Crawler(maze, (MovableEntity) ghosts.get(1), new BreadthFirst()));
            ((Ghost)ghosts.get(2)).setMover(
                    new Crawler(maze, (MovableEntity) ghosts.get(2), new DepthFirst()));
            //todo call update on all movableEntities, than we are have at least the player to update.
            //todo update dataStructure to launcher and instantiate crawler their instead of inside the game manager
        }
    }

    /**
     * The update method, which is called each update tick.
     */
    public void update() {
        //todo make a common interface for playerCrawler and user controls of movableGameObjects
        if (playerControlled) {
            playerMovement.setDirection(direction);
            playerMovement.move();
            direction = playerMovement.getDirection();
        } else {
            playerCrawler.move();
        }
        if(ghostCanMove && ghosts != null){
            for (GameObject ghost:ghosts )
            ((MovableEntity) ghost).update();
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
     * Get the direction as char.
     *
     * @return Returns the direction as a char.
     */
    char getDirection() {
        return this.direction;
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
