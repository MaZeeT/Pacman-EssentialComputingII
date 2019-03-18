package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.WayPoint;

import java.util.ArrayList;
import java.util.List;

public class MazeWithExit implements IMaze {
    private List<GameObject> gameObjects = new ArrayList<>();
    private List<GameObject> walls;
    private Player player;
    private WayPoint wayPoint;


    public MazeWithExit() {
        ArrayGet arrayGet = new ArrayGet(6,7);
        int[][] maze = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 2, 1, 0, 0, 3},
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };
        walls = arrayGet.walls(maze);
        player = arrayGet.player(maze);
        wayPoint = arrayGet.wayPoint(maze);
    }


    @Override
    public List<GameObject> getMaze() {
        if (!gameObjects.contains(player)) gameObjects.add(player);
        if (!gameObjects.contains(wayPoint)) gameObjects.add(wayPoint);
        for (GameObject wall : walls){
            if (!gameObjects.contains(wall)) gameObjects.add(wall);
        }
        return gameObjects;
    }

    @Override
    public List<Position> getMazePositions() {
        List<Position> list = new ArrayList<>();
        for (GameObject gameObject : walls) {
            list.add(gameObject.getPosition());
        }
        return list;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public WayPoint getWayPoint() {
        return wayPoint;
    }

    @Override
    public List<GameObject> getWalls() {
        return walls;
    }

    @Override
    public void generateMaze() {
    }

}
