package SnakeLogic.Movement;

import SnakeComponents.Position;
import SnakeEntities.GameObject;
import SnakeEntities.Player;

import java.util.List;

public class MoveClockWise implements IMovement {
    private char dir;
    private Player player;
    private List<GameObject> walls;

    public MoveClockWise(Player player, List<GameObject> walls) {
        this.player = player;
        this.walls = walls;
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
                if (collide(walls, player.checkUp())) player.moveUp();
                else {
                    System.out.println("Path Blocked");
                    dir = 'd';
                    movement(player);
                }
                break;

            case 's':
                if (collide(walls, player.checkDown())) player.moveDown();
                else {
                    System.out.println("Path Blocked");
                    dir = 'a';
                    movement(player);
                }
                break;

            case 'a':
                if (collide(walls, player.checkLeft())) player.moveLeft();
                else {
                    System.out.println("Path Blocked");
                    dir = 'w';
                    movement(player);
                }
                break;

            case 'd':
                if (collide(walls, player.checkRight())) player.moveRight();
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
