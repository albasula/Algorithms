/**
 * Gives the height of a presented binary tree.
 * Created on 06/01/2017.
 */
class Tree {
    public String data;
    public Tree left;
    public Tree right;
    public Tree(String rootData) {
        this.data=rootData;
    }

    static int height(Tree root) {
        if (root==null)
            return 0;
        else
            return height(root.left)>height(root.right)? 1+height(root.left): 1+height(root.right);
    }
}
public class TreeHeight {
    public static void main(String args[]) {
        Tree t1 = new Tree("2");
        Tree t2 = new Tree("3");
        Tree t3 = new Tree("7");
        t1.left = t2;
        t1.right = t3;

        System.out.println(Tree.height(t1)); // We can subtract 1 here or not depending if we want the height defined as n-1 or n
        // Outputs 2
    }
}
