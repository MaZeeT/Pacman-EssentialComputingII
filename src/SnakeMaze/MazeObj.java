package SnakeMaze;

import SnakeEntities.GameObject;

import java.util.ArrayList;

public class MazeObj extends MazeObjBased{

    private int sizeX;
    private int sizeY;


    public MazeObj(int width, int height) {
        this.sizeX = width;
        this.sizeY = height;
        this.walls = new ArrayList<>();
        maze = new GameObject[sizeX][sizeY];

        addPlayer(5, 7);
        addWayPoint(7, 5);

        borders();
        corners();
        diagonalWall(3,8);
    }

    private void borders() {
        for (int i = 0; i < sizeX; i++) {
            addWall(i, 0);
            addWall(i, sizeY - 1);
        }

        for (int i = 0; i < sizeY; i++) {
            addWall(0, i);
            addWall(sizeX - 1, i);
        }
    }

    private void corners(){
        addWall(1, 1);
        addWall(1, sizeY - 2);
        addWall(sizeX - 2, 1);
        addWall(sizeX - 2, sizeY - 2);
    }

    private void diagonalWall(int start, int end){
        for (int i = start; i < end; i++) {
            addWall(i, i);
        }
    }

}
