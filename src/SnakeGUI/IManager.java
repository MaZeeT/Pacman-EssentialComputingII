package SnakeGUI;

import SnakeEntities.GameObject;

import java.util.List;

public interface IManager {

    void startGame();

    void pauseGame();

    void setGameObjects(List<GameObject> renderableGameObjects);

    View getView();
}
