package Maze;

import Components.Position;
import Entities.GameObject;
import Entities.Player;
import Entities.WayPoint;

import java.util.List;

//TODO write javaDoc
public interface IMaze {

    List<GameObject> getMaze();

    List<Position> getMazePositions();

    Player getPlayer();

    WayPoint getWayPoint();

    List<GameObject> getWalls();

}
