package SnakeGUI;

import SnakeEntities.GameObject;

import java.util.List;

public interface IManager {

    void startGame();

    void pauseGame();

    void setGameObects(List<GameObject> renderableGameObjects);
}
