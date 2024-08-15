package Lab7;

import java.util.NoSuchElementException;

public class SearchTreeManage {
    private SearchTreeNode overallRoot; //base/first node of the BST

    public void add (int value) { //adds one
        overallRoot = add(overallRoot, value); //change the old tree into the new one
    }

    private SearchTreeNode add (SearchTreeNode root, int value) { //recursivly goes down the tree until it hits wherever it goes
        if (root == null) { //if you're at the end of a line, put the number here
            root = new SearchTreeNode(value);
        } else if (root.data > value) { //if the value is more than the current data, go into the left branch
            root.left = add(root.left, value);
        } else if (root.data < value) { //if the value if less than the current data, go into the right branch
            root.right = add(root.right, value);
        }

        return root; //give back the new BST
    }

    public void remove (int value) { //removes one 
        overallRoot = remove(overallRoot, value); //change the old tree into the new one
    }

    private SearchTreeNode remove (SearchTreeNode root, int value) {
        if (root == null) { //if it doesn't exist do nothing
            return null;
        } else if (root.data > value) { //goes down to where the value is
            root.left = remove(root.left, value);
        } else if (root.data < value) { //goes down to where the value is
            root.right = remove(root.right, value);
        } else { //this is just if root.data == value, removes this one
            if (root.right == null) {
                return root.left; //if it only has one child, just replace with that child
            } else if (root.left == null) {
                return root.right;
            } else { //if it has two children, replace with the minimum from the right branch
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            }
        }

        return root;
    }

    public void search (int value) { //sets up the search
        if (search(overallRoot, value)) { //if it is in the tree
            System.out.println(value + " is in the tree");
        } else { //if it isn't
            System.out.println(value + "is not in the tree");
        }
    }

    public boolean search (SearchTreeNode root, int value) { //recursivly looks through the tree for the number
        if (root.data == value) { //oh, this node it the number
            return true;
        } else if (root.data < value) { //we're not there yet, so go down the tree
            return search(root.right, value);
        } else if (root.data > value) {
            return search(root.left , value);
        } else { //root == null, this number doesn't exist in this tree
            return false;
        }
    }

    public int getMin () { //sets up to get the minimum value in the tree
        if (overallRoot == null) {
            throw new NoSuchElementException();
        }
        return getMin(overallRoot);
    }

    private int getMin (SearchTreeNode root) { //get the minimum value recursivly
        if (root.left == null) { //if you can't go left, just return the current node's data
            return root.data;
        } else {
            return getMin(root.left); //go left until you can't anymore
        }
    }

    public void printPreOrder () { //sets it up to prints in pre-order
        System.out.print("Pre-Order: ");
        printPreOrder(overallRoot);
        System.out.println();
    }

    private void printPreOrder (SearchTreeNode root) { //prints the tree itself in pre-order recursivly
        if (root != null) { //if node isn't empty
            System.out.print(root.data + " "); //prints the current node
            printPreOrder(root.left); //goes down into the left node and does this all again
            printPreOrder(root.right); //goes down into the right node and does this all again
        }
    }

    public void printInOrder () { //sets up to print in order
        System.out.print("In-Order: ");
        printInOrder(overallRoot);
        System.out.println();
    }

    private void printInOrder (SearchTreeNode root) { //prints the tree itself in order recursivly
        if (root != null) {
            printInOrder(root.left); //goes down into the left node and does this all again
            System.out.print(root.data + " "); //prints the current node
            printInOrder(root.right); //goes down into the right node and does this all again
        }
    }

    public void printPostOrder () { //sets up to print in post order
        System.out.print("Post-Order: ");
        printPostOrder(overallRoot);
        System.out.println();
    }

    private void printPostOrder (SearchTreeNode root) { //prints the tree itself in post order recursivly
        if (root != null) {
            printPostOrder(root.left); //goes down into the left node and does this all again
            printPostOrder(root.right); //goes down into the right node and does this all again
            System.out.print(root.data + " "); //prints the current node
        }
    }

}
