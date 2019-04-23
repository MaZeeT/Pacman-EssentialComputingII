package WorkInProgress;

import Components.Position;
import DataStructures.*;
import Entities.GameObject;
import Entities.Ghost;
import Entities.MovableEntity;
import Maze.IMaze;
import Movement.IMover;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathTree implements IMover {
    private Tree<Position> tree;
    private IMaze maze;
    private MovableEntity movableEntity;
    private GameObject target;
    private List<Position> mainList;   //todo make class abstract and force instantiation of list
    private DataStructure<Position> queue;
    private MovableEntity explorer;

    // wrapper for a tree, to take a target, generate a path to the target,
// and on each update calls move 1 position closer, maybe use a queue.
    public ShortestPathTree(IMaze maze, MovableEntity movableEntity) {
        tree = new Tree<>(); // new tree
        this.maze = maze;
        this.movableEntity = movableEntity;
    }

    private void buildTree() {
        tree = new Tree<>();
        explorer = new Explorer();
        addNearboes(movableEntity.getPosition());
        while (queue.isEmpty());
    }

    private void addNearboes(Position position) {
        explorer.setPosition(position);
        queue.add(explorer.checkUp());
        queue.add(explorer.checkRight());
        queue.add(explorer.checkDown());
        queue.add(explorer.checkLeft());
    }

    @Override
    public void move() {
        List<Position> list = tree.getAllParents(target.getPosition());
        movableEntity.setPosition(list.get(list.size() - 1));
    }

}

class Explorer extends MovableEntity {

    @Override
    public boolean update() {
        return false;
    }
}
