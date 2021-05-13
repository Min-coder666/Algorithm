package function;

import bean.Node;

import java.util.Arrays;

/**
 * @author 24412
 */
public class TreeFunction {

    /**
    * 前序遍历和中序遍历还原二叉树
    * 传入数组符合要求(非空，且长度相同)
    * */
    public static Node fmToTree(int[] firstArr,int[] midArr){
        if (firstArr == null || firstArr.length == 0) {
            return null;
        }
        int firstRootVal = firstArr[0];
        Node ret = new Node(firstRootVal);
            int index = 0;
            for (int i = 0; i < midArr.length; i++) {
                if (midArr[i] == firstRootVal){
                    index = i;
                    break;
                }
            }
            int[] newFirstArr = Arrays.copyOfRange(firstArr,1,index+1);
            int[] newMidArr = Arrays.copyOfRange(midArr,0,index);
            ret.setLeft(fmToTree(newFirstArr,newMidArr));
            int[] newFirstArr1 = Arrays.copyOfRange(firstArr,index+1,firstArr.length);
            int[] newMidArr1 = Arrays.copyOfRange(midArr,index+1,midArr.length);
            ret.setRight(fmToTree(newFirstArr1,newMidArr1));


        return ret;

    }


    public static void firstRoot(Node root){
        if (root == null) {
            return;
        }
        System.out.println(root.getVal());
        firstRoot(root.getLeft());
        firstRoot(root.getRight());
    }

    public static void midRoot(Node root){
        if (root == null) {
            return;
        }
        midRoot(root.getLeft());
        System.out.println(root.getVal());
        midRoot(root.getRight());
    }

    public static void lastRoot(Node root){
        if (root == null) {
            return;
        }
        lastRoot(root.getLeft());
        lastRoot(root.getRight());
        System.out.println(root.getVal());
    }


    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(5);
        Node n3 = new Node(1);
        Node n4 = new Node(7);
        Node n5 = new Node(9);
        Node n6 = new Node(12);
        Node n7 = new Node(8);

        n2.setLeft(n4);
        n2.setRight(n1);
        n4.setLeft(n3);
        n4.setRight(n6);
        n1.setLeft(n5);
        n1.setRight(n7);


        int[] first = new int[]{5,7,1,12,6,9,8};
        int[] mid = new int[]{1,7,12,5,9,6,8};
        Node ret = fmToTree(first,mid);
        firstRoot(ret);
    }
}
