import java.util.Arrays;
import java.util.Comparator;

public class Assign04_04 {

    // This class should not be instantiated.
    private Assign04_04() { }

	private static class IndexedElement <T extends Comparable<T>> implements Comparable<IndexedElement<T>> {
		T value;
		int originalPos;

		IndexedElement(T value, int originalPos) {
			this.value = value;
			this.originalPos = originalPos;
		}

		@Override
		public int compareTo(IndexedElement<T> other) {
			int compare = this.value.compareTo(other.value);
			if (compare != 0) {
				return compare; // if sorted will always return less than 0
			} else {
				return Integer.compare(this.originalPos, other.originalPos); // if sorted AND stable will always return less than 0, if sorted AND NOT stable will return greater than 0
			}
		}

		public String toString() {
			String temp = "[" + value.toString() + ", " + originalPos + "]";
			return temp;
		}
	}

    public static <T extends Comparable<T>> void stableSort(T A[]) {
	// Note that ArraySorter.sort may not be stable.
	// Please implement a stable sorting function by calling
	// the sort function in ArraySorter. You need to briefly
	// explain as to why your implementation actually works (that is,
	// it does stable sorting).
	// You must use ArraySorter.sort (instead of implementing your own
	// stable sorting function directly.
		IndexedElement<T>[] indexedOriginal = new IndexedElement[A.length];

		for (int i = 0; i < A.length; i++) {
			indexedOriginal[i] = new IndexedElement<>(A[i], i);
		}

		Assign04_01.sort(indexedOriginal);
		// Assign04_01.sort(A);
		for (int i = 0; i < indexedOriginal.length; i++) {
			System.out.print(indexedOriginal[i].toString() + ", ");
		}

		for (int i = 0; i < A.length - 1; i++) {
			if (indexedOriginal[i].compareTo(indexedOriginal[i+1]) > 0) {
				Assign04_01.exch(indexedOriginal, i, i+1);
				// Assign04_01.exch(A, i, i+1);
				// compareTo only returns a number > 0 after the array is sorted if the sorted array is unstable
				// so it will only swap the ith and (i+1)th element if it's unstable
			}
			A[i] = indexedOriginal[i].value;
		}
		for (int i = 0; i < indexedOriginal.length; i++) {
			System.out.print(indexedOriginal[i].toString() + ", ");
		}
	}

    public static void main(String[] argv) {
	// Please provide some testing code here
		// Test case 1: Sorting an array of integers
        Integer[] intArray = {5, 2, 5, 5, 9, 5, 1, 5, 6, 5};
        System.out.println("Before sorting: " + Arrays.toString(intArray));
        stableSort(intArray);
        System.out.println("After sorting: " + Arrays.toString(intArray));

        // Test case 2: Sorting an already sorted array
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("Before sorting: " + Arrays.toString(sortedArray));
        stableSort(sortedArray);
        System.out.println("After sorting: " + Arrays.toString(sortedArray));

        // Test case 3: Sorting an array with duplicates
        Integer[] duplicateArray = {3, 1, 2, 1, 3, 2, 1};
        System.out.println("Before sorting: " + Arrays.toString(duplicateArray));
        stableSort(duplicateArray);
        System.out.println("After sorting: " + Arrays.toString(duplicateArray));

        // Test case 4: Sorting an array of strings
        String[] strArray = {"banana", "apple", "cherry", "date"};
        System.out.println("Before sorting: " + Arrays.toString(strArray));
        stableSort(strArray);
        System.out.println("After sorting: " + Arrays.toString(strArray));

        // Test case 5: Sorting an empty array
        Integer[] emptyArray = {};
        System.out.println("Before sorting: " + Arrays.toString(emptyArray));
        stableSort(emptyArray);
        System.out.println("After sorting: " + Arrays.toString(emptyArray));

        // Test case 6: Sorting a single-element array
        Integer[] singleElementArray = {42};
        System.out.println("Before sorting: " + Arrays.toString(singleElementArray));
        stableSort(singleElementArray);
        System.out.println("After sorting: " + Arrays.toString(singleElementArray));
    }

}
