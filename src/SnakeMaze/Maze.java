package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeEntities.WayPoint;

import java.util.ArrayList;
import java.util.List;

public class Maze implements IMaze {

    private int r = 0;
    private int sizeX;
    private int sizeY;
    private List<GameObject> gameObjects = new ArrayList<>();
    private List<GameObject> walls = new ArrayList<>();
    private GameObject[][] maze;
    private Player player;
    private WayPoint wayPoint;

    public Maze(int width, int height) {
        this.sizeX = width;
        this.sizeY = height;
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

    public int generateMaze() {
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

        return r;
    }

    private void addWall(int x, int y) {
        if (maze[x][y] == null) {
            Wall w = new Wall(x, y);
            maze[x][y] = w;
            walls.add(w);
            r++;
        }
    }

    private void addPlayer(int x, int y) {
        if (maze[x][y] == null) {
            player = new Player(new Position(x, y));
            maze[x][y] = player;
            walls.add(player);
            r++;
        }
    }

    private void addWayPoint(int x, int y) {
        if (maze[x][y] == null) {
            wayPoint = new WayPoint(new Position(x, y));
            maze[x][y] = wayPoint;
            walls.add(wayPoint);
            r++;
        }
    }

    public List<GameObject> getWalls() {
        return walls;
    }

    public Player getPlayer() {
        return player;
    }

    public WayPoint getWayPoint() {
        return wayPoint;
    }

    public List<GameObject> getMaze() {
        if (!gameObjects.contains(player)) gameObjects.add(player);
        if (!gameObjects.contains(wayPoint)) gameObjects.add(wayPoint);
        for (GameObject wall : walls){
            if (!gameObjects.contains(wall)) gameObjects.add(wall);
        }
        return gameObjects;
    }

    public List<Position> getMazePositions() {
        List<Position> list = new ArrayList<>();
        for (GameObject gameObject : walls) {
            list.add(gameObject.getPosition());
        }
        return list;
    }
}
