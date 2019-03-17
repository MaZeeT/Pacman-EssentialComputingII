package SnakeMaze;

import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.WayPoint;

import java.util.List;

public interface IMaze {

    List<GameObject> getMaze();

    Player getPlayer();

    WayPoint getWayPoint();

    int generateMaze();
}
