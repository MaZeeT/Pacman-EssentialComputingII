package SnakeMaze;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeEntities.WayPoint;

import java.util.ArrayList;
import java.util.List;

public class ArrayTo {

    public List<GameObject> list(int[][] arr){
        List<GameObject> list = new ArrayList<>();
        int j = 0;
        for (int[] jArr:arr){

            for (int i:jArr){
                if (i == 1) list.add(new Wall(new Position(i,j)));
                if (i == 2) list.add(new Player(new Position(i,j)));
                if (i == 3) list.add(new WayPoint(new Position(i,j)));
            }
            j++;
        }
        return list;
    }

}
