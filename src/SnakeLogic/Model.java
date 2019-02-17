package SnakeLogic;

import SnakeEntities.GameObject;

import java.util.ArrayList;

public class Model implements IModel {

    private ArrayList<GameObject> items;

    public void startGame() {

    }

    private boolean gamePaused = false;
    public void pauseGame(){
        gamePaused = !gamePaused;
    }

    public ArrayList<GameObject> getGameObjects(){
        return items;
    }

    public Model getModel(){
        return this;
    }




}
