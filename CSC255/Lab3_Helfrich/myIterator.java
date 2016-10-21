
/*
 * Custom Iterator Class that iterates through the TreeSet
 * Does not support the remove method
 */
import java.util.Iterator;
import java.util.Stack;

public class myIterator<AnyType extends Comparable<? super AnyType>> implements Iterator<AnyType> {

	Stack<BinaryNode<AnyType>> stack;
	BinaryNode<AnyType> currNode;
	BinaryNode<AnyType> printNode;

	public myIterator(BinaryNode<AnyType> root) {
		stack = new Stack<BinaryNode<AnyType>>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	@Override
	public boolean hasNext() {
		if (!stack.empty()) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public AnyType next() {
		currNode = stack.pop();
		printNode = currNode;
		if (currNode.right != null) {
			currNode = currNode.right;
			while (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			}
		}
		return printNode.element;
	}
}
