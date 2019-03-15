package SnakeDataStructures;

import SnakeComponents.Position;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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
        return queue.peek();
    }

    public Position getNext() {
        return queue.poll();
    }

}
