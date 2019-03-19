package SnakeMaze;

import SnakeEntities.GameObject;

import java.util.ArrayList;

//TODO write javaDoc
class MazeObjTestable extends MazeObjBased {

    private int width;
    private int height;

    MazeObjTestable(int width, int height) {
        this.width = width;
        this.height = height;
        this.maze = new GameObject[width][height];
        this.walls = new ArrayList<>();
        addPlayer(2, 2);
        addWayPoint(2, 3);
        borders();
    }

    private void borders() {
        for (int i = 0; i <= width - 1; i++) {
            addWall(i, 0);
            addWall(i, height - 1);
        }

        for (int i = 0; i <= height - 1; i++) {
            addWall(0, i);
            addWall(width - 1, i);
        }
    }


}
