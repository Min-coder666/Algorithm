package bean;

/**
 * @author Min
 */
public class Node<T> {

    private T val;
    private Node next;

    public Node() {
    }

    public Node(T val, Node next) {
        this.val = val;
        this.next = next;
    }

    public Node(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
