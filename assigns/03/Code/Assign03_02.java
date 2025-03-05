import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Assign03_02 {
	public static <T> boolean stableSort(ArraySorter<T> sorter, T[] A) {
        // Step 1: Store original indices
        Map<T, Queue<Integer>> originalIndices = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            originalIndices.putIfAbsent(A[i], new LinkedList<>());
            originalIndices.get(A[i]).add(i);
        }

        // Step 2: Sort using the given sorter
        sorter.sort(A);

        // Step 3: Check if relative order of duplicate elements is preserved
        Map<T, Queue<Integer>> sortedIndices = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (!originalIndices.containsKey(A[i]) || originalIndices.get(A[i]).isEmpty()) {
                return false; // Something went wrong
            }
            int expectedIndex = originalIndices.get(A[i]).poll(); // Get the earliest original index
            
            // Ensure order remains sequential
            sortedIndices.putIfAbsent(A[i], new LinkedList<>());
            sortedIndices.get(A[i]).add(expectedIndex);
        }

        // Step 4: Check if order is preserved
        for (T key : sortedIndices.keySet()) {
            List<Integer> before = new ArrayList<>(sortedIndices.get(key));
            List<Integer> after = new ArrayList<>(before);
            Collections.sort(after);
            if (!before.equals(after)) return false; // Order changed
        }

        return true;
    }


    // public static <T> boolean stableSort(ArraySorter<T> sorter, T[] A) {
	// // Please use the given [sorter] to sort T[] A. The return value
	// // (true or false) should indicate whether the sorting done is stable
		
	// 	return false;
    // }
}
