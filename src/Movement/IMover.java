package Movement;

/**
 * The purpose of this interface is to define a common way to implement different ways
 * to move different {@link Entities.MovableEntity} in the program
 *
 * @author MaZeeT
 */
public interface IMover {

    /**
     * This will perform a single movement for each call.
     */
    void move();

}
