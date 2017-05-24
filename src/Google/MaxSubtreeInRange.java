package Google;

/**
 * Created by shiyanch on 11/21/16.
 */
class Node {
    Node left;
    Node right;
    int val;
    public Node(int val) {
        this.val = val;
    }
}

public class MaxSubtreeInRange {
    private int maxSize = 0;

    public int getSubTreeSize(Node root, int left, int right) {
        maxSize = 0;
        helper(root, left, right);
        return maxSize;
    }

    public int helper(Node root, int left, int right) {
        if (root == null) {
            return 0;
        }

        int leftVal = helper(root.left, left, right);
        int rightVal = helper(root.right, left, right);

        if(root.val < left || root.val > right) {
            return -1;
        }

        if (leftVal != -1 && rightVal != -1) {
            int subTreeSize = 1 + leftVal + rightVal;
            maxSize = Math.max(maxSize, subTreeSize);
            return subTreeSize;
        }

        return -1;
    }



    public static void main(String[] args) {
        Node root = new Node(10);
        Node a = new Node(4);
        Node b = new Node(15);
        Node c = new Node(2);
        Node d = new Node(6);
        Node e = new Node(13);
        Node f = new Node(20);
        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.right = f;

        MaxSubtreeInRange myRange = new MaxSubtreeInRange();
        myRange.getSubTreeSize(root, 2,16);
        System.out.println(myRange.maxSize);
    }
}
