package SnakeGUI;

import SnakeEntities.GameObject;

import java.util.List;

public interface IManager {

    void startGame();

    void pauseGame();

    void update(List<GameObject> gameObjects);

    View getView();
}
