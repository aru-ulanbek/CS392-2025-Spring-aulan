package finexam.Code;

import java.util.Arrays;


public class EightQueensDFS {
    
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
            if (EightQueensDFS.boardFilledRows(this) == EightQueensDFS.N) {
                // Full board — generate printable output
                StringBuilder sb = new StringBuilder();
                for (int row = 0; row < EightQueensDFS.N; row++) {
                    int col = get(row);
                    for (int i = 0; i < EightQueensDFS.N; i++) {
                        sb.append(i == col ? "Q " : ". ");
                    }
                    sb.append("\n");
                }
                return sb.toString();
            } else {
                return ""; // Ignore partial boards
            }
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

    public static void solve() {
        // DFSforCS392.Vertex<Integer> v0 = new DFSforCS392.Vertex<>(0);
        // DFSforCS392<Integer> dfs = new DFSforCS392<>(v0);
        Board initialBoard = new Board();
        DFSforCS392.Vertex<Board> start = new DFSforCS392.Vertex<>(initialBoard);
        
        buildGraph(start);

        DFSforCS392<Board> dfs = new DFSforCS392<>(start);
        dfs.traverse();
    }

    private static int boardFilledRows(Board bd) {
        for (int i = 0; i < N; i++) {
            if (bd.get(i) == 0 && i != 0) return i;
        }
        return N;
    }

    public static LinkedList<DFSforCS392.Vertex<Board>> generateNextBoards(Board current) {
        LinkedList<DFSforCS392.Vertex<Board>> neighbors = new LinkedList<>();
    
        int row = boardFilledRows(current);
        if (row >= N) return neighbors; // Full board, no more moves
    
        for (int col = 0; col < N; col++) {
            if (isSafe(current, row, col)) {
                Board nextBoard = current.set(row, col);
                DFSforCS392.Vertex<Board> vertex = new DFSforCS392.Vertex<>(nextBoard);
                neighbors.insert(vertex);
            }
        }
    
        return neighbors;
    }

    public static void buildGraph(DFSforCS392.Vertex<Board> node) {
        Board board = node.getData();
        int row = boardFilledRows(board);
    
        if (row == N) return; // Solution reached, no more children
    
        LinkedList<DFSforCS392.Vertex<Board>> children = generateNextBoards(board);
        node.setNeighbors(children);
    
        Node<DFSforCS392.Vertex<Board>> childNode = children.getRoot();
        while (childNode != null) {
            buildGraph(childNode.getData()); // Recurse
            childNode = childNode.getNextNode();
        }
    }    

    public static void main(String[] args) {
        solve();
    }
}

