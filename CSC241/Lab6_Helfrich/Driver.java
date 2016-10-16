
/*
 * Eric Helfrich 
 * Lab 6 CSC 241 
 * Writing and testing the removeAll method for the RefUnsortedList class
 */
import ch06.lists.RefUnsortedList;

public class Driver {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)

	{ // page 469 #51
		System.out.println("page 469 #51 testing removeAll() ");
		RefUnsortedList myList;
		myList = new RefUnsortedList();
		myList.add(3);
		myList.add(4);
		myList.add(3);
		myList.add(5);
		myList.add(3);
		myList.add(6);
		myList.add(3);
		myList.add(3);
		myList.add(7);
		System.out.println("myList: " + myList);
		// myList.removeAll(3);
		System.out.println("Removed " + myList.removeAll(3) + " items from list"); //Makes use of the return int
		System.out.println("myList: " + myList);

		System.out.println("Testing the generic method by adding and using removeAll on Strings");
		RefUnsortedList stringList;
		stringList = new RefUnsortedList();
		stringList.add("Java");
		stringList.add("C++");
		stringList.add("Java");
		stringList.add("Ruby");
		stringList.add("JavaScript");
		stringList.add("Java EE");
		stringList.add("Java");
		stringList.add("C");
		System.out.println("stringList " + stringList);
		System.out.println("Removed " + stringList.removeAll("Java") + " items from list");
		System.out.println("stringList: " + stringList);

	}
}
