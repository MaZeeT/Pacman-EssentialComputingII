package DataStructures;

import java.util.ArrayList;
import java.util.List;

//TODO write javaDoc
public abstract class DataStructure<T> {
    private List<T> visitedList = new ArrayList<>();

    public boolean contains(T item) {
        return visitedList.contains(item);
    }

    public void add(T item) {
        if (!contains(item)) {
            visitedList.add(item);
            adding(item);
        }
    }

    public T checkNext() {
        if (!isEmpty()) {
            return check();
        } else {
            return null;
        }
    }

    public T getNext() {
        if (!isEmpty()) {
            return next();
        } else {
            return null;
        }
    }

    abstract void adding(T item);

    abstract T check();

    abstract T next();

    abstract boolean isEmpty();

}
