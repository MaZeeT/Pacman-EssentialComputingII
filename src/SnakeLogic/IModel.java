package SnakeLogic;

import SnakeEntities.GameObject;

import java.util.ArrayList;

public interface IModel {

    void startGame();

    void pauseGame();

    ArrayList<GameObject> getGameObjects();
}
