package SnakeMaze;

import SnakeEntities.GameObject;
import SnakeEntities.Wall;

import java.util.ArrayList;
import java.util.List;

public class Maze implements IMaze {

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
            if (maze[i][0] == null) {
                Wall w = new Wall(i, 0);
                maze[i][0] = w;
                list.add(w);
            }
            if (maze[i][sizeY - 1] == null) {
                Wall w = new Wall(i, sizeY - 1);
                maze[i][sizeY - 1] = w;
                list.add(w);
            }
        }

        for (int i = 0; i < sizeY; i++) {
            if (maze[0][i] == null) {
                Wall w = new Wall(0, i);
                maze[0][i] = w;
                list.add(w);
            }
            if (maze[sizeX - 1][i] == null) {
                Wall w = new Wall(sizeX - 1, i);
                maze[sizeX - 1][i] = w;
                list.add(w);
            }
        }
    }

    public int generateMaze() {
        int r = 0;
        for (int i = 3; i < 8; i++) {
            if (maze[i][i] == null) {
                Wall w = new Wall(i, i);
                maze[i][i] = w;
                list.add(w);
                r++;
            }
        }
        return r;
    }

    public List<GameObject> getMaze() {
        return list;
    }
}
