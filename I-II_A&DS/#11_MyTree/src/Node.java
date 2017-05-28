import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihail on 22.05.2017.
 */
public class Node<T> {

    private T data;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void addChild(Node<T> node) {
        children.add(node);
    }

    public List<Node<T>> getChildren() {
        return  children;
    }
}
