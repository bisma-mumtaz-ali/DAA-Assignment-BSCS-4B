import java.util.*;

public class EdmondsKarp {

  static final int V = 7;

  boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
    boolean[] visited = new boolean[V];

    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    visited[s] = true;
    parent[s] = -1;

    while (!q.isEmpty()) {
      int u = q.poll();

      for (int v = 0; v < V; v++) {
        if (!visited[v] && rGraph[u][v] > 0) {
          q.add(v);
          parent[v] = u;
          visited[v] = true;
        }
      }
    }
    return visited[t];
  }

  void dfs(int[][] rGraph, int s, boolean[] visited) {
    visited[s] = true;

    for (int i = 0; i < V; i++) {
      if (rGraph[s][i] > 0 && !visited[i]) {
        dfs(rGraph, i, visited);
      }
    }
  }

  int maxFlow(int[][] graph, int s, int t) {
    int u, v;

    int[][] rGraph = new int[V][V];

    for (u = 0; u < V; u++)
      for (v = 0; v < V; v++)
        rGraph[u][v] = graph[u][v];

    int[] parent = new int[V];
    int maxFlow = 0;

    while (bfs(rGraph, s, t, parent)) {

      int pathFlow = Integer.MAX_VALUE;

      for (v = t; v != s; v = parent[v]) {
        u = parent[v];
        pathFlow = Math.min(pathFlow, rGraph[u][v]);
      }

      for (v = t; v != s; v = parent[v]) {
        u = parent[v];
        rGraph[u][v] -= pathFlow;
        rGraph[v][u] += pathFlow;
      }

      maxFlow += pathFlow;
    }

    System.out.println("Maximum Flow = " + maxFlow);

    boolean[] visited = new boolean[V];
    dfs(rGraph, s, visited);

    System.out.println("Minimum Cut Edges:");

    for (int i = 0; i < V; i++) {
      for (int j = 0; j < V; j++) {
        if (visited[i] && !visited[j] && graph[i][j] > 0) {
          System.out.println(
                  (char) ('A' + i) + " -> " +
                          (char) ('A' + j)
          );
        }
      }
    }
    return maxFlow;
  }

  public static void main(String[] args) {

    int[][] graph = new int[V][V];

    graph[0][1] = 3;
    graph[0][3] = 3;
    graph[1][2] = 4;
    graph[2][0] = 3;
    graph[2][3] = 1;
    graph[2][4] = 2;
    graph[3][4] = 2;
    graph[3][5] = 6;
    graph[4][6] = 1;
    graph[4][1] = 1;
    graph[5][6] = 9;

    EdmondsKarp m = new EdmondsKarp();
    m.maxFlow(graph, 0, 6);
  }
}