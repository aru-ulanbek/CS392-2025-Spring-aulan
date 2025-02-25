import java.util.Arrays;

public class Assign02_02 {
    /*
      HX-2025-02-13: 10 points
      Recursion is a fundamental concept in programming.
      However, the support for recursion in Java is very limited.
      Nontheless, we will be making extensive use of recursion in
      this class.
     */

    /*
    // This is a so-called iterative implementation:
    public static <T extends Comparable<T> > int indexOf(T[] a, T key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            final int mid = lo + (hi - lo) / 2;
	    final int sign = key.compareTo(a[mid]);
            if      (sign < 0) hi = mid - 1;
            else if (sign > 0) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    */

    public static <T extends Comparable<T> > int indexOf(T[] a, T key, int hi, int lo) {
	// Please give a recursive implementation of 'indexOf' that is
	// equivalent to the above one

        if (lo > hi) {
            System.out.println("Lower bound cannot be higher than upper bound");
            return -1;
        }
        if (hi > a.length - 1) {
            System.out.println("Index out of bounds");
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        int sign = key.compareTo(a[mid]);
        
        if (sign == 0) {
            return mid;
        }
        else if (sign < 0 && hi != lo) {
            hi = mid - 1;
            return indexOf(a, key, hi, lo);
        }
        else if (sign > 0 && hi != lo) {
            lo = mid + 1;
            return indexOf(a, key, hi, lo);
        }
        System.out.println("Not found");
        return -1;

    }

    public static void main(String[] argv) {
	// Please write some testing code for your implementation of 'indexOf'
        // Integer tests
        Integer[] ages = {1, 3, 4, 13, 19, 20, 21, 22, 23, 30, 31, 34, 43, 46, 48, 52, 70, 84, 86, 92};
        int len = ages.length;
        int bruh = indexOf(ages, 46, len - 1, 0);
        System.out.println("46 is at index: " + bruh);
        System.out.println("4 is at index: " + indexOf(ages, 4, len - 1, 0));
        System.out.println("23 is at index: " + indexOf(ages, 23, len - 1, 0));
        System.out.println("84 is at index: " + indexOf(ages, 84, len - 1, 0));
        System.out.println("4 is at index: " + indexOf(ages, 4, len - 4, len)); // Lower bound can't be higher than upper
        System.out.println("4 is at index: " + indexOf(ages, 4, len, 0)); // Upper bound out of bounds
        System.out.println("5 is at index: " + indexOf(ages, 5, len - 1, 0)); // Not found

        // String tests
        String[] words = {"apple", "banana", "cherry", "date", "grape", "starfruit", "tomato", "vanilla"};
        System.out.println("cherry is at index: " + indexOf(words, "cherry", words.length - 1, 0));  // Output should be 2
        System.out.println("orange is at index: " + indexOf(words, "orange", words.length - 1, 0));  // Output should be -1 (not found)
        System.out.println("apple is at index: " + indexOf(words, "apple", words.length - 1, 0));
        System.out.println("vanilla is at index: " + indexOf(words, "vanilla", words.length - 1, 0));

    }
}
