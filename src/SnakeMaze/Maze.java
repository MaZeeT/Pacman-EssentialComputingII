package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.WayPoint;

import java.util.ArrayList;
import java.util.List;

public abstract class Maze implements IMaze {

    List<GameObject> gameObjects = new ArrayList<>();
    List<GameObject> walls;
    Player player;
    WayPoint wayPoint;

    public List<GameObject> getMaze() {
        if (!gameObjects.contains(player)) gameObjects.add(player);
        if (!gameObjects.contains(wayPoint)) gameObjects.add(wayPoint);
        for (GameObject wall : walls) {
            if (!gameObjects.contains(wall)) gameObjects.add(wall);
        }
        return gameObjects;
    }


    public List<Position> getMazePositions() {
        List<Position> list = new ArrayList<>();
        for (GameObject gameObject : getMaze()) {
            list.add(gameObject.getPosition());
        }
        return list;
    }


    public Player getPlayer() {
        return player;
    }


    public WayPoint getWayPoint() {
        return wayPoint;
    }


    public List<GameObject> getWalls() {
        return walls;
    }

}
