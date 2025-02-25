public class Assign02_05 {
    public static boolean solve_3sum(Integer[] A) {
	// Please give a soft qudratic time implementation
	// that solves the 3-sum problem. The function call
	// solve_3sum(A) returns true if and only if there exist
	// indices i, j, and k satisfying A[i]+A[j] = A[k].
		Integer sum;

		for (Integer i = 0; i < A.length; i++) {
			for (Integer j = 0; j < A.length; j++) {
				sum = A[i] + A[j];
				if (Assign02_02.indexOf(A, sum, A.length - 1, 0) != -1) {
					return true; 
				}
				
			}
		}
		return false;
    }

    public static void main(String[] argv) {
	// Please write some code here for testing solve_3sum
		// Test 1: Should return true (1 + 4 = 5)
        Integer[] A1 = {1, 2, 3, 4, 5};
        System.out.println(solve_3sum(A1)); // Expected output: true

        // Test 2: Should return true
        Integer[] A2 = {10, 20, 30, 40, 50};
        System.out.println(solve_3sum(A2)); // Expected output: true

        // Test 3: Should return true (3 + 2 = 5)
        Integer[] A3 = {5, 10, 15, 2, 3};
        System.out.println(solve_3sum(A3)); // Expected output: true

        // Test 4: Should return true
        Integer[] A4 = {-1, -2, -3, -4, -5};
        System.out.println(solve_3sum(A4)); // Expected output: true

        // Test 5: Should return true (0 + 0 = 0)
        Integer[] A5 = {0, 0, 0, 0, 0};
        System.out.println(solve_3sum(A5)); // Expected output: true
    }
}
