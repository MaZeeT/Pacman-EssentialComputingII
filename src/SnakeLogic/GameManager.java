package SnakeLogic;

import SnakeDataStructures.IDataStructure;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeLogic.Crawler.Crawler;
import SnakeLogic.Crawler.MoveClockWise;
import SnakeMaze.IMaze;


import java.util.*;

//TODO write javaDoc
public class GameManager {

    private List<GameObject> walls;
    private List<GameObject> wayPoints = new ArrayList<>();
    private List<GameObject> snake = new ArrayList<>();

    private char direction;
    private MoveClockWise movement;
    private Crawler crawler;

    private boolean crawl = true;

    public GameManager(IMaze maze, IDataStructure dataStructure) {
        walls = maze.getWalls();

        Player player = maze.getPlayer();
        snake.add(player);
        wayPoints.add(maze.getWayPoint());

        movement = new MoveClockWise(maze);
        crawler = new Crawler(maze, dataStructure);
    }

    // update loop to make the game run
    public void update() {
        movement.move(direction);
        direction = movement.getDirection();

        if (crawl) crawler.update();
    }

    // get and set
    public void setDirection(char direction) {
        this.direction = direction;
        System.out.println(direction);
    }

    char getDirection() {
        return this.direction;
    }

    //export gameObjects for GUI
    private List<GameObject> combineGameObjects() {
        List<GameObject> gameObjects = new ArrayList<>();
        gameObjects.addAll(wayPoints);
        gameObjects.addAll(walls);
        gameObjects.addAll(snake);

        return gameObjects;
    }

    public List<GameObject> getGameObjects() {
        return combineGameObjects();
    }

}
