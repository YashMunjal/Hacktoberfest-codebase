import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class CheckBST {
    boolean checkBST(Node root) {
        int l = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrder(root, list);
        for (int n : list) {
            if (n > l)
                l = n;
            else
                return false;
        }
        return true;
    }

    void inOrder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);

    }
}
