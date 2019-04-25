package DataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to define a general way to store elements in {@link MyStack} or {@link MyQueue}.
 *
 * @param <T> The element that needs to be stored.
 * @author MaZeeT
 */
public abstract class DataStructure<T> {
    private List<T> visitedList = new ArrayList<>();

    /**
     * Check to see if the given element is contained in this {@link java.util.Collection}.
     *
     * @param item The item that needs to be check against the {@link java.util.Collection}.
     * @return Returns true if the item is in the {@link java.util.Collection}, and false if not.
     */
    public boolean contains(T item) {
        return visitedList.contains(item);
    }

    /**
     * The generic implementation of the add method. It will add the given element to the {@link java.util.Collection}.
     * This method relies on the abstract method adding in this abstract class to function properly.
     *
     * @param item The given element to the {@link java.util.Collection}.
     */
    public void add(T item) {
        if (!contains(item)) {
            visitedList.add(item);
            adding(item);
        }
    }

    /**
     * The generic implementation of the checkNext method. It will return the next element and keep it in the {@link java.util.Collection}.
     * This method relies on the abstract method check() in this abstract class to function properly.
     *
     * @return Return the next element in the {@link java.util.Collection} and remove it from the {@link java.util.Collection}.
     */
    public T checkNext() {
        if (isEmpty()) {
            return null;
        } else {
            return check();
        }
    }

    /**
     * The generic implementation of the getNext method. It will return the next element and removes it from the {@link java.util.Collection}.
     * This method relies on the abstract method next() in this abstract class to function properly.
     *
     * @return Return the next element in the {@link java.util.Collection} and remove it from the {@link java.util.Collection}.
     */
    public T getNext() {
        if (isEmpty()) {
            return null;
        } else {
            return next();
        }
    }

    /**
     * This method i used to add a new element to the implemented {@link java.util.Collection}.
     *
     * @param item Add the given element to the {@link java.util.Collection}.
     */
    abstract void adding(T item);

    /**
     * This method is used to get the next element from the implemented {@link java.util.Collection} without removing it as the next element.
     *
     * @return Return the next element from the {@link java.util.Collection}.
     */
    abstract T check();

    /**
     * This method is used to get the next element from the implemented {@link java.util.Collection} and removing it as the next element.
     *
     * @return Return the next element from the {@link java.util.Collection}.
     */
    abstract T next();

    /**
     * This method is used to implement a boolean return to see if the {@link java.util.Collection} is empty or not.
     *
     * @return Return true if the {@link java.util.Collection} is empty, and false if not.
     */
    public abstract boolean isEmpty();

    /**
     * Used to print the contents of the {@link DataStructure}.
     *
     * @return Returns the contents as a string.
     */
    public abstract String toString();
}
