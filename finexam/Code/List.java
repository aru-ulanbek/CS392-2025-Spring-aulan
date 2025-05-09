package finexam.Code;

public interface List<T> {

    void insert(T data);

    void remove(T data);

    void removeRecursively(T data);

    void traverse();

    void traverseRecursively();

    boolean isEmpty();
}