package function;

import bean.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 24412
 */
public class TreeFunction {

    /**
     * 二叉树的比较 (如果左右互换可以的话)
    * */
    public static boolean compareTree(Node node1,Node node2){
        if (node1==null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null){
            return false;
        }
        if (node1.getVal() != node2.getVal()) {
            return false;
        }
        return compareTree(node1.getLeft(),node2.getLeft())&&compareTree(node1.getRight(),node2.getRight());
    }
    /**
     * 二叉树深度优先搜索
    * */
    public static boolean dfs(Node root, int target){
        if (root == null) {
            return false;
        }
        if (root.getVal() == target) {
            return true;
        }
        return dfs(root.getLeft(),target) || dfs(root.getRight(),target);
    }

    /**
     * 二叉树广度优先搜索
    * */
    public static boolean bfs(Node root, int target){
        if (root == null) {
            return false;
        }
        if (root.getVal() == target) {
            return true;
        }
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(root);
        return bfs(nodeList,target);
    }

    private static boolean bfs(List<Node> nodes, int target){
        if (nodes.size()==0){
            return false;
        }
        List<Node> children = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            if (n.getVal() == target) {
                return true;
            }
            if (n.getLeft() != null) {
                children.add(n.getLeft());
            }
            if (n.getRight() != null) {
                children.add(n.getRight());
            }
        }
        return bfs(children,target);
    }



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

    /**
     * 三种遍历 前序 中序 后序
     * */
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

        Node na = new Node(6);
        Node nb = new Node(5);
        Node nc = new Node(1);
        Node nd = new Node(7);
        Node ne = new Node(9);
        Node nf = new Node(12);
        Node ng = new Node(8);
        Node nh = new Node(11);

        nb.setLeft(nd);
        nb.setRight(na);
        nd.setLeft(nc);
        nd.setRight(nf);
        na.setLeft(ne);
        na.setRight(ng);
        ng.setRight(nh);


//        System.out.println(dfs(n2,9));
//        System.out.println(bfs(n2,11));
        System.out.println(compareTree(nb,n2));
//        int[] first = new int[]{5,7,1,12,6,9,8};
////        int[] mid = new int[]{1,7,12,5,9,6,8};
////        Node ret = fmToTree(first,mid);
////        firstRoot(ret);
    }
}
