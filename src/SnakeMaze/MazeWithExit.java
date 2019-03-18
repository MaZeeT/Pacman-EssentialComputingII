package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.WayPoint;

import java.util.List;

public class MazeWithExit implements IMaze {
    private List<GameObject> list;

    public MazeWithExit() {
        ArrayTo arrayTo = new ArrayTo();
        int[][] maze = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 2, 1, 0, 0, 3},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };
        list = arrayTo.list(maze);
    }


    @Override
    public List<GameObject> getMaze() {
        return list;
    }

    @Override
    public List<Position> getMazePositions() {
        return null;
    }

    @Override
    public Player getPlayer() {
        return null;
    }

    @Override
    public WayPoint getWayPoint() {
        return null;
    }

    @Override
    public List<GameObject> getWalls() {
        return null;
    }

    @Override
    public int generateMaze() {
        return 0;
    }

}
