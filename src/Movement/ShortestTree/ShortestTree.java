package Movement.ShortestTree;

import Components.Position;
import DataStructures.*;
import Entities.GameObject;
import Entities.MovableEntity;
import Maze.IMaze;
import Movement.IMover;

import java.util.ArrayList;
import java.util.List;

public class ShortestTree implements IMover {
    private Tree<Position> tree;
    private MovableEntity movableEntity;
    private GameObject target;
    private List<Position> walls;
    private DataStructure<Position> queue;
    private MyStack<Position> stack;
    private boolean updatePath;

    public ShortestTree(IMaze maze, MovableEntity movableEntity, GameObject target, boolean updatePath) {
        tree = new Tree<>();
        queue = new MyQueue<>();
        walls = new ArrayList<>();
        for (GameObject wall : maze.getWalls()) {
            walls.add(wall.getPosition());
        }
        this.movableEntity = movableEntity;
        this.target = target;
        this.updatePath = updatePath;
        // if (!updatePath) {
        buildTree(movableEntity.getPosition(), target.getPosition()); //build the tree once if the path isn't updated for each step.
        stack = tree.getAllParents(target.getPosition());
        //  }

    }

    private void buildTree(Position startPosition, Position targetPosition) {
        tree = new Tree<>();
        tree.add(startPosition);
        queue.add(startPosition);
        nearby(startPosition);
        while (!queue.isEmpty() //todo clean up
                && queue.checkNext() != targetPosition
        ) {
            nearby(queue.getNext());
        }
    }

    private void nearby(Position position) {
        //explorer is a hack to access the nearby functions of the MovableGameObject class.
        MovableEntity explorer = new Explorer();
        explorer.setPosition(position);

        addNearby(position, explorer.checkUp());
        addNearby(position, explorer.checkRight());
        addNearby(position, explorer.checkDown());
        addNearby(position, explorer.checkLeft());
    }

    private void addNearby(Position pos, Position checkPos) {
        if (!walls.contains(checkPos)) {
            queue.add(checkPos);
            tree.add(pos, checkPos);
        }
    }

    @Override
    public void move() {
        if (!stack.isEmpty()) {
            movableEntity.setPosition(stack.getNext());
        }
        if (updatePath) {
             buildTree(movableEntity.getPosition(), target.getPosition());
            // movableEntity.setPosition(stack.getNext());
            //  stack = tree.getAllParents(target.getPosition());
        }
        System.out.println(stack);
    }

}


class Explorer extends MovableEntity {

    @Override
    public boolean update() {
        return false;
    }
}
