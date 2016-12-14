/*
 * 
 */
public class LinearProbingHash {
	Integer[] array;
	int size;
	int numElements;
	int collisions;

	public LinearProbingHash(int size) {
		allocateArray(size);
		doClear();
	}

	private void allocateArray(int arraySize) {
		array = new Integer[arraySize];
		size = arraySize;

	}

	private void doClear() {
		numElements = 0;
		for (int i = 0; i < array.length; ++i) {
			array[i] = null;
		}
	}

	public boolean isFull() {
		if (numElements == size)
			return true;
		else
			return false;
	}

	private int hash(int x) {
		return x % size;
	}

	public void add(int key) {
		if (this.isFull()) {
			throw new ArrayOverflowException("Attempted an add operation on a full hash table");
		}
		else {
			int location;
			location = hash(key);
			while (array[location] != null) {
				location = (location + 1) % array.length;
			}
			array[location] = key;
			++numElements;
		}
	}

	public int get(int key) {
		collisions = 0;
		int location;
		location = hash(key);
		while (!array[location].equals(key)) {
			location = (location + 1) % array.length;
			collisions++;
		}
		return location;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		int j = 1;
		for (int i = 0; i < size; ++i) {
			s.append(String.format("%-5s", array[i]));
			if (j % 5 == 0)
				s.append("\n");
			++j;
		}
		return s.toString();
	}
}
