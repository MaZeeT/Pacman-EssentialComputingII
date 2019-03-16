package SnakeLogic;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.WayPoint;
import SnakeEntities.Player;
import SnakeLogic.Movement.MoveClockWise;
import SnakeMaze.IMaze;
import SnakeMaze.Maze;

import java.util.*;

public class GameManager {

    private List<GameObject> walls;
    private List<GameObject> wayPoints = new ArrayList<>();
    private List<GameObject> snake = new ArrayList<>();

    private int maxWayPoints = 2;
    private char direction;
    private int width;
    private int height;
    private MoveClockWise movement;

    public GameManager(int width, int height) {
        this.width = width;
        this.height = height;

        Player player = new Player(new Position(5, 3));
        snake.add(player);

        addNewWayPoint(wayPoints, maxWayPoints);

        IMaze maze = new Maze(10, 10);
        walls = maze.getMaze();

        movement = new MoveClockWise(player, walls);
    }

    // update loop to make the game run
    public void update() {
        movement.move(direction);
        direction = movement.getDirection();
        addNewWayPoint(wayPoints, maxWayPoints);
    }


    private void addNewWayPoint(List<GameObject> wayPoints, int maxWayPoints) {
        if (wayPoints.size() < maxWayPoints) {
            Position pos;
            pos = getRandomPosition();
            for (GameObject wayPoint : wayPoints) {
                if (wayPoint.getPosition().compareTo(pos) != 0) {
                    wayPoints.add(new WayPoint(pos));
                }
            }
        }
    }

/*
    // unused functions
    private void removeWayPoint(int index) {
        wayPoints.remove(index);
    }

    private void collideWithWayPoint(WayPoint wayPoint) {

    }
*/

    // get and set
    private Position getRandomPosition() {
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        return new Position(x, y);
    }

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
