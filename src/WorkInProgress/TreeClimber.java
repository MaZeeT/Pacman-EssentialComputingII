package WorkInProgress;

import Components.Position;
import Entities.MovableEntity;
import Maze.IMaze;
import Movement.IMover;

import java.util.ArrayList;
import java.util.List;

public class TreeClimber<T extends Comparable> implements IMover {
    private Tree<T> tree;
    private IMaze maze;
    private MovableEntity movableEntity;
    private List<Position> mainList;   //todo make class abstract and force instantiation of list

    public TreeClimber(IMaze maze, MovableEntity movableEntity) {
        tree = new Tree<>(); // new tree
        this.maze = maze;
        this.movableEntity = movableEntity;
    }

    private List<Position> generatePath() {

        // exploreTree()
        // get list or queue
        return new ArrayList<>();
    }

    @Override
    public void move() {
        List<Position> list = generatePath();
        movableEntity.setPosition(list.get(list.size() - 1));
        //set position to shortestPathList.next()

    }

}
