package SnakeLogic;

import SnakeEntities.GameObject;
import SnakeEntities.Wall;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    int height;
    int width;
    List<GameObject> list = new ArrayList<>();


    public Maze(int height, int width) {
        this.height = height;
        this.width = width;
        generateWalls();
    }

    private void generateWalls(){
        for (int i = 0; i<= width; i++){
            list.add(new Wall(0,i));
        }
    }

    public List<GameObject> getMaze(){
        return list;
    }

}
