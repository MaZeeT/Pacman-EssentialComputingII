package SnakeDataStructures;

import SnakeComponents.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO write javaDoc AND make generic by replacing Position with T
public class BreadthFirst implements IDataStructure {
    private Queue<Position> queue = new LinkedList<>();
    private List<Position> visitedList = new ArrayList<>();

    public boolean contains(Position position) {
        return visitedList.contains(position);
    }

    public void add(Position position) {
        if (!contains(position)) {
            visitedList.add(position);
            queue.offer(position);
        }
    }

    public Position checkNext() {
        if (!queue.isEmpty()) {
            return queue.peek();
        } else {
            return null;
        }
    }

    public Position getNext() {
        if (!queue.isEmpty()) {
            return queue.poll();
        } else {
            return null;
        }
    }

}
