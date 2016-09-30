//----------------------------------------------------------------------
// LinkedStack.java         by Dale/Joyce/Weems                Chapter 3
//
// Implements UnboundedStackInterface using a linked list 
// to hold the stack elements.
//-----------------------------------------------------------------------

package ch03.stacks;

import support.LLNode;

public class LinkedStack<T> implements UnboundedStackInterface<T> {
	protected LLNode<T> top; // reference to the top of this stack

	public LinkedStack()

	{
		top = null;
	}

	public void push(T element)

	// Places element at the top of this stack.
	{
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}

	public void pop()

	// Throws StackUnderflowException if this stack is empty,
	// otherwise removes top element from this stack.
	{
		if (!isEmpty()) {
			top = top.getLink();
		} else
			throw new StackUnderflowException("Pop attempted on an empty stack.");
	}

	public T top()

	// Throws StackUnderflowException if this stack is empty,
	// otherwise returns top element from this stack.
	{
		if (!isEmpty())
			return top.getInfo();
		else
			throw new StackUnderflowException("Top attempted on an empty stack.");
	}

	public boolean isEmpty()
	// Returns true if this stack is empty, otherwise returns false.
	{
		if (top == null)
			return true;
		else
			return false;
	}

	@Override
	// ToDo #42
	public String toString() {
		LLNode<T> present = top;
		String infoStr = " ";
		if (present != null) {
			while (present.getLink() != null) {
				infoStr += present.getInfo() + " ";
				present = present.getLink();
			}
			infoStr += present.getInfo();
		} else
			infoStr = "Stack is empty";
		return infoStr;
	}

	// ToDo #46b "walk"
	public int sizeIs() {
		int sizeCount = 0;
		LLNode<T> present = top;
		if (present != null) {
			while (present.getLink() != null) {
				sizeCount++;
				present = present.getLink();
			}
			sizeCount++; // for last node
		} else {
			sizeCount = 0;
		}
		return sizeCount;
	}
}
