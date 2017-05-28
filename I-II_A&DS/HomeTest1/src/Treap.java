import java.util.Random;

/**
 * Created by Mihail on 23.05.2017.
 */

public class Treap {
    private int value;
    private int priority;

    private Treap left;
    private Treap right;

    public Treap() {

    }

    private Treap(int x, int y) {
        this.value = x;
        this.priority = y;
        this.left = null;
        this.right = null;
    }

    private Treap(int x, int y, Treap left, Treap right) {
        this.value = x;
        this.priority = y;
        this.left = left;
        this.right = right;
    }

    public static Treap merge(Treap left, Treap right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.priority > right.priority) {
            Treap newR = merge(left.right, right);
            return new Treap(left.value, left.priority, left.left, newR);
        } else {
            Treap newL = merge(left, right.left);
            return new Treap(right.value, right.priority, newL, right.right);
        }
    }

    public Treap[] split(int x, Treap left, Treap right) {
        Treap newTree = null;
        if (this.value <= x) {
            if (this.right == null)
                right = null;
            else
                this.right.split(x, newTree, right);
            left = new Treap(this.value, priority, this.left, newTree);
        } else {
            if (this.left == null)
                left = null;
            else
                this.left.split(x, left, newTree);
            right = new Treap(this.value, priority, newTree, this.right);
        }
        return new Treap[]{left, right};
    }


    public int getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }


    public Treap insert(int x) {
        split(x, this.left, this.right);
        Treap temp = new Treap(x, new Random().nextInt(100));
        return merge(merge(this.left, temp), this.right);
    }

    public Treap remove(int x) {
        split(x - 1, this.left, this.right);
        this.right.split(x, null, right);
        return merge(this.left, this.right);
    }
}