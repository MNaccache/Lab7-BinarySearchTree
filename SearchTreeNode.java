package Lab7;

public class SearchTreeNode {
    protected int data;
    protected SearchTreeNode left;
    protected SearchTreeNode right;

    protected SearchTreeNode (int data) { //make a new node
        this.data = data;
        this.left = null;
        this.right = null;
    }

    protected SearchTreeNode (int data, SearchTreeNode left, SearchTreeNode right) { //makes a new node with all the information
        this.data = data;
        this.left = left;
        this.right = right;
    }

}
