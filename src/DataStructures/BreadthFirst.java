package DataStructures;

import Components.Position;

import java.util.LinkedList;
import java.util.Queue;

//TODO write javaDoc AND make generic by replacing Position with T
public class BreadthFirst extends DataStructure {
    private Queue<Position> queue = new LinkedList<>();

    @Override
    void adding(Position pos) {
        queue.offer(pos);
    }

    @Override
    Position check() {
        return queue.peek();
    }

    @Override
    Position next() {
        return queue.poll();
    }

    @Override
    boolean isEmpty() {
        return queue.isEmpty();
    }

}
