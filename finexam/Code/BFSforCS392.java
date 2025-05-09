package finexam.Code;

public class BFSforCS392<T> {
    public static class Vertex<T> {
        private final T data;
        private boolean visited;
        private List<Vertex<T>> neighbors = new LinkedList<>();
    
        public Vertex(T data) {
            this.data = data;
            this.visited = false;
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
    
        public List<Vertex<T>> getNeighbors() {
            return neighbors;
        }
    
        public void setNeighbors(List<Vertex<T>> neighbors) {
            this.neighbors = neighbors;
        }
    
        @Override
        public String toString() {
            return "Vertex{" +
                    "data=\n" + data +
                    ", visited=" + visited +
                    '}';
        }
    }

    private final Vertex<T> startVertex;
    public BFSforCS392(Vertex<T> startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {
        Queue<Vertex<T>> queue = new Queue<>();
        startVertex.setVisited(true);
        queue.enqueue(startVertex);

        while (!queue.isEmpty()) {
            Vertex<T> current = queue.dequeue();
            System.out.println("Visited: \n" + current.getData());
            current.setVisited(true);
            System.out.println(current);
            Node<Vertex<T>> currentNode = ((LinkedList<Vertex<T>>) current.getNeighbors()).getRoot();
            while (currentNode != null) {
                Vertex<T> neighbor = currentNode.getData();
                if (!neighbor.isVisited()) {
                    neighbor.setVisited(true);
                    queue.enqueue(neighbor);
                }
                currentNode = currentNode.getNextNode();
            }

        }
    }

    public Vertex<T> search(Vertex<T> start, GoalTest<T> goalTest) {
        Queue<Vertex<T>> queue = new Queue<>();
        start.setVisited(true);
        queue.enqueue(start);
    
        while (!queue.isEmpty()) {
            Vertex<T> current = queue.dequeue();
    
            if (goalTest.isGoal(current.getData())) {
                return current;
            }
    
            Node<Vertex<T>> currentNode = ((LinkedList<Vertex<T>>) current.getNeighbors()).getRoot();
            while (currentNode != null) {
                Vertex<T> neighbor = currentNode.getData();
                if (!neighbor.isVisited()) {
                    neighbor.setVisited(true);
                    queue.enqueue(neighbor);
                }
                currentNode = currentNode.getNextNode();
            }
        }
    
        return null;
    }
    

    public static void main(String[] args) {
        BFSforCS392.Vertex<Integer> v0 = new BFSforCS392.Vertex<>(0);
        BFSforCS392.Vertex<Integer> v1 = new BFSforCS392.Vertex<>(1);
        BFSforCS392.Vertex<Integer> v2 = new BFSforCS392.Vertex<>(2);
        BFSforCS392.Vertex<Integer> v3 = new BFSforCS392.Vertex<>(3);
        BFSforCS392.Vertex<Integer> v4 = new BFSforCS392.Vertex<>(4);
        BFSforCS392.Vertex<Integer> v5 = new BFSforCS392.Vertex<>(5);
        BFSforCS392.Vertex<Integer> v6 = new BFSforCS392.Vertex<>(6);

        // Manually create neighbors using LinkedList
        LinkedList<BFSforCS392.Vertex<Integer>> neighborsV0 = new LinkedList<>();
        neighborsV0.insert(v6);
        neighborsV0.insert(v5);
        neighborsV0.insert(v1);
        v0.setNeighbors(neighborsV0);

        LinkedList<BFSforCS392.Vertex<Integer>> neighborsV1 = new LinkedList<>();
        neighborsV1.insert(v5);
        neighborsV1.insert(v4);
        neighborsV1.insert(v3);
        v1.setNeighbors(neighborsV1);

        LinkedList<BFSforCS392.Vertex<Integer>> neighborsV4 = new LinkedList<>();
        neighborsV4.insert(v6);
        neighborsV4.insert(v2);
        v4.setNeighbors(neighborsV4);

        LinkedList<BFSforCS392.Vertex<Integer>> neighborsV6 = new LinkedList<>();
        neighborsV6.insert(v0);
        v6.setNeighbors(neighborsV6);

        BFSforCS392<Integer> bfs = new BFSforCS392<>(v0);
        bfs.traverse();

    }

}
