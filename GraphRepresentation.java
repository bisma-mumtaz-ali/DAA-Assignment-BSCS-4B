import java.util.*;

public class GraphRepresentation {

    public static void main(String[] args) {

        int V = 4;
        // Adjacency Matrix

        int[][] adjMatrix = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };

        System.out.println("Adjacency Matrix Representation:\n");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }


        // Adjacency List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Adding edges for complete graph
        adjList.get(0).addAll(Arrays.asList(1, 2, 3));
        adjList.get(1).addAll(Arrays.asList(0, 2, 3));
        adjList.get(2).addAll(Arrays.asList(0, 1, 3));
        adjList.get(3).addAll(Arrays.asList(0, 1, 2));

        System.out.println("\nAdjacency List Representation:\n");

        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");

            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }
}