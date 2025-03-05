public class Assign02_03<T> implements Deque<T> {
    // Please give an array-based implementation of Deque
    private int INITIAL_MAXIMUM_SIZE = 16;
    private int max_size;
    T[] input;
    private int end;

    public Assign02_03() {
        input = (T[]) new Object[INITIAL_MAXIMUM_SIZE];
        end = -1;
        max_size = INITIAL_MAXIMUM_SIZE;
    }

    public int size() {
        return end + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == max_size;
    }

    @Override
    public void insert_at_beg(T x) {
        T[] tempArr;

        if (isFull()) {
            max_size += 1;
        }

        tempArr = (T[]) new Object[max_size];

        for (int i = 0; i < end + 1; i++) {
            tempArr[i + 1] = input[i]; 
        }

        input = tempArr;
        input[0] = x;
        end += 1;
    }

    @Override
    public T takeout_at_beg() {
        T removed = input[0];
        if (!isEmpty()) {
            T[] tempArr = (T[]) new Object[max_size];

            for (int i = 0; i < end; i++) {
                tempArr[i] = input[i + 1];
            }

            end -= 1;
            input = tempArr;
        }
        return removed;
    }

    @Override
    public void insert_at_end(T x) {
        if (!isFull()) {
            input[end + 1] = x;
        } else {
            max_size += 1;
            T[] tempArr = (T[]) new Object[max_size];

            for (int i = 0; i < end + 1; i++) {
                tempArr[i] = input[i]; 
            }


            tempArr[end + 1] = x;
            input = tempArr;
        }
        end += 1;
    }

    @Override
    public T takeout_at_end() {
        T removed = input[end];
        if (!isEmpty()) {
            T[] tempArr = (T[]) new Object[max_size];

            for (int i = 0; i < end; i++) {
                tempArr[i] = input[i];
            }

            input = tempArr;
            end -= 1;
        }
        return removed;
    }

    public void print() {
        String line = "";
        for (int i = 0; i < end + 1; i++) {
            line += input[i] + " ";
        }
        System.out.println(line);
    }

    public static void main(String[] args) {
        // Integer tests
        Assign02_03<Integer> deque = new Assign02_03<>();

        deque.insert_at_beg(1);
        deque.print();
        deque.insert_at_end(42);
        deque.print();
        deque.insert_at_beg(37);
        deque.print();

        deque.takeout_at_end();
        deque.print();
        deque.takeout_at_beg();
        deque.print();
        deque.takeout_at_beg();
        deque.print();

        for (int i = 0; i < 18; i++) {
            deque.insert_at_beg(i+1);
        }
        deque.print();

        for (int i = 0; i < 10; i++) {
            deque.insert_at_end(i);
        }
        deque.print();

        for (int i = 0; i < 13; i++) {
            deque.takeout_at_beg();
        }
        deque.print();
    }
}
