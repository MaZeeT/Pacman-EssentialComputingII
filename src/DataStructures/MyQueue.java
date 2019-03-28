package DataStructures;

import java.util.LinkedList;
import java.util.Queue;

//TODO write javaDoc
class MyQueue<T> extends DataStructure<T> {
    private Queue<T> queue = new LinkedList<>();

    @Override
    void adding(T item) {
        queue.offer(item);
    }

    @Override
    T check() {
        return queue.peek();
    }

    @Override
    T next() {
        return queue.poll();
    }

    @Override
    boolean isEmpty() {
        return queue.isEmpty();
    }

}
