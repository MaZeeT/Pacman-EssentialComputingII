package DataStructures;

import Components.Position;

/**
 * The purpose of this interface is to specify what is needed to be able to at as a dataStructure.
 *
 * @author MaZeeT
 */
public interface IDataStructure {

    /**
     * Checks to see if a given {@link Position} is contained in the dataStructure.
     *
     * @param position The {@link Position} that needs to be checked.
     * @return Returns true if the given {@link Position} is in the dataStructure and false if not.
     */
    boolean contains(Position position);

    /**
     * Add a {@link Position} to the dataStructure.
     *
     * @param position The {@link Position} that should be added.
     */
    void add(Position position);

    /**
     * Get the next {@link Position} and keep it in the dataStructure.
     *
     * @return Returns the next {@link Position}.
     */
    Position checkNext();

    /**
     * Get the next {@link Position} and remove it from the dataStructure.
     *
     * @return Returns the next {@link Position}.
     */
    Position getNext();

}
