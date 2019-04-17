package Movement;

/**
 * //todo javaDoc
 *
 * @author MaZeeT
 */

public interface IMoveControlled extends IMove {

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
