
/*
 * By: Eric Helfrich
 * CSC 251
 * Driver for Question 4.11
 * Implements a TreeSet Class based off of the BinarySearchTree provided by the text book
 * Customized in order to support an addition of an Iterator
 * Iterator is written by me using non-recursive in-line iteration of a tree
 * 
 * The mainly tests the iterator class since this was what I wrote.
 * 
 * I Hope this was what the problem asked since it was vague.
 * 
 */
import java.util.Iterator;

public class Driver {
	//	Test program

	public static void main(String[] args) {
		BinarySearchTree<Integer> t = new BinarySearchTree<>();
		System.out.println("Inserting Numbers 4, 2, 77, 4 and then print the set without Iterator");
		System.out.println("Should not repeat 4 since it is a Set");
		t.insert(4);
		t.insert(2);
		t.insert(77);
		t.insert(4);
		//t.insert(84);
		t.printTree();

		Iterator<Integer> it = t.iterator();
		System.out.println("\nTest to make sure the remove method throws an exception");
		try {
			it.remove();
		}
		catch (UnsupportedOperationException e) {
			System.out.println("Error: This remove operation of the Iterator is not supported\n");
		}

		System.out.println("Print the Tree with the Iterator");
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
