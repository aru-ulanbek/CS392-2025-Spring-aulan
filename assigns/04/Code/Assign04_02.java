import java.util.Comparator;

public class Assign04_02 {

    // This class should not be instantiated.
    private Assign04_02() {
    }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
        return (x.compareTo(y) < 0);
    }

    static <T extends Comparable<T>> LList<T> findTail(LList<T> smallerElemHead) {
            if (smallerElemHead == null) {
                return null;
            }
            LList<T> temp = smallerElemHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public static <T extends Comparable<T>> LList<T> listSort(LList<T> xs) {
        // Please implement [quicksort] on a linked list
        // Note that you can choose to *always* use the first element
        // to be the pivot for spliting. However, no extra heap memory
        // is allowed in your implementation of list-quicksort.

        if (xs == null || xs.next == null) {
            return xs; // Base case: already sorted or empty
        }
        return quickSort(xs);
    }

    private static <T extends Comparable<T>> LList<T> quickSort(LList<T> head) {
        if (head == null || head == findTail(head)) {
            return head;
        }
        
        LList<T> pivot = head;
        LList<T> smallerElemHead = null; LList<T> smallerElemTail = null;
        LList<T> largerElemHead = null; LList<T> largerElemTail = null;
        LList<T> curr = head.next;

        while (curr != null) {
            LList<T> nextNode = curr.next;
            curr.next = null;
            if (less(curr.elem, pivot.elem)) {
                if (smallerElemTail == null) {
                    smallerElemHead = smallerElemTail = curr;
                } else {
                    smallerElemTail.next = curr;
                    smallerElemTail = curr;
                }
            } else {
                if (largerElemTail == null) {
                    largerElemHead = largerElemTail = curr;
                } else {
                    largerElemTail.next = curr;
                    largerElemTail = curr;
                }
            }
            curr = nextNode;
        }

        if (smallerElemTail != null) {
            smallerElemTail.next = null;
        }
    
        if (largerElemTail != null) {
            largerElemTail.next = null;
        }

        smallerElemHead = quickSort(smallerElemHead);
        largerElemHead = quickSort(largerElemHead);

        if (smallerElemHead == null) {
            pivot.next = largerElemHead;
            return pivot;
        } else {
            LList<T> temp = smallerElemHead;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = pivot;
            pivot.next = largerElemHead;
            return smallerElemHead;
        }
    }
    
        // if (smallerElemHead != null) {
        //     // smallerElemTail = findTail(smallerElemHead);
        //     smallerElemTail.next = findTail(equal);
        // }

        // if (largerElemHead != null) {
        //     // equalTail = findTail(equal);
        //     equalTail.next = largerElemHead;
        // }

        // if (smallerElemHead != null) {
        //     head = smallerElemHead;
        // } else {
        //     head = equal;
        // }

    public static <T> void printList(LList<T> head) {
        while (head != null) {
            System.out.print(head.elem + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] argv) {
        // Please provide some testing code here
        LList<Integer> list = new LList<>();
        list.elem = 5;
        list.next = new LList<>();
        list.next.elem = 2;
        list.next.next = new LList<>();
        list.next.next.elem = 9;
        list.next.next.next = new LList<>();
        list.next.next.next.elem = 1;
        list.next.next.next.next = new LList<>();
        list.next.next.next.next.elem = 5;
        list.next.next.next.next.next = new LList<>();
        list.next.next.next.next.next.elem = 6;

        System.out.println("Before sorting:");
        printList(list);

        list = listSort(list);

        System.out.println("After sorting:");
        printList(list);
    }
}
