package SnakeMaze;

import SnakeEntities.GameObject;
import SnakeEntities.Wall;

import java.util.ArrayList;
import java.util.List;

public class Maze implements IMaze {

    private int r = 0;
    private int sizeX;
    private int sizeY;
    private List<GameObject> list = new ArrayList<>();
    private GameObject[][] maze;

    public Maze(int width, int height) {
        this.sizeX = width;
        this.sizeY = height;
        maze = new GameObject[sizeX][sizeY];
        generateWalls();
    }

    private void generateWalls() {
        for (int i = 0; i < sizeX; i++) {
            addWall(i, 0);
            addWall(i, sizeY - 1);
        }

        for (int i = 0; i < sizeY; i++) {
            addWall(0, i);
            addWall(sizeX - 1, i);
        }
    }

    public int generateMaze() {
        for (int i = 3; i < 8; i++) {
            addWall(i, i);
        }

        addWall(1, 1);
        addWall(1, sizeY - 2);
        addWall(sizeX - 2, 1);
        addWall(sizeX - 2, sizeY - 2);

        return r;
    }

    private void addWall(int x, int y) {
        if (maze[x][y] == null) {
            Wall w = new Wall(x, y);
            maze[x][y] = w;
            list.add(w);
            r++;
        }
    }

    public List<GameObject> getMaze() {
        return list;
    }
}
