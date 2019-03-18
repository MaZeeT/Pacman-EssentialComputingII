package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeEntities.WayPoint;

import java.util.ArrayList;
import java.util.List;

public class ArrayGet {

    private int height;
    private int width;

    public ArrayGet(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public WayPoint wayPoint(int[][] arr) {
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (arr[i][j] == 3) return new WayPoint(new Position(i, j));
            }
        }
        return null;
    }

    public Player player(int[][] arr) {
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (arr[i][j] == 2) return new Player(new Position(i, j));
            }
        }
        return null;
    }

    public List<GameObject> walls(int[][] arr) {
        List<GameObject> walls = new ArrayList<>();
        for (int j = 0; j < width; j++) {
            for (int i = 0; i < height; i++) {
                if (arr[i][j] == 1) walls.add(new Wall(new Position(i, j)));
            }
        }
        return walls;
    }

}
