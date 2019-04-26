package Movement.ShortestTree;

import Components.Position;
import DataStructures.*;
import Entities.GameObject;
import Entities.MovableEntity;
import Maze.IMaze;
import Movement.IMover;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to provide a {@link IMover} that finds the shortest route to a given target.
 * This is done by flood filling (breadFirst) a {@link Tree} and generate a {@link MyStack}
 * from the target in the {@link Tree} to the {@link MovableEntity} that is trying to get to the target.
 *
 * @author MaZeeT
 */
public class ShortestTree implements IMover {
    private Tree<Position> tree;
    private MovableEntity movableEntity;
    private Position targetPos;
    private List<Position> walls;
    private DataStructure<Position> queue;
    private MyStack<Position> stack;
    private boolean updatePath;

    /**
     * A constructor that sets a few variables from the parameters given.
     * That populate a new arrayList with the {@link Position}s of the {@link Entities.Wall}s of the {@link IMaze}.
     * Lastly it builds the {@link Tree} and generate a {@link MyStack} from it.
     *
     * @param maze          The {@link IMaze} which the program will run with.
     * @param movableEntity The {@link MovableEntity} that will be controlled by this {@link IMover}.
     * @param target        The {@link GameObject} the {@link MovableEntity} will move towards.
     * @param updatePath    A boolean to enable tracing of the target.
     *                      True to trace target as {@link Position} updates,
     *                      false to move to target's starting {@link Position}.
     */
    public ShortestTree(IMaze maze, MovableEntity movableEntity, GameObject target, boolean updatePath) {
        this.movableEntity = movableEntity;
        this.targetPos = target.getPosition();
        this.updatePath = updatePath;

        walls = new ArrayList<>();
        for (GameObject wall : maze.getWalls()) {
            walls.add(wall.getPosition());
        }

        buildTree(movableEntity.getPosition());
        stack = tree.getAllParents(target.getPosition());
    }

    /**
     * A method to initilize and build a {@link Tree} and populate it until all {@link Position}s have been added to the tree.
     *
     * @param startPosition The {@link Position} where the {@link MovableEntity} is starting.
     */
    private void buildTree(Position startPosition) {
        tree = new Tree<>();
        queue = new MyQueue<>();
        tree.add(startPosition);
        queue.add(startPosition);
        nearby(startPosition);
        while (!queue.isEmpty()) {
            nearby(queue.getNext());
        }
    }

    /**
     * A helper method to add all the {@link Position}s next to a given position,
     * like up / down / left / right to the central {@link Position}.
     *
     * @param position The central {@link Position} where the nearby {@link Position}s will be added.
     */
    private void nearby(Position position) {
        //explorer is a hack to access the nearby functions of the MovableGameObject class.
        MovableEntity explorer = new Explorer();
        explorer.setPosition(position);

        addNearby(position, explorer.checkUp());
        addNearby(position, explorer.checkRight());
        addNearby(position, explorer.checkDown());
        addNearby(position, explorer.checkLeft());
    }

    /**
     * A helper method to add a new {@link Position} to the {@link MyQueue} and {@link Tree}.
     *
     * @param pos      The {@link Position} you are standing.
     * @param checkPos The {@link Position} next to you, which will be added.
     */
    private void addNearby(Position pos, Position checkPos) {
        if (!walls.contains(checkPos)) {
            queue.add(checkPos);
            tree.add(pos, checkPos);
        }
    }

    /**
     * {@inheritDoc}
     * This method will handle the "move" depending on if the updatePath variable is set to true or false.
     * If true, a new tree and stack will be build after each move, to update where the target have moved to.
     * If false, only the move to next in the stack will be executed.
     */
    @Override
    public void move() {
        if (!stack.isEmpty()) {
            movableEntity.setPosition(stack.getNext());
        }
        if (updatePath) {
            buildTree(movableEntity.getPosition());
            stack = tree.getAllParents(targetPos);

            // skip a position in the stack if it is the same as the movableEntity's Position, to not get stuck.
            if (stack.checkNext().equals(movableEntity.getPosition())) {
                stack.getNext();
            }
        }
    }

}

/**
 * The purpose of this inner class is to give access to the checkUp etc. methods.
 *
 * @author MaZeeT
 */
class Explorer extends MovableEntity {

    /**
     * A dummy function to fulfill the abstract super class.
     *
     * @return Always returns false.
     */
    @Override
    public boolean update() {
        return false;
    }
}
