package SnakeMaze;

import SnakeEntities.GameObject;

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
    public int generateMaze() {
        return 0;
    }

}
