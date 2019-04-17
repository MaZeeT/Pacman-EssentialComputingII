package Movement;

import Components.Position;
import Entities.GameObject;
import Entities.MovableEntity;
import Entities.Player;
import Maze.IMaze;

import java.util.List;
//todo check javadoc for changes since the implementation of IMove interface
/**
 * The purpose of this class is it enable user controlled inputs.
 * This class get direction inputs as chars, and move the {@link Player} accordingly.
 *
 * @author MaZeeT
 */
public class MoveClockWise implements IMove, IMoveControlled {
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
     * {@inheritDoc}
     */
    @Override
    public void move() {
        movement(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDirection(char direction) {
        this.dir = direction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public char getDirection() {
        return dir;
    }

    /**
     * This method controls the movement of the {@link Player}.
     * If the {@link Player} collides he will change direction clock wise.
     * If not the {@link Position} will be move to a step in the given direction.
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
