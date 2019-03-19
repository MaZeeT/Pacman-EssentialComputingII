package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.WayPoint;

import java.util.List;

public interface IMaze {

    List<GameObject> getMaze();

    List<Position> getMazePositions();

    Player getPlayer();

    WayPoint getWayPoint();

    List<GameObject> getWalls();

}
