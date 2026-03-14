import java.util.*;

public class GraphEasy {

    static class Graph {
        int vertices;
        ArrayList<ArrayList<Integer>> adjList;

        // Constructor
        Graph(int v) {
            vertices = v;
            adjList = new ArrayList<>();

            for (int i = 0; i < v; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        // Add edge
        void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // remove this line if directed graph
        }

        // BFS
        void bfs(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            System.out.print("BFS: ");

            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");

                for (int neighbor : adjList.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println();
        }

        // DFS
        void dfs(int start) {
            boolean[] visited = new boolean[vertices];
            System.out.print("DFS: ");
            dfsHelper(start, visited);
            System.out.println();
        }

        void dfsHelper(int node, boolean[] visited) {
            visited[node] = true;
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    dfsHelper(neighbor, visited);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);

        g.bfs(0);
        g.dfs(0);
    }
}