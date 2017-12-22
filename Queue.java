
public class Queue {
	private int rear, front;
	public Object[] elements;

	public Queue(int capacity) {
		elements = new Object[capacity];
		front = 0;
		rear = -1;
	}

	public boolean isEmpty() {
		return (rear < front);

	}

	public boolean isFull() {
		return (rear + 1 == elements.length);
	}

	public Object peek() {
		if (!isEmpty()) {
			return elements[front];
		}
		return null;
	}

	public void Enqueue(Object data) // Add new data .
	{
		if (!isFull()) {
			rear++;
			elements[rear] = data;

		}
	}

	public Object Dequeue() {
		if (!isEmpty()) {
			Object returndata = elements[front];
			elements[front] = null;
			front++;
			return returndata;
		}
		return null;

	}

	public int size() {
		return rear - front + 1;
	}
}
