package bean;

/**
 * @author 24412
 */
public class MyStack<T> {

    private T[] data;
    private int top = 0;
    public MyStack(int size){
        data = (T[]) new Object[size];
    }

    public void push(T ele) throws Exception {
        if (top == data.length){
            throw new Exception("容量已满 top="+top);
        }
        this.data[top++] = ele;
    }

    public T pop() throws Exception {
        if (top == 0){
            throw new Exception("没有元素");
        }
        top--;
        return data[top];
    }

    public static void main(String[] args) throws Exception {
        MyStack<String> stack = new MyStack<>(10);
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
