
import ch05.queues.ArrayBndQueue;
import ch05.queues.BoundedQueueInterface;
import ch05.queues.QueueOverflowException;
import ch05.queues.QueueUnderflowException;

public class Dequeue<T> extends ArrayBndQueue<T> implements BoundedQueueInterface<T> {
	public void addFront(T element) {
		if (isFull()) {
			throw new QueueOverflowException("addFront attempted on a full queue.");
		}
		else {
			front = front - 1;

			if (front == -1) {
				front = queue.length - 1;
			}

			queue[front] = element;
			numElements++;
		}

	}

	public T removeRear() {
		if (isEmpty()) {
			throw new QueueUnderflowException("removeRear attempted on empty queue.");
		}
		else {
			T toReturn = queue[rear];
			--rear;
			if (rear < 0) {
				rear = queue.length - 1;
			}
			numElements--;
			return toReturn;
		}

	}

	@Override
	public String toString() {
		String sPrint = " ";
		int frontA = front;
		if (numElements == 0) {
			sPrint = " ";
		}
		else if (numElements == 1) {
			sPrint += queue[frontA];
		}
		else {
			for (int i = 1; i <= numElements; ++i) {
				sPrint += queue[frontA] + " ";
				frontA = (frontA + 1) % queue.length;
			}
		}
		return sPrint;
	}
}
