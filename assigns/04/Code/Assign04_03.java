import java.util.Comparator;

import javax.swing.ComponentInputMap;

import org.w3c.dom.Node;

public class Assign04_03 {

    // This class should not be instantiated.
    private Assign04_03() {
    }

    private static <T extends Comparable<T>> boolean less(T x, T y) {
        return (x.compareTo(y) < 0);
    }

    public static <T extends Comparable<T>> LList<T> listSort(LList<T> xs) {
        // Please implement [mergesort] on a linked list
        // Note that no extra heap memory is needed for list-mergesort
        
        // if (xs == null || xs.next == null) {
        //     return xs; // Base case: already sorted or empty
        // }
        return mergesort(xs);
    }

    private static <T extends Comparable<T>> LList<T> split(LList<T> xs) {
        if (xs == null) {
            return xs;
        }

        LList<T> slow = xs;
        LList<T> fast = xs;

        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;            
        // LList<T> fast = xs;
        // LList<T> slow = xs;
        // LList<T> prev = null;
        // if (xs.next == null) {
        //     return null;
        // }
        // while (fast != null && fast.next != null) {
        //     fast = fast.next.next;
        //     prev = slow;
        //     slow = slow.next;
        // }

        // if (prev != null) {
        //     prev.next = null;
        // }

        // return slow;
    }

    private static <T extends Comparable<T>> LList<T> mergesort(LList<T> head) {
        if(head == null || head.next == null){
            return head;
        }

        LList<T> middle = split(head);
        LList<T> nextOfMiddle = middle.next;
        middle.next = null;

        LList<T> left = mergesort(head);
        LList<T> right = mergesort(nextOfMiddle);

        LList<T> sortedList = merge(left, right);
        return sortedList;

        // if (head.next == null) {
        //     return head;
        // }

        // LList<T> head2 = split(head);

        // LList<T> left = mergesort(head);
        // LList<T> right = mergesort(head2);

        // return merge(left, right);
    }

    private static <T extends Comparable<T>> LList<T> merge(LList<T> left, LList<T> right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        LList<T> temp = null;

        if (less(left.elem, right.elem)) {
            temp = left;
            temp.next = merge(left.next, right);
        } else {
            temp = right;
            temp.next = merge(left, right.next);
        }
        return temp;

        // if (less(right.elem, left.elem)) {
        // right.next = left;
        // return right;
        // } else {
        // left.next = right;
        // return left;
        // }
    }

    public static <T> void printList(LList<T> head) {
        while (head != null) {
            System.out.print(head.elem + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] argv) {
        // Please provide some testing code here
        // Test Case 1: Unsorted list
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
        listSort(list);
        System.out.println("After sorting:");
        printList(list);

        // Test case 2: Reverse sorted list
        LList<Integer> list1 = new LList<>();
        list1.elem = 5;
        list1.next = new LList<>();
        list1.next.elem = 4;
        list1.next.next = new LList<>();
        list1.next.next.elem = 3;
        list1.next.next.next = new LList<>();
        list1.next.next.next.elem = 2;
        list1.next.next.next.next = new LList<>();
        list1.next.next.next.next.elem = 1;

        System.out.println("Before sorting:");
        printList(list1);
        listSort(list1);
        System.out.println("After sorting:");
        printList(list1);
    }
}
