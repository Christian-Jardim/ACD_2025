package algorithms;
import graphs.*;
import java.util.*;

public class FordFulkerson {

    private int V; // número de vértices
    private double maxFlow; // fluxo máximo
    private double[][] nGraph;
    
    public int V() {
		return V;
	}

    public FordFulkerson(Digraph graph) {
        this.V = graph.V();
        this.maxFlow = 0;
        
        // cria grafo residual a partir da lista de adjacência
        nGraph = new double[V][V];
        for (int u = 0; u < V; u++) {
            for (Edge e : graph.adj(u)) {
                nGraph[u][e.w] = e.weight;
            }
        }
    }
    
    public double getMaxFlow() {
		return maxFlow;
	}

    // BFS para encontrar caminho aumentante no grafo residual
    private boolean bfs(double[][] graph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;

                    if (v == t) return true;
                }
            }
        }
        return false;
    }

    // Calcula o fluxo máximo de s para t
    public void maxFlow(int s, int t) {
        int[] parent = new int[V];

        // enquanto houver caminho aumentante, continua…
        while (bfs(nGraph, s, t, parent)) {

            double pathFlow = Double.POSITIVE_INFINITY;

            // encontra gargalo
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, nGraph[u][v]);
            }

            // atualiza capacidades residuais
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                nGraph[u][v] -= pathFlow;
                nGraph[v][u] += pathFlow; // aresta reversa
            }

            maxFlow += pathFlow;
        }
    }
}
