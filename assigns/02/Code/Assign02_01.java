public class Assign02_01 {
    /*
      HX-2025-02-13: 10 points
      The 'int' type in Java is for integers of some fixed precision.
      More precisely, each integer of the type int is represented a sequence of bits
      of some fixed length. Please write a program that finds this length. Your program
      is expected return the correct answer instantly. Note that you can only use arithmetic
      operations here. In particular, no bit-wise operations are allowed.
     */

    public static void main(String[] argv) {
	// Please give your implementation here
        int count = 0;
        int number = 1;
        while (number != 0) {
            number *= 2;
            count++;
            // System.out.println(number);
        }
        System.out.println("Size: " + count);
    }
}
