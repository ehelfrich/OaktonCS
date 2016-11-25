
public class Driver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

		System.out.println("Find the Root of an UNBALANCED Binary Search Tree (BST)\n"
				+ "the getRoot() method returns a reference to the root of the BST");

		System.out.println("BST with 3 integers added in the order (0, 5, 2)");
		bst.add(0);
		bst.add(5);
		bst.add(2);

		int root;
		root = bst.getRoot().getInfo();
		System.out.println("The root of this tree is: " + root + "\nThe tree printed wiht INORDER traversal is: ");
		int element;
		bst.reset(BinarySearchTree.INORDER);
		for (int i = 0; i < 3; ++i) {
			element = bst.getNext(BinarySearchTree.INORDER);
			System.out.println(element);
		}

		BinarySearchTree<Integer> Newbst = new BinarySearchTree<Integer>();
		System.out.println("\n\nThe root of a BST with no elements is: ");
		try {
			root = Newbst.getRoot().getInfo();
		}
		catch (NullPointerException e) {
			System.out.println("Error: The root of the BST has a null value"
					+ "\n...This error is a success if (null) was the intended outcome");
		}
	}

}
