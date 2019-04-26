package DataStructures;

import java.util.Stack;

/**
 * The purpose of this class is to implement a {@link java.util.Collection} as a {@link Stack}
 * with a common superclass shared with a implementation of a {@link java.util.Queue}.
 *
 * @param <T> The type which the {@link Stack} should contain.
 * @author MaZeeT
 */
public class MyStack<T> extends DataStructure<T> {
    private Stack<T> stack = new Stack<>();

    /**
     * {@inheritDoc}
     */
    @Override
    void adding(T item) {
        stack.push(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    T check() {
        return stack.peek();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    T next() {
        return stack.pop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return stack.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return stack.toString();
    }

}
