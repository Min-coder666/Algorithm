package function;

import bean.Node;

/**
 * @author Min
 */
public class ListFunction {

    /**
     * 链表的逆置
     * @param node
     * @return
     */
    public static Node change(Node node){
        Node ret = null;
        if (node.getNext().getNext() == null){
            ret = node.getNext();
        }else {
            ret =change(node.getNext());
        }
        node.getNext().setNext(node);
        node.setNext(null);
        return ret;
    }


    public static void main(String[] args) {
        Node<String> node1 = new Node<>();
        Node<String> node2 = new Node<>();
        Node<String> node3 = new Node<>();
        Node<String> node4 = new Node<>();
        Node<String> node5 = new Node<>();
        node1.setVal("a");
        node2.setVal("b");
        node3.setVal("c");
        node4.setVal("d");
        node5.setVal("e");
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        Node ret  = ListFunction.change(node1);
        System.out.println(ret);

    }
}
