package Movement;

/**
 * //todo javaDoc
 *
 * @author MaZeeT
 */

public interface IMoverControlled extends IMover {

    /**
     * Sets the direction the next update should be in.
     *
     * @param direction The direction the next update should be given as a char.
     */
    void setDirection(char direction);

    /**
     * Gets the direction the next update will be taken towards.
     *
     * @return Returns the direction the next update will be taken towards.
     */
    char getDirection();
}
