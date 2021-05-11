package bean;

/**
 * @author 24412
 */
public class MyQueue<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int maxSize;
    private int size = 0;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(T ele) throws Exception {
        Node<T> node = new Node<>(ele);
        if (size == maxSize){
            throw new Exception("容量已满");
        }
        if (size == 0){
            head = node;
            tail = node;
        }else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public T pop() throws Exception {
        if(size == 0){
            throw new Exception("没有元素");
        }
        T val = head.getVal();
        head = head.getNext();
        size--;
        return val;
    }


    public static void main(String[] args) throws Exception {
        MyQueue<String> queue = new MyQueue<>(10);
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.push("d");
        queue.push("e");
        queue.push("f");
        queue.push("g");
        queue.push("h");

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
