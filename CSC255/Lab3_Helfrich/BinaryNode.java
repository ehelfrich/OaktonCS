/*
 * The BinaryNode Class removed from the BinarySearchTree class
 * Extra information added to the BinaryNode in order to hold information of the parent Node
 */

public class BinaryNode<AnyType extends Comparable<? super AnyType>> {
	// Constructors
	BinaryNode(AnyType theElement) {
		this(theElement, null, null, null);
	}

	BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt, BinaryNode<AnyType> parentNode) {
		element = theElement;
		left = lt;
		right = rt;
		parent = parentNode;
	}

	AnyType element; // The data in the node
	BinaryNode<AnyType> left; // Left child
	BinaryNode<AnyType> right; // Right child
	BinaryNode<AnyType> parent;// Parent of the Node
}
