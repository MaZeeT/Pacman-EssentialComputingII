package Maze;

import Components.Position;
import Entities.GameObject;
import Entities.Player;
import Entities.WayPoint;

import java.util.ArrayList;
import java.util.List;

//TODO write javaDoc
public abstract class Maze implements IMaze {

    List<GameObject> walls;
    Player player;
    WayPoint wayPoint;

    public List<GameObject> getMaze() {
        List<GameObject> gameObjects = new ArrayList<>();
        for (GameObject wall : walls) { //TODO rewrite class to include walls.contain(wall) method.
            if (!gameObjects.contains(wall)) gameObjects.add(wall);
        }
        gameObjects.add(player);
        gameObjects.add(wayPoint);
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
