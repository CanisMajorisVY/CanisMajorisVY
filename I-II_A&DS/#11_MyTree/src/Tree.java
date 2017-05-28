import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mihail on 22.05.2017.
 */

public class Tree<T> {

    private Node<T> root;

    public Tree(Node<T> node) {
        root = node;
    }

    public Tree(){
        root = new Node<T>(null, null);
    }

    public void setRoot(Node<T> node) {
        root = node;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void addNode(T data, T parentData) {
        Node<T> parentNode = findNodeDepth(parentData);
        if(parentNode != null) {
            parentNode.addChild(new Node<T>(data, parentNode));
        }
    }

    public void addNode(T data) {
        if (root == null) {
            root = new Node<T>(data, null);
        }
    }

    public Node<T> findNodeDepth(T data) {
        if(data.equals(root.getData())){
            return root;
        } else {
            return findNodeDepth(data, root);
        }
    }

    private Node<T> findNodeDepth(T data, Node<T> node) {
        List<Node<T>> chList = node.getChildren();
        Iterator<Node<T>> iterator = chList.iterator();
        while (iterator.hasNext()) {
            Node<T> nextNode = iterator.next();
            if(nextNode.getData().equals(data)){
                return nextNode;
            } else {
                return findNodeDepth(data, nextNode);
            }
        }
        return null;
    }

}
