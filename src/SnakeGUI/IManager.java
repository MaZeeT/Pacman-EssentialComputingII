package SnakeGUI;

import SnakeEntities.GameObject;

import java.util.ArrayList;

public interface IManager {

    void startGame();

    void pauseGame();

    void setGameObects(ArrayList<GameObject> gameObjects);
}
