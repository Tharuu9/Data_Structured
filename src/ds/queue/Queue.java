package ds.queue;


public class Queue {
    private int[] elementData;
    private int front;
    private int rear;

    public Queue(final int initialCapacity) {
        elementData = new int[initialCapacity];
        front = -1;
        rear = -1;
    }

    public void enQueue(int data) {
        if (isFull()) {
            grow();
        }
        if (front == -1)
            front = 0;
        elementData[++rear] = data;
    }

    private boolean isFull() {
        return rear == elementData.length - 1 || front > rear;
    }

    private void grow() {
        int[] temp = elementData;
        elementData = new int[temp.length * 2];
        System.arraycopy(temp, 0, elementData, 0, temp.length);
    }

    public int deQueue() {
        if(isEmpty()) {
            System.err.println("Queue is empty");
            return -1;
        }
        return elementData[front++];
    }

    private boolean isEmpty() {
        return front == -1 || front > rear;
    }

    public int peek() {
        if (isEmpty()) {
            System.err.println("Queue is empty");
            return -1;
        }
        return elementData[front];
    }

    public void clear() {
        front = -1;
        rear = -1;
    }

    public int size() {
        return rear - front + 1;
    }

    public void printQueue() {
        System.out.print("[");
        if(isEmpty()) {
            System.out.println("Empty queue]");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(elementData[i] + ", ");
        }
        System.out.println("\b\b]");
    }
}
