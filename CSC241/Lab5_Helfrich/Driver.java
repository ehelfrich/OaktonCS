/*
* Eric Helfrich lab5 CSC 241
*
*Driver for the program to test the Enqueue class
*
*
*
*/

public class Driver {
	public static void main(String[] args) { // page 376 #18
		System.out.println("page 376 #18 ");
		Dequeue<Integer> myDequeue;
		myDequeue = new Dequeue<Integer>();
		myDequeue.enqueue(23);
		System.out.print("enqueue 23 myDequeue: ");
		System.out.println(myDequeue);
		myDequeue.enqueue(40);
		System.out.print("enqueue 40 myDequeue: ");
		System.out.println(myDequeue);
		myDequeue.addFront(50);
		System.out.print("addFront50 myDequeue: ");
		System.out.println(myDequeue);
		myDequeue.addFront(20);
		System.out.print("addFront20 myDequeue: ");
		System.out.println(myDequeue);
		myDequeue.dequeue();
		System.out.print("dequeue myDequeue   : ");
		System.out.println(myDequeue);
		myDequeue.enqueue(8);
		System.out.print("enqueue 8 myDequeue : ");
		System.out.println(myDequeue);
		myDequeue.removeRear();
		System.out.print("removeRear myDequeue: ");
		System.out.println(myDequeue);
		myDequeue.removeRear();
		System.out.print("removeRear myDequeue: ");
		System.out.println(myDequeue);
		myDequeue.dequeue();
		System.out.print("dequeue myDequeue   : ");
		System.out.println(myDequeue);
		myDequeue.removeRear();
		System.out.print("removeRear myDequeue: ");
		System.out.println(myDequeue);

	}
}
