import ch03.stacks.ArrayStack;
import ch03.stacks.BoundedStackInterface;
import ch03.stacks.LinkedStack;
import ch03.stacks.UnboundedStackInterface;

public class Driver {
	public static void main(String[] args)

	{ // #42
		System.out.println("#42 implementing method toString() in LinkedStack class");
		UnboundedStackInterface<String> myStack;
		myStack = new LinkedStack<String>();
		myStack.push("A");
		myStack.push("B");
		myStack.push("C");
		System.out.print("MyStack: ");
		System.out.println(myStack);
		myStack.pop();
		System.out.print("MyStack after pop: ");
		System.out.println(myStack);

		UnboundedStackInterface<Integer> myIntegerStack;
		myIntegerStack = new LinkedStack<Integer>();
		myIntegerStack.push(7);
		myIntegerStack.push(9);
		System.out.print("MyIntegerStack: ");
		System.out.println(myIntegerStack);

		UnboundedStackInterface<Integer> myEmptyStack;
		myEmptyStack = new LinkedStack<Integer>();
		System.out.print("MyEmptyStack: ");
		System.out.println(myEmptyStack);
		// #46
		// a.
		System.out.println("#46a.implementing sizeIs() in ArrayStack class and testing in Driver class  ");
		BoundedStackInterface<String> myStackArray;
		myStackArray = new ArrayStack<String>();
		System.out.println("myStackArray size is: " + myStackArray.sizeIs());
		myStackArray.push("A");
		myStackArray.push("B");
		myStackArray.push("C");
		System.out.println("myStackArray after pushing A, B, C, size is: " + myStackArray.sizeIs());
		myStackArray.pop();
		System.out.print("MyStackArray after pop, ");
		System.out.println("size is: " + myStackArray.sizeIs());
		System.out.println("46c.implementing sizeIs() in LinkedStack class and testing in Driver (return size)");
		UnboundedStackInterface<String> myStack2;
		myStack2 = new LinkedStack<String>();
		System.out.println("Just after creation myStack2 size is: " + myStack2.sizeIs());
		myStack2.push("D");
		myStack2.push("F");
		myStack2.push("G");
		System.out.print("MyStack2: ");
		System.out.println(myStack2);
		System.out.println("myStack2 size is: " + myStack2.sizeIs());
		myStack2.pop();
		System.out.print("MyStack2 after pop: ");
		System.out.println(myStack2);
		System.out.println("myStack2 size is: " + myStack2.sizeIs());
	}
}
