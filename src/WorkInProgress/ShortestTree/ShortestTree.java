package WorkInProgress.ShortestTree;

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
    private List<Position> visited;
    private List<Position> walls;
    private DataStructure<Position> queue;
    private boolean updatePath;

    // wrapper for a tree, to take a target, generate a path to the target,
// and on each update calls move 1 position closer, maybe use a queue.
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
        //if (!updatePath)
            buildTree(); //build the tree once if the path isn't updated for each step.
    }

    private void buildTree() {
        tree = new Tree<>();
        visited = new ArrayList<>();
//        explorer.setPosition(movableEntity.getPosition());
        tree.add(movableEntity.getPosition());
        queue.add(movableEntity.getPosition());
        visited.add(movableEntity.getPosition());

        nearby(movableEntity.getPosition());
        while (!queue.isEmpty() &&
                queue.checkNext() != target.getPosition()) {
            nearby(queue.getNext());
        }

    }

    private void nearby(Position position) {
        MovableEntity  explorer = new Explorer();
        explorer.setPosition(position);
        addNearby(position, explorer.checkUp());
        addNearby(position, explorer.checkRight());
        addNearby(position, explorer.checkDown());
        addNearby(position, explorer.checkLeft());
    }

    private void addNearby(Position pos, Position checkPos) {
        if (!walls.contains(checkPos) && !visited.contains(checkPos)) {
            visited.add(checkPos);
            queue.add(checkPos);
            tree.add(pos, checkPos);
        }
    }

    @Override
    public void move() {
        List<Position> list = tree.getAllParents(target.getPosition());
        System.out.println(list);
      //todo bug somewhere in the lines below
/*
        movableEntity.setPosition(list.get(1));
        if (updatePath) {
            buildTree();
        } else {
            list.remove(list.size() - 1);
        }*/
    }

}


class Explorer extends MovableEntity {

    @Override
    public boolean update() {
        return false;
    }
}
