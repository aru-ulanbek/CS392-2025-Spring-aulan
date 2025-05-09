package finexam.Code;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public void push(T data) {
        Node<T> node = new Node<>(data);
        if (!isEmpty()) {
            node.setNextNode(top);
        }
        top = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T oldData = top.getData();
        top = top.getNextNode();
        size--;
        return oldData;
    }

    public T peek() {
        return isEmpty() ? null : top.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
