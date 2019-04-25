package WorkInProgress.ShortestTree;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of this class is to provide a tree structure to store generic types in,
 * where the parent of a given item is specified when added.
 *
 * @param <T> The generic type the {@link Tree} should store.
 * @author MaZeeT
 */
public class Tree<T> {

    private Node<T> root;
    private int size;

    /**
     * Checks if the specified item is present in the {@link Tree}, result is returned as a boolean.
     *
     * @param item The item that is checked if present in the {@link Tree}.
     * @return Returns true if the item is present in the {@link Tree}, and false if not.
     */
    public boolean contain(T item) {
        if (root != null) {
            return find(item, root) != null;
        } else {
            return false;
        }
    }

    /**
     * Find a {@link Node} in the {@link Tree} that contains a specified item. If successful returns the {@link Node},
     * else returns null.
     *
     * @param item   The item that are being checked if present in the {@link Tree}
     * @param parent The {@link Node} where the search should start from.
     * @return Returns the {@link Node} containing the given item if present, if not returns null.
     */
    private Node<T> find(T item, Node<T> parent) {
        if (parent.contain.equals(item)) {
            return parent;
        } else {
            if (parent.children != null) {
                for (Node<T> child : parent.children) {
                    Node<T> rtn = find(item, child);
                    if (rtn != null) {
                        return rtn;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Add an item without a parent. Only work properly on first call since it will become the root {@link Node}.
     *
     * @param item The item that should be added to the {@link Tree}.
     * @return Returns true if the item is added and false if not.
     */
    public boolean add(T item) {
        return add(null, item);
    }

    /**
     * Adds an item to the tree, attached as a child to the specified parentItem.
     *
     * @param parentItem The parent which the child should be attached to.
     * @param childItem  The item that should be stored in the child {@link Node}.
     * @return Returns true if the item is added.
     * Returns false if the item is not added since the item is already present in the {@link Tree}.
     */
    public boolean add(T parentItem, T childItem) {
        if (root == null) {
            root = new Node<>(childItem, null);
            size++;
            return true;
        }
        // adds the childItem if it isn't already in the tree.
        if (!contain(childItem)) {
            Node<T> parent = find(parentItem, root);
            if (parent != null) {
                Node<T> child = new Node<>(childItem, parent);
                parent.addChild(child);
                size++;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns how many items have been added to the tree.
     *
     * @return Return the amount of items being added to the tree in total.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns a list of all parents included the {@link Node} which contains the specified generic item.
     * The list starts with {@link Node} of the specified item, and continues with the parents until
     * the root {@link Node} of the {@link Tree} is reached.
     *
     * @param item The generic item that specify where in the tree to start returning {@link Node}s from.
     * @return Return a list of generic items with the specified item as the first item and the root item as the last.
     */
    public List<T> getAllParents(T item) {
        List<T> list = new ArrayList<>();
        Node<T> child = find(item, root);
        if (child != null) {
            boolean getNextParent = true;
            while (getNextParent) {
                list.add(child.contain);
                if (child.parent != null) {
                    child = child.parent;
                } else {
                    getNextParent = false;
                }
            }
        }
        return list;
    }

}


/**
 * The purpose of this inner class is to provides inner objects for the {@link Tree} to attach generics to.
 *
 * @param <T> The generics objects that need to be linked with a given {@link Node}.
 * @author MaZeeT
 */
class Node<T> {
    T contain;
    Node<T> parent;
    List<Node<T>> children;

    /**
     * Constructor for a {@link Node} in the {@link Tree}.
     *
     * @param contain The item the {@link Node} need to hold.
     * @param parent  The parent {@link Node} of the instantiated {@link Node}.
     */
    Node(T contain, Node<T> parent) {
        this.contain = contain;
        this.parent = parent;
        children = new ArrayList<>();
    }

    /**
     * Adds a child {@link Node} to the parent's list of children and set the parent as the child {@link Node}'s parent.
     *
     * @param child The child that will be added to the parent {@link Node}.
     */
    void addChild(Node<T> child) {
        this.children.add(child);
        child.parent = this;
    }

}
