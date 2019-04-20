package Movement;

import Components.Position;
import DataStructures.IDataStructure;
import Entities.*;
import Maze.IMaze;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * The purpose of this class is to be enable a {@link MovableEntity} to crawl around in a given {@link IMaze}.
 * This is done by storing each possible steps in a {@link IDataStructure} which makes the decision about where to step next.
 * This {@link Crawler} works with dataStructures that implements the {@link IDataStructure} interface.
 * The {@link DataStructures.DepthFirst} dataStructure will give a depth first approach.
 * The {@link DataStructures.BreadthFirst} dataStructure will give a Breadth first approach.
 * The {@link DataStructures.Greedy} dataStructure will take the best possible single step each move.
 *
 * @author MaZeeT
 */
public class Crawler implements IMover {

    private MovableEntity movableEntity;
    private List<GameObject> gameObjects;
    private List<Position> gameObjectPositions;
    private IDataStructure dataStructure;

    /**
     * The constructor of the {@link Crawler} class.
     * This take a {@link IMaze}, a {@link MovableEntity} and a {@link IDataStructure} as an input,
     * and connect some of the private variables to different Lists from the {@link IMaze}.
     *
     * @param maze          The {@link IMaze} where the {@link Crawler} will move in.
     * @param EntityToMove  The {@link MovableEntity} that the {@link Crawler} will move around.
     * @param dataStructure The {@link IDataStructure} that will hold the {@link Position}s the {@link Crawler} will move around to.
     */
    public Crawler(IMaze maze, MovableEntity EntityToMove, IDataStructure dataStructure) {
        this.movableEntity = EntityToMove;
        this.gameObjects = maze.getMaze();
        this.gameObjectPositions = maze.getMazePositions();
        this.dataStructure = dataStructure;
    }

    //todo check text around visited walls.
    /**
     * This method is called on each move "tick".
     * First the {@link Position} of the {@link MovableEntity} is added as a visited wall,
     * and nearby positions of the {@link MovableEntity} is checked and added to the dataStructure.
     * If the dataStructure is not empty, the {@link MovableEntity}'s position will be checked to the next in the dataStructure.
     */
    @Override
    public void move() {
        gameObjects.add(visited(movableEntity.getPosition()));
        checkNearby(movableEntity);
        if (dataStructure.checkNext() != null) {
            movableEntity.setPosition(dataStructure.getNext());
        }
    }

    //todo this have never worked, make it working or remove.
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

}
