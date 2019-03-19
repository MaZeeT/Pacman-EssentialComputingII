package SnakeDataStructures;

import SnakeComponents.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TODO write javaDoc
public class BreadthFirst implements IDataStructure {
    private Queue<Position> queue = new LinkedList<>();
    private List<Position> visitedList = new ArrayList<>();

    public boolean contains(Position position) {
        for (Position pos : visitedList) {
            if (pos.compareTo(position) == 0) return true;
        }
        return false;
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
