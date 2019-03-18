package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.WayPoint;

import java.util.List;

//TODO get all mazes to implement this interface, to generalize the code more, and make it easier to test.
public interface IMaze {

    List<GameObject> getMaze();

    List<Position> getMazePositions();

    Player getPlayer();

    WayPoint getWayPoint();

    List<GameObject> getWalls();

    void generateMaze();
}
