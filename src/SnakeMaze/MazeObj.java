package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeEntities.WayPoint;

import java.util.ArrayList;

public class MazeObj extends Maze{

    private int sizeX;
    private int sizeY;
    private GameObject[][] maze;

    public MazeObj(int width, int height) {
        this.sizeX = width;
        this.sizeY = height;
        this.walls = new ArrayList<>();
        maze = new GameObject[sizeX][sizeY];
        generateWalls();
        //generateMaze();
        // TODO remove generateMaze from outside the class
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

    @Override
    public void generateMaze() {
        for (int i = 3; i < 8; i++) {
            addWall(i, i);
        }

        addWall(1, 1);
        addWall(1, sizeY - 2);
        addWall(sizeX - 2, 1);
        addWall(sizeX - 2, sizeY - 2);
        addPlayer(5, 7);
        //addPlayer(2,2);
        addWayPoint(7, 5);
    }

    private void addWall(int x, int y) {
        if (maze[x][y] == null) {
            Wall w = new Wall(x, y);
            maze[x][y] = w;
            walls.add(w);
        }
    }

    private void addPlayer(int x, int y) {
        if (maze[x][y] == null) {
            player = new Player(new Position(x, y));
            maze[x][y] = player;
        }
    }

    private void addWayPoint(int x, int y) {
        if (maze[x][y] == null) {
            wayPoint = new WayPoint(new Position(x, y));
            maze[x][y] = wayPoint;
        }
    }

}
