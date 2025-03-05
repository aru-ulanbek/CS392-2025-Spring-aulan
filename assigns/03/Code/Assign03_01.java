public class Assign03_01 {
    /*
      HX-2025-02-25:
      The following implementation is recursive
     */
    public static int mystery(int x) {
	return (x < 100 ? 100 - x : mystery(mystery(x-11)));
    }

    public static int check(int num) {
        int lo = 0;
        int hi = num;
        int result = lo;

        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
	        try {
                mystery(mid);
                result = mid;
                lo = mid + 1;
            } catch (StackOverflowError e) {
                hi = mid - 1;
            }
            if (lo == hi) {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] argv) {
	// Please write some code (based on binary search) that
	// outputs the largest integer N such that mystery(N) returns
	// normally (without raising the StackOverflowError exception)

        // System.out.println(check(1000000000));
        System.out.println(mystery(366207));
    }
}
