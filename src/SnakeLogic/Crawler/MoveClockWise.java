package SnakeLogic.Crawler;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;
import SnakeMaze.IMaze;

import java.util.List;

public class MoveClockWise implements ICrawler {
    private char dir;
    private Player player;
    private List<GameObject> maze;

    public MoveClockWise(IMaze maze) {
        this.player = maze.getPlayer();
        this.maze = maze.getMaze();
    }

    public void move(char dir) {
        this.dir = dir;
        movement(player);
    }

    public char getDirection() {
        return dir;
    }

    private void movement(Player player) {
        switch (dir) {
            case 'w':
                if (collide(maze, player.checkUp())) player.moveUp();
                else {
                    System.out.println("Path Blocked");
                    dir = 'd';
                    movement(player);
                }
                break;

            case 's':
                if (collide(maze, player.checkDown())) player.moveDown();
                else {
                    System.out.println("Path Blocked");
                    dir = 'a';
                    movement(player);
                }
                break;

            case 'a':
                if (collide(maze, player.checkLeft())) player.moveLeft();
                else {
                    System.out.println("Path Blocked");
                    dir = 'w';
                    movement(player);
                }
                break;

            case 'd':
                if (collide(maze, player.checkRight())) player.moveRight();
                else {
                    System.out.println("Path Blocked");
                    dir = 's';
                    movement(player);
                }
                break;
        }
    }

    private boolean collide(List<GameObject> gameObjects, Position position) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.getPosition().compareTo(position) == 0) {
                return false;
            }
        }
        return true;
    }
}
