package SnakeLogic.Crawler;

import SnakeComponents.Position;
import SnakeDataStructures.DepthFirst;
import SnakeDataStructures.IDataStructure;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeEntities.Wall;
import SnakeMaze.IMaze;
import javafx.scene.paint.Color;

import java.util.List;

public class DepthFirstCrawler {

    private Player player;
    private List<GameObject> gameObjects;
    private List<Position> gameObjectPositions;
    private IDataStructure depthFirst = new DepthFirst();


    public DepthFirstCrawler(IMaze maze) {
        this.player = maze.getPlayer();
        this.gameObjects = maze.getMaze();
        this.gameObjectPositions = maze.getMazePositions();
    }

    public void update() {
        gameObjects.add(visited(player.getPosition()));
        checkNearby(player);
        player.setPosition(depthFirst.getNext());
    }

    private Wall visited(Position position) {
        Wall wall = new Wall(position);
        wall.setColor(Color.YELLOW);
        return wall;
    }

    private void checkNearby(Player player) {
        addNearby(player.checkUp());
        addNearby(player.checkLeft());
        addNearby(player.checkDown());
        addNearby(player.checkRight());
    }

    private void addNearby(Position position) {
        for (Position pos : gameObjectPositions) {
            if (pos.compareTo(position) == 0) return;
        }
        if (!depthFirst.contains(position)) {
            depthFirst.add(position);
        }
    }

}
