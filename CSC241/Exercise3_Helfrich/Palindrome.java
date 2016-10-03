
//---------------------------------------------------------------------
// Palindrome.java           by Dale/Joyce/Weems              Chapter 5
//
// Provides a method to test whether a string is a palindrome.
// Non letters are skipped.
//---------------------------------------------------------------------


import ch03.stacks.ArrayStack;
import ch03.stacks.BoundedStackInterface;
import ch05.queues.ArrayBndQueue;
import ch05.queues.BoundedQueueInterface;

public class Palindrome {
	public static boolean test(String candidate)
	// Returns true if candidate is a palindrome, false otherwise.
	{
		char digit; // current candidate character being processed
		int length; // length of candidate string
		int numDigits; // number of letter characters in candidate string
		int digitCount; // number of characters checked so far

		char fromStack; // current character popped from stack
		char fromQueue; // current character dequeued from queue
		boolean stillPalindrome; // true as long as the string might still be a
									// palindrome

		BoundedStackInterface<Character> stack; // holds non blank string
												// characters
		BoundedQueueInterface<Character> queue; // also holds non blank string
												// characters

		// initialize variables and structures
		length = candidate.length();
		stack = new ArrayStack<Character>(length);
		queue = new ArrayBndQueue<Character>(length);
		numDigits = 0;

		// obtain and handle digit characters
		for (int i = 0; i < length; i++) {
			digit = candidate.charAt(i);
			if (Character.isDigit(digit)) {
				numDigits++;
				stack.push(digit);
				queue.enqueue(digit);
			}
		}

		// determine if palindrome
		stillPalindrome = true;
		digitCount = 0;
		while (stillPalindrome && (digitCount < numDigits)) {
			fromStack = stack.top();
			stack.pop();
			fromQueue = queue.dequeue();
			if (fromStack != fromQueue)
				stillPalindrome = false;
			digitCount++;
		}

		// return result
		return stillPalindrome;
	}
}
