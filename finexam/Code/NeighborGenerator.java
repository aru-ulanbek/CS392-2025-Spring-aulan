package finexam.Code;

public interface NeighborGenerator<T> {
    Stack<T> generateStack(T state);
    Queue<T> generateQueue(T state);
}
