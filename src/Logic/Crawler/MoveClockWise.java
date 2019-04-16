package Logic.Crawler;

import Components.Position;
import Entities.GameObject;
import Entities.MovableEntity;
import Entities.Player;
import Maze.IMaze;

import java.util.List;

/**
 * The purpose of this class is it enable user controlled inputs.
 * This class get direction inputs as chars, and update the {@link Player} accordingly.
 *
 * @author MaZeeT
 */
public class MoveClockWise {
    private char dir;
    private MovableEntity player;
    private List<Position> walls;

    /**
     * Constructor for this class. It needs a maze to know where the {@link GameObject}s and the {@link Player} are.
     *
     * @param maze The {@link IMaze} which need to have a user controlled {@link Player}.
     */
    public MoveClockWise(IMaze maze) {
        this.player = maze.getPlayer();
        this.walls = maze.getMazePositions();
    }

    /**
     * Move the {@link Player} in a given direction.
     *
     * @param dir The direction the {@link Player} has to move.
     */
    public void move(char dir) {
        this.dir = dir;
        movement(player);
    }

    /**
     * Get the direction of the {@link Player}.
     *
     * @return Returns the direction as a char.
     */
    public char getDirection() {
        return dir;
    }

    /**
     * This method controls the movement of the {@link Player}.
     * If the {@link Player} collides he will change direction clock wise.
     * If not the {@link Position} will be update to a step in the given direction.
     *
     * @param player The {@link Player} that is moving.
     */
    private void movement(MovableEntity player) {
        switch (dir) {
            case 'w':
                if (collideWith(walls, player.checkUp())) {
                    dir = 'd';
                    movement(player);
                } else {
                    player.moveUp();
                }
                break;

            case 's':
                if (collideWith(walls, player.checkDown())) {
                    dir = 'a';
                    movement(player);
                } else {
                    player.moveDown();
                }
                break;

            case 'a':
                if (collideWith(walls, player.checkLeft())) {
                    dir = 'w';
                    movement(player);
                } else {
                    player.moveLeft();
                }
                break;

            case 'd':
                if (collideWith(walls, player.checkRight())) {
                    dir = 's';
                    movement(player);
                } else {
                    player.moveRight();
                }
                break;
        }
    }

    /**
     * Checks if the given {@link Position} collides with a {@link Position} used by the {@link IMaze}
     *
     * @param walls    The list of {@link Position} used by the {@link IMaze}.
     * @param position The {@link Position} that wish to be checked for collision.
     * @return Returns true or false, depending if the {@link Position} collide with the walls or not.
     */
    private boolean collideWith(List<Position> walls, Position position) {
        return walls.contains(position);
    }
}
