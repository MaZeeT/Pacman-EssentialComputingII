package WorkInProgress;

import WorkInProgress.Nodes.Node;
import WorkInProgress.Nodes.Node2;
import WorkInProgress.Nodes.SimpleNode;

//TODO implement a tree
//TODO Make a shortest route algorithm based on a tree.
public class Tree<T> {
    //NodeX<T> root = new NodeX<>();

    SimpleNode<T> root;
    Node<T> node;


    public void add(T item){
        if (node == null){
            node = new Node2<>(item,null);
        }else {
            //add childNode.to.arrayOfNodes
            //node.addNode(item,null)
        }

        //new SimpleNode<T>(item,null);
    }

}
