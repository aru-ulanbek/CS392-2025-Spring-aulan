package finexam.Code;

/*
 * LinkedList queue
 */

 public class Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        head = tail = null;
    }

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T removedData = head.getData();
        head = head.getNextNode();
        size--;
        return removedData;
    }

    public T peek() {
        return !isEmpty() ? head.getData() : null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return head.toString();
    }
}