package Movement.UserControlled;

import Components.Position;
import Entities.*;
import Maze.IMaze;
import Movement.IMover;

import java.util.List;

/**
 * The purpose of this class is to define a implementation of the {@link IMoverControlled} interface which enable user controlled inputs.
 * By implementing the {@link IMoverControlled} interface a {@link IMover} can be controlled if a input is given.
 * This class get direction inputs as chars, and move the {@link MovableEntity} accordingly.
 *
 * @author MaZeeT
 */
public class MoveClockWise implements IMover, IMoverControlled {
    private char dir;
    private MovableEntity movableEntity;
    private List<Position> walls;

    /**
     * Constructor for this class. It needs a maze to know where the {@link GameObject}s and the {@link MovableEntity} are.
     *
     * @param maze          The {@link IMaze} which need to have a user controlled {@link MovableEntity}.
     * @param movableEntity The {@link MovableEntity} that should be controlled by the {@link IMover}.
     */
    public MoveClockWise(IMaze maze, MovableEntity movableEntity) {
        this.movableEntity = movableEntity;
        this.walls = maze.getMazePositions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void move() {
        movement(movableEntity);
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
     * This method controls the movement of the {@link MovableEntity}.
     * If the {@link MovableEntity} collides it will change direction clock wise.
     * If not the {@link Position} will be move to a step in the given direction.
     *
     * @param movableEntity The {@link MovableEntity} that is moving.
     */
    private void movement(MovableEntity movableEntity) {
        switch (dir) {
            case 'w':
                if (collideWith(walls, movableEntity.checkUp())) {
                    dir = 'd';
                    movement(movableEntity);
                } else {
                    movableEntity.moveUp();
                }
                break;

            case 's':
                if (collideWith(walls, movableEntity.checkDown())) {
                    dir = 'a';
                    movement(movableEntity);
                } else {
                    movableEntity.moveDown();
                }
                break;

            case 'a':
                if (collideWith(walls, movableEntity.checkLeft())) {
                    dir = 'w';
                    movement(movableEntity);
                } else {
                    movableEntity.moveLeft();
                }
                break;

            case 'd':
                if (collideWith(walls, movableEntity.checkRight())) {
                    dir = 's';
                    movement(movableEntity);
                } else {
                    movableEntity.moveRight();
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
