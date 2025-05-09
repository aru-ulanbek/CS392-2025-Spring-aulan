package finexam.Code;

public class DFSforCS392<T> {

    public static class Vertex<T> {
        private final T data;
        private boolean visited;
        private LinkedList<Vertex<T>> neighbors = new LinkedList<>();

        public Vertex(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public LinkedList<Vertex<T>> getNeighbors() {
            return neighbors;
        }

        public void setNeighbors(LinkedList<Vertex<T>> neighbors) {
            this.neighbors = neighbors;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private final Vertex<T> startVertex;

    public DFSforCS392(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();

            if (!current.isVisited()) {
                current.setVisited(true);
                // System.out.println("Visited: \n" + current.getData());

                Node<Vertex<T>> neighborNode = current.getNeighbors().getRoot();
                while (neighborNode != null) {
                    Vertex<T> neighbor = neighborNode.getData();
                    if (!neighbor.isVisited()) {
                        stack.push(neighbor);
                    }
                    neighborNode = neighborNode.getNextNode();
                }
            }
        }
    }

    public Vertex<T> search(Vertex<T> start, GoalTest<T> goalTest) {
        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Vertex<T> current = stack.pop();

            if (!current.isVisited()) {
                current.setVisited(true);

                if (goalTest.isGoal(current.getData())) {
                    return current;
                }

                Node<Vertex<T>> neighborNode = current.getNeighbors().getRoot();
                while (neighborNode != null) {
                    Vertex<T> neighbor = neighborNode.getData();
                    if (!neighbor.isVisited()) {
                        stack.push(neighbor);
                    }
                    neighborNode = neighborNode.getNextNode();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {

        DFSforCS392.Vertex<Integer> v0 = new DFSforCS392.Vertex<>(0);
        DFSforCS392.Vertex<Integer> v1 = new DFSforCS392.Vertex<>(1);
        DFSforCS392.Vertex<Integer> v2 = new DFSforCS392.Vertex<>(2);
        DFSforCS392.Vertex<Integer> v3 = new DFSforCS392.Vertex<>(3);
        DFSforCS392.Vertex<Integer> v4 = new DFSforCS392.Vertex<>(4);
        DFSforCS392.Vertex<Integer> v5 = new DFSforCS392.Vertex<>(5);
        DFSforCS392.Vertex<Integer> v6 = new DFSforCS392.Vertex<>(6);

        LinkedList<DFSforCS392.Vertex<Integer>> neighborsV0 = new LinkedList<>();
        neighborsV0.insert(v1);
        neighborsV0.insert(v5);
        neighborsV0.insert(v6);
        v0.setNeighbors(neighborsV0);

        LinkedList<DFSforCS392.Vertex<Integer>> neighborsV1 = new LinkedList<>();
        neighborsV1.insert(v3);
        neighborsV1.insert(v4);
        neighborsV1.insert(v5);
        v1.setNeighbors(neighborsV1);

        LinkedList<DFSforCS392.Vertex<Integer>> neighborsV4 = new LinkedList<>();
        neighborsV4.insert(v2);
        neighborsV4.insert(v6);
        v4.setNeighbors(neighborsV4);

        LinkedList<DFSforCS392.Vertex<Integer>> neighborsV6 = new LinkedList<>();
        neighborsV6.insert(v0);
        v6.setNeighbors(neighborsV6);

        DFSforCS392<Integer> dfs = new DFSforCS392<>(v0);
        dfs.traverse();
    }

}
