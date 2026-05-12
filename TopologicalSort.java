import java.util.*;

public class TopologicalSort {

    static void addEdge(ArrayList<ArrayList<Character>> graph,
                        HashMap<Character, Integer> map,
                        char u, char v) {

        graph.get(map.get(u)).add(v);
    }

    static void dfs(int v,
                    boolean[] visited,
                    Stack<Character> stack,
                    ArrayList<ArrayList<Character>> graph,
                    char[] vertices,
                    HashMap<Character, Integer> map) {

        visited[v] = true;

        for (char neighbor : graph.get(v)) {

            int index = map.get(neighbor);

            if (!visited[index]) {
                dfs(index, visited, stack, graph, vertices, map);
            }
        }

        stack.push(vertices[v]);
    }

    public static void main(String[] args) {

        char[] vertices = {'m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        int V = vertices.length;

        ArrayList<ArrayList<Character>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < V; i++) {
            map.put(vertices[i], i);
        }

        // Edges from graph
        addEdge(graph, map, 'm', 'q');
        addEdge(graph, map, 'm', 'r');
        addEdge(graph, map, 'm', 'x');

        addEdge(graph, map, 'n', 'o');
        addEdge(graph, map, 'n', 'q');
        addEdge(graph, map, 'n', 'u');

        addEdge(graph, map, 'o', 'r');
        addEdge(graph, map, 'o', 's');
        addEdge(graph, map, 'o', 'v');

        addEdge(graph, map, 'p', 'o');
        addEdge(graph, map, 'p', 's');
        addEdge(graph, map, 'p', 'z');

        addEdge(graph, map, 'q', 't');

        addEdge(graph, map, 'r', 'u');
        addEdge(graph, map, 'r', 'y');

        addEdge(graph, map, 's', 'r');

        addEdge(graph, map, 'u', 't');

        addEdge(graph, map, 'v', 'w');
        addEdge(graph, map, 'v', 'x');

        addEdge(graph, map, 'y', 'v');

        addEdge(graph, map, 'w', 'z');

        boolean[] visited = new boolean[V];

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < V; i++) {

            if (!visited[i]) {
                dfs(i, visited, stack, graph, vertices, map);
            }
        }

        System.out.println("Topological Sort:");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}