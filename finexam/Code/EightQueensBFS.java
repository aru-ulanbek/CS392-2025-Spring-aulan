package finexam.Code;

import java.util.Arrays;

public class EightQueensBFS {

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

        @Override
        public String toString() {
            if (EightQueensBFS.boardFilledRows(this) == N) {
                StringBuilder sb = new StringBuilder();
                for (int row = 0; row < N; row++) {
                    int col = get(row);
                    for (int i = 0; i < N; i++) {
                        sb.append(i == col ? "Q " : ". ");
                    }
                    sb.append("\n");
                }
                return sb.toString();
            }
            return "";
        }
    }

    public static boolean isSafe(Board bd, int row, int col) {
        for (int i = 0; i < row; i++) {
            int prevCol = bd.get(i);
            if (prevCol == col || Math.abs(prevCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    private static int boardFilledRows(Board bd) {
        for (int i = 0; i < N; i++) {
            if (bd.get(i) == 0 && i != 0) return i;
        }
        return N;
    }

    public static LinkedList<BFSforCS392.Vertex<Board>> generateNextBoards(Board current) {
        LinkedList<BFSforCS392.Vertex<Board>> neighbors = new LinkedList<>();

        int row = boardFilledRows(current);
        if (row >= N) return neighbors;

        for (int col = 0; col < N; col++) {
            if (isSafe(current, row, col)) {
                Board next = current.set(row, col);
                BFSforCS392.Vertex<Board> vertex = new BFSforCS392.Vertex<>(next);
                neighbors.insert(vertex);
            }
        }
        return neighbors;
    }

    public static void buildGraph(BFSforCS392.Vertex<Board> node) {
        Board bd = node.getData();
        int row = boardFilledRows(bd);
        if (row == N) return;

        LinkedList<BFSforCS392.Vertex<Board>> children = generateNextBoards(bd);
        node.setNeighbors(children);

        Node<BFSforCS392.Vertex<Board>> current = children.getRoot();
        while (current != null) {
            buildGraph(current.getData());
            current = current.getNextNode();
        }
    }

    public static void solve() {
        Board initialBoard = new Board();
        BFSforCS392.Vertex<Board> start = new BFSforCS392.Vertex<>(initialBoard);
        buildGraph(start);
        BFSforCS392<Board> bfs = new BFSforCS392<>(start);
        bfs.traverse();
    }

    public static void main(String[] args) {
        solve();
    }
}
