package DataStructures;

import java.util.Stack;


//TODO write javaDoc
class MyStack<T> extends DataStructure<T> {
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

    @Override
    T next() {
        return stack.pop();
    }

    @Override
    boolean isEmpty() {
        return stack.empty();
    }

}
