package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeEntities.WayPoint;

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
