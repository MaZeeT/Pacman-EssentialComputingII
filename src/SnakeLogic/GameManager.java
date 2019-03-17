package SnakeLogic;

import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeLogic.Crawler.MoveClockWise;
import SnakeMaze.IMaze;
import SnakeMaze.Maze;

import java.util.*;

public class GameManager {

    private List<GameObject> walls;
    private List<GameObject> wayPoints = new ArrayList<>();
    private List<GameObject> snake = new ArrayList<>();

    private char direction;
    private int width;
    private int height;
    private MoveClockWise movement;

    public GameManager(int width, int height) {
        this.width = width;
        this.height = height;

        IMaze maze = new Maze(10, 10);
        maze.generateMaze();
        //IMaze maze = new MazeWithExit();

        walls = maze.getMaze();

        Player player = maze.getPlayer();
        snake.add(player);
        wayPoints.add(maze.getWayPoint());

        movement = new MoveClockWise(player, walls);
    }

    // update loop to make the game run
    public void update() {
        movement.move(direction);
        direction = movement.getDirection();
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
