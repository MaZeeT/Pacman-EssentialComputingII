package Movement.ShortestTree;

import Components.Position;
import DataStructures.*;
import Entities.GameObject;
import Entities.MovableEntity;
import Maze.IMaze;
import Movement.IMover;

import java.util.ArrayList;
import java.util.List;

//todo write javaDoc
public class ShortestTree implements IMover {
    private Tree<Position> tree;
    private MovableEntity movableEntity;
    private Position targetPos;
    private List<Position> walls;
    private DataStructure<Position> queue;
    private MyStack<Position> stack;
    private boolean updatePath;

    public ShortestTree(IMaze maze, MovableEntity movableEntity, GameObject target, boolean updatePath) {
        this.movableEntity = movableEntity;
        this.targetPos = target.getPosition();
        this.updatePath = updatePath;

        tree = new Tree<>();
        queue = new MyQueue<>();
        walls = new ArrayList<>();
        for (GameObject wall : maze.getWalls()) {
            walls.add(wall.getPosition());
        }

        buildTree(movableEntity.getPosition());
        stack = tree.getAllParents(target.getPosition());
    }

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
            buildTree(movableEntity.getPosition());
            stack = tree.getAllParents(targetPos);

            // skip a position in the stack if it is the same as the movableEntity's Position, to not get stuck.
            if (stack.checkNext().equals(movableEntity.getPosition())) {
                stack.getNext();
            }
        }
    }

}

//todo write javaDoc
class Explorer extends MovableEntity {

    @Override
    public boolean update() {
        return false;
    }
}
