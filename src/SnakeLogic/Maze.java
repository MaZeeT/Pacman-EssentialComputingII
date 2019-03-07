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
            list.add(new Wall(i,0));
            list.add(new Wall(i,height));
        }

        for (int i = 0; i<= height; i++){
            list.add(new Wall(0,width));
            list.add(new Wall(height,width));
        }
    }

    public List<GameObject> getMaze(){
        return list;
    }

}
