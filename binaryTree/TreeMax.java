/**
 * Finds the maximum value of a given binary tree.
 * Created on 26/12/2016.
 */
class Tree {
    public int data;
    public Tree left;
    public Tree right;
    public Tree(int rootData) {
        this.data = rootData;
    }

    static int max(Tree root) { // For the min. value we flip the comparison operators
        int max = root.data;
        if (root.left != null)
            max = max(root.left) > max ? max(root.left) : max;
        if (root.right != null)
            max = max(root.right) > max ? max(root.right) : max;
        return max;
    }
}
public class TreeMax {
    public static void main(String args[]){
        Tree t1 = new Tree(2);
        Tree t2 = new Tree(-3);
        Tree t3 = new Tree(9);
        Tree t5 = new Tree(10);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;

        System.out.println(Tree.max(t1));
        // Outputs 10
    }
}
