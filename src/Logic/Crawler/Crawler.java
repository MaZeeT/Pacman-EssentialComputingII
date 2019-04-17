package Logic.Crawler;

import Components.Position;
import DataStructures.IDataStructure;
import Entities.GameObject;
import Entities.MovableEntity;
import Entities.Player;
import Entities.Wall;
import Maze.IMaze;
import Movement.IMove;
import javafx.scene.paint.Color;

import java.util.List;
//todo check javadoc for changes since the implementation of IMove interface
/**
 * The purpose of this class is to be enable the {@link Player} to crawl around in a given {@link Maze.Maze}.
 * This is done by storing each possible steps in a data structure and make a decision about which step to take next.
 * This {@link Crawler} works with dataStructures that implements the {@link IDataStructure} interface.
 * The {@link DataStructures.DepthFirst} dataStructure will give a depth first approach.
 * The {@link DataStructures.BreadthFirst} dataStructure will give a Breadth first approach.
 * The {@link DataStructures.Greedy} dataStructure will take the best possible single step each move.
 *
 * @author MaZeeT
 */
public class Crawler implements IMove {

    private MovableEntity movableEntity;
    private List<GameObject> gameObjects;
    private List<Position> gameObjectPositions;
    private IDataStructure dataStructure;

    /**
     * The constructor of the {@link Crawler} class.
     * This take a {@link Maze.Maze} and a dataStructure as an input,
     * and links some of the objects inside the {@link Maze.Maze} to some of the private variables of this class.
     *
     * @param maze          The {@link Maze.Maze} where the {@link Crawler} will move in.
     * @param dataStructure The dataStructure that will hold the {@link Position}s the {@link Crawler} will move to.
     */
    public Crawler(IMaze maze, IDataStructure dataStructure) {
        this.movableEntity = maze.getPlayer();
        this.gameObjects = maze.getMaze();
        this.gameObjectPositions = maze.getMazePositions();
        this.dataStructure = dataStructure;
    }

    /**
     * This function is called on each move "tick".
     * First the {@link Position} of the {@link Player} is added as a visited wall,
     * and nearby positions of the {@link Player} is checked and added to the dataStructure.
     * If the dataStructure is not empty, the {@link Player}'s position will be checked to the next in the dataStructure.
     */
    @Override
    public void move() {
        gameObjects.add(visited(movableEntity.getPosition()));
        checkNearby(movableEntity);
        if (dataStructure.checkNext() != null) {
            movableEntity.setPosition(dataStructure.getNext());
        }
    }

    /**
     * Instantiate a new {@link Wall} object, set the color to YELLOW and return the new {@link Wall} object.
     *
     * @param position The {@link Position} of the new instantiated {@link Wall}.
     * @return Return a new YELLOW {@link Wall} object
     */
    private Wall visited(Position position) {
        Wall wall = new Wall(position);
        wall.setColor(Color.YELLOW);
        return wall;
    }

    /**
     * Check all the {@link Position} around the movableEntity, and call the "addToDataStructure" on each {@link Position}.
     *
     * @param entity The crawling {@link MovableEntity}.
     */
    private void checkNearby(MovableEntity entity) {
        addToDataStructure(entity.checkUp());
        addToDataStructure(entity.checkLeft());
        addToDataStructure(entity.checkDown());
        addToDataStructure(entity.checkRight());
    }

    /**
     * Checks if a given {@link Position} is in the list of gameObjectPositions, and adds the {@link Position} if not.
     *
     * @param position The {@link Position} that will be added to the gameObjectPosition list.
     */
    private void addToDataStructure(Position position) {
        if (!gameObjectPositions.contains(position))
            dataStructure.add(position);
    }

    @Override
    public char getDirection() {
        return 0;
    }

    @Override
    public void setDirection(char direction) {

    }
}
