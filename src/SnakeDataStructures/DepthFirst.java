package SnakeDataStructures;

import SnakeComponents.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO write javaDoc AND make generic by replacing Position with T
public class DepthFirst implements IDataStructure {
    private Stack<Position> stack = new Stack<>();
    private List<Position> visitedList = new ArrayList<>();

    public boolean contains(Position position) {
        return visitedList.contains(position);
    }

    public void add(Position position) {
        if (!contains(position)) {
            visitedList.add(position);
            stack.push(position);
        }
    }

    public Position checkNext() {
        if (!stack.empty()) {
            return stack.peek();
        } else {
            return null;
        }
    }

    public Position getNext() {
        if  (!stack.empty()){
            return stack.pop();
        }else{
            return null;
        }
    }

}
