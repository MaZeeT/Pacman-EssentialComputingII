package Movement;

/**
 * The purpose of this interface is to define a common way to implement different ways
 * to move different {@link Entities.MovableEntity} in the program
 *
 * @author MaZeeT
 */
public interface IMove {

    /**
     * This will perform a single movement for each call
     */
    void move();

    /**
     * Sets the direction the next move should be in.
     *
     * @param direction The direction the next move should be given as a char.
     */
    void setDirection(char direction);

    /**
     * Gets the direction the next move will be taken towards.
     *
     * @return Returns the direction the next move will be taken towards.
     */
    char getDirection();

}
