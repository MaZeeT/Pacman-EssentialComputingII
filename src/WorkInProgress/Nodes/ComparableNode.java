package WorkInProgress.Nodes;

public class ComparableNode<T extends Comparable> extends Node<T> implements Comparable<ComparableNode<T>> {

    public ComparableNode(T contain, Node<T> parent) {
        super(contain, parent);
    }

    @Override
    public int compareTo(ComparableNode<T> other) {
            return this.contain.compareTo(other.contain);
    }

    @Override
    public boolean equals(Object obj) {
        try {
            ComparableNode<T> other = (ComparableNode<T>) obj;
            return (contain == other.contain);
        }catch (ClassCastException e){
            return false;
        }

    }

    @Override
    public int hashCode() {
        return contain.hashCode();
    }

}
