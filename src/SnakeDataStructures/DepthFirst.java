package SnakeDataStructures;

import SnakeComponents.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirst implements IDataStructure {
    private Stack<Position> stack = new Stack<>();
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
            stack.push(position);
        }
    }

    public Position checkNext() {
        return stack.peek();
    }

    public Position getNext() {
        return stack.pop();
    }

}
