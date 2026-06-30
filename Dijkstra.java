import java.util.*;

public class Dijkstra {

    static final int V = 9;

    int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void dijkstra(int[][] graph, int src) {

        int[] dist = new int[V];
        boolean[] sptSet = new boolean[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(sptSet, false);
        Arrays.fill(parent, -1);

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(dist, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {

                if (!sptSet[v]
                        && graph[u][v] != 0
                        && dist[u] != Integer.MAX_VALUE
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

        // Print shortest distances
        System.out.println("Vertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }

        // Print shortest path tree with weights
        System.out.println("\nShortest Path Tree:");
        System.out.println("Edge\t\tWeight");

        for (int i = 1; i < V; i++) {
            if (parent[i] != -1) {
                System.out.println(
                        parent[i] + " -> " + i
                                + "\t\t"
                                + graph[parent[i]][i]
                );
            }
        }
    }

    public static void main(String[] args) {

        int[][] graph = new int[V][V];

        // Undirected graph
        graph[0][1] = graph[1][0] = 4;
        graph[0][7] = graph[7][0] = 8;
        graph[1][2] = graph[2][1] = 8;
        graph[1][7] = graph[7][1] = 11;
        graph[2][3] = graph[3][2] = 7;
        graph[2][8] = graph[8][2] = 2;
        graph[2][5] = graph[5][2] = 4;
        graph[3][4] = graph[4][3] = 9;
        graph[3][5] = graph[5][3] = 14;
        graph[4][5] = graph[5][4] = 10;
        graph[5][6] = graph[6][5] = 2;
        graph[6][7] = graph[7][6] = 1;
        graph[6][8] = graph[8][6] = 6;
        graph[7][8] = graph[8][7] = 7;

        Dijkstra d = new Dijkstra();
        d.dijkstra(graph, 0);
    }
}