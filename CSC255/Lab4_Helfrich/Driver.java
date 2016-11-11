
/*
 * @author Eric Helfrich
 * CSC 255 Lab 4
 * Question: 5.3
 * Driver to Test 3 different Solutions to Collisions
 * uncomment lines to see the distribution of each hash table
 */
import java.util.Random;

public class Driver {
	// Simple main
	public static void main(String[] args) {

		Random randomGenerator = new Random(); //Generates Random numbers to insert into Hash Tables
		LinearProbingHashTable<Integer> L = new LinearProbingHashTable<>();
		QuadraticProbingHashTable<Integer> Q = new QuadraticProbingHashTable<>();
		DoubleHashTable<Integer> D = new DoubleHashTable<>();

		System.out.println("Testing of LinearProbingHashTable with 100 random entries");
		for (int i = 0; i < 100; ++i) {
			L.insert(randomGenerator.nextInt(1000));
		}
		System.out.println("# of Collisions: " + L.getCollisions() + "\n");
		//System.out.println(L); //Prints a representation of the Hash Table

		System.out.println("Testing of QuadraticProbingHashTable with 100 random entries");
		for (int i = 0; i < 100; ++i) {
			Q.insert(randomGenerator.nextInt(1000));
		}
		System.out.println("# of Collisions " + Q.getCollisions());
		System.out.println("# of times ReHashed " + Q.getReHash() + "\n");
		//System.out.println(Q); //Prints a representation of the Hash Table

		System.out.println("Testing of DoubleHashTable");
		for (int i = 0; i < 100; ++i) {
			D.insert(randomGenerator.nextInt(100));
		}
		System.out.println("# of Collisions " + D.getCollisions());
		System.out.println("# of times ReHashed " + D.getReHash() + "\n");
		//System.out.println(D); //Prints a representation of the Hash Table

	}
}
