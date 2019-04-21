package WorkInProgress;

import WorkInProgress.Nodes.Node;
import WorkInProgress.Nodes.SimpleNode;

//TODO implement a tree
//TODO Make a shortest route algorithm based on a tree.
public class Tree<T> {

    //NodeX<T> root = new NodeX<>();
    //SimpleNode<T> root;
    private Node<T> root;


    public void add(T item) {
        if (root == null) {
            root = new Node<T>(item, null);
        } else {
            //add childNode.to.arrayOfNodes
            //node.addNode(item,null)
        }

        //new SimpleNode<T>(item,null);
    }

}
