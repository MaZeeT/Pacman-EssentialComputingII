package DataStructures;

import Components.Position;

import java.util.Stack;

//TODO write javaDoc AND make generic by replacing Position with T
public class DepthFirst extends DataStructure {
    private Stack<Position> stack = new Stack<>();

    @Override
    void adding(Position pos) {
        stack.push(pos);
    }

    @Override
    Position check() {
        return stack.peek();
    }

    @Override
    Position next() {
        return stack.pop();
    }

    @Override
    boolean isEmpty() {
        return stack.empty();
    }

}
