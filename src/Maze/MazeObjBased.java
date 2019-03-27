package Maze;

import Components.Position;
import Entities.GameObject;
import Entities.Player;
import Entities.Wall;
import Entities.WayPoint;

//TODO write javaDoc
abstract class MazeObjBased extends Maze {

    GameObject[][] maze;

    void addWayPoint(int x, int y) {
        if (maze[x][y] == null) {
            wayPoint = new WayPoint(new Position(x, y));
            maze[x][y] = wayPoint;
        }
    }

    void addPlayer(int x, int y) {
        if (maze[x][y] == null) {
            player = new Player(new Position(x, y));
            maze[x][y] = player;
        }
    }

    void addWall(int x, int y) {
        if (maze[x][y] == null) {
            Wall w = new Wall(x, y);
            maze[x][y] = w;
            walls.add(w);
        }
    }
}
