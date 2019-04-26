package Movement.DataStructureCrawlers;

import Components.Position;
import DataStructures.IDataStructure;
import Entities.*;
import Maze.IMaze;
import Movement.IMover;

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
        this.gameObjectPositions = maze.getMazePositions();
        this.dataStructure = dataStructure;
    }

    /**
     * This method is called on each move "tick" and handle the movement of the {@link MovableEntity}.
     * The movement is handle to add the nearby {@link Position}s to a dataStructure implementing
     * the {@link IDataStructure} interface and setting the {@link Position} to the next {@link Position} in the dataStructure.
     */
    @Override
    public void move() {
        checkNearby(movableEntity);
        if (dataStructure.checkNext() != null) {
            movableEntity.setPosition(dataStructure.getNext());
        }
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
