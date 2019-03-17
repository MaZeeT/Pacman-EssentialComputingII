package SnakeLogic.Crawler;

import SnakeDataStructures.DepthFirst;
import SnakeDataStructures.IDataStructure;
import SnakeEntities.GameObject;

import java.util.List;

public class DepthFirstCrawler {

    private List<GameObject> gameObjects;
    private IDataStructure depthFirst;

    public DepthFirstCrawler(List<GameObject> list) {
        this.gameObjects = list;
        depthFirst = new DepthFirst();
    }

    public void update(){

    }

}
