package Lab7;

public class SearchTreeTest {

    public static void main (String[] args) {
        SearchTreeManage tree = new SearchTreeManage(); //make a new tree

        tree.add(10); //adding to the BST
        tree.add(5);
        tree.add(50);
        tree.add(2);
        tree.add(40);
        tree.add(15);
        tree.add(17);
        tree.add(78);
        tree.add(1);
        tree.add(1);
        tree.add(7);
        tree.printInOrder(); //prints out as is
        tree.search(1); //is 1 in the BST?
        tree.remove(5); //remove this number
        tree.remove(2);
        tree.remove(10);
        tree.add(4); //adds 4 in
        tree.printPreOrder(); //prints
        tree.printInOrder();
        tree.printPostOrder();
    }

}
