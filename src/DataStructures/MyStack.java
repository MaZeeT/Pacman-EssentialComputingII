package DataStructures;

import Components.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyStack<T> {
    List<T> visitedList = new ArrayList<>();
    Stack<T> stack = new Stack<>();

    public boolean contains(T item) {
        return visitedList.contains(item);
    }

    public void add(T item) {
        if (!contains(item)) {
            visitedList.add(item);
            stack.push(item);
        }
    }

    public T checkNext() {
        if (!stack.empty()) {
            return stack.peek();
        } else {
            return null;
        }
    }

    public T getNext() {
        if (!stack.empty()) {
            return stack.pop();
        } else {
            return null;
        }
    }

}
