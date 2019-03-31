package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The purpose of this class is to implement a {@link java.util.Collection} as a {@link Queue}
 * with a common superclass shared with a implementation of a {@link java.util.Stack}.
 *
 * @param <T> The type which the {@link Queue} should contain.
 * @author MaZeeT
 */
class MyQueue<T> extends DataStructure<T> {
    private Queue<T> queue = new LinkedList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    void adding(T item) {
        queue.offer(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    T check() {
        return queue.peek();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    T next() {
        return queue.poll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    boolean isEmpty() {
        return queue.isEmpty();
    }

}
