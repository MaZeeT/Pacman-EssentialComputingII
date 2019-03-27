package DataStructures;

import Components.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class DataStructure implements IDataStructure {
    List<Position> visitedList = new ArrayList<>();

    public boolean contains(Position item) {
        return visitedList.contains(item);
    }

    public void add(Position item) {
        if (!contains(item)) {
            visitedList.add(item);
            adding(item);
        }
    }

    public Position checkNext() {
        if (!isEmpty()) {
            return check();
        } else {
            return null;
        }
    }

    public Position getNext() {
        if (!isEmpty()) {
            return next();
        } else {
            return null;
        }
    }

    abstract void adding(Position item);

    abstract Position check();

    abstract Position next();

    abstract boolean isEmpty();

}
