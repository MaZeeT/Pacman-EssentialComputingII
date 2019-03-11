package SnakeMaze;

import SnakeEntities.GameObject;

import java.util.List;

public interface IMaze {

    List<GameObject> getMaze();

    int generateMaze();
}
