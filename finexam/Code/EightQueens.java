package finexam.Code;

import java.util.Arrays;

public class EightQueens {

    public static final int N = 8;

    public static class Board {
        private final int[] positions;

        public Board() {
            this.positions = new int[N];
        }

        public Board(int[] positions) {
            this.positions = positions;
        }

        public int get(int i) {
            return positions[i];
        }

        public Board set(int i, int val) {
            int[] newPositions = Arrays.copyOf(positions, N);
            newPositions[i] = val;
            return new Board(newPositions);
        }
    }

    void printDots(int i) {
        if (i < 0) throw new IndexOutOfBoundsException("printDots: Negative index: " + i);
        if (i > 0) {
            System.out.print(". ");
            printDots(i - 1);
        }
    }

    public void printRow(int i) {
        printDots(i);
        System.out.print("Q ");
        printDots(N - i - 1);
        System.out.println();
    }

    public void printBoard(Board bd) {
        printBoardHelper(bd, 0);
        System.out.println();
    }

    private void printBoardHelper(Board bd, int row) {
        if (row < N) {
            printRow(bd.get(row));
            printBoardHelper(bd, row + 1);
        }
    }

    public static boolean safetyTest1(int i0, int j0, int i, int j) {
        return j0 != j && Math.abs(i0 - i) != Math.abs(j0 - j);
    }

    public static boolean safetyTest2(int i0, int j0, Board bd, int i) {
        if (i < 0) return true;
        if (safetyTest1(i0, j0, i, bd.get(i))) {
            return safetyTest2(i0, j0, bd, i - 1);
        } else {
            return false;
        }
    }

    public int search(Board bd, int i, int j, int nsol) {
        if (j < N) {
            if (safetyTest2(i, j, bd, i - 1)) {
                Board bd1 = bd.set(i, j);
                if (i + 1 == N) {
                    System.out.println("Solution #" + (nsol + 1) + ":\n");
                    printBoard(bd1);
                    return search(bd, i, j + 1, nsol + 1);
                } else {
                    return search(bd1, i + 1, 0, nsol);
                }
            } else {
                return search(bd, i, j + 1, nsol);
            }
        } else {
            if (i > 0) {
                return search(bd, i - 1, bd.get(i - 1) + 1, nsol);
            } else {
                return nsol;
            }
        }
    }

    public static void main(String[] args) {
        Board emptyBoard = new Board(new int[N]);
        EightQueens sol = new EightQueens();
        int totalSolutions = sol.search(emptyBoard, 0, 0, 0);
        System.out.println("Total solutions: " + totalSolutions);
    }
}
