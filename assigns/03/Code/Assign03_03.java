import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public
class Assign03_03<T> extends Assign02_03<T> implements Iterable2<T> {
    // Please extend Assign02_03 with support for Iterable2
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index <= size();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return takeout_at_end();
            }
            
        };
        return it;
    } // forward

    public Iterator<T> riterator() {
        Iterator<T> it = new Iterator<T>() {
            private int index = size()-1;

            @Override
            public boolean hasNext() {
                return index > 0; 
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return takeout_at_beg();
            }
            
        };
        return it;
    } // backward

    public void forEach(Consumer<? super T> action) {
        Iterator<T> it = iterator(); 
        while (it.hasNext()) {
            action.accept(it.next());
        }
        
    } // forward

    public void rforEach(Consumer<? super T> action) {
        Iterator<T> it = riterator();
        while (it.hasNext()) {
            action.accept(it.next());
        }
    } // backward

    public static void main(String[] args) {
        Assign03_03<Integer> deque = new Assign03_03<>();
        deque.insert_at_end(2);
        deque.insert_at_end(4);
        deque.insert_at_end(6);
        deque.insert_at_end(8);
        deque.print();

        System.out.println("Forward");

        deque.forEach(System.out::println);
        
        System.out.println("Reverse");

        deque.rforEach(System.out::println);

    }
}
