package algorithms;
import graphs.*;
import java.util.*;

public class Dijkstra {
    private int V; // número de vértices
    private double[] dist;
    private List<List<Edge>> adj; // lista de adjacência

    public Dijkstra(Digraph graph) {
        this.V = graph.V();
        
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int u = 0; u < V; u++) {
            for (Edge edge : graph.adj(u)) {
                adj.get(edge.v).add(edge);
            }
        }
        
        this.dist = new double[V];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
    }

    public void computeShortestPaths(int fonte) {
        // Detecção de aresta negativa
        for (int u = 0; u < V; u++) {
			for (Edge e : adj.get(u)) {
				if (e.weight < 0) {
					System.out.println("\nGrafo contém aresta com peso negativo!\n");
					return;
				}
			}
        }
        
        dist[fonte] = 0;

        PriorityQueue<int[]> fila = new PriorityQueue<>(Comparator.comparingDouble(a -> a[1]));
        fila.offer(new int[]{fonte, 0});

        while (!fila.isEmpty()) {
            int[] atual = fila.poll();
            int u = atual[0];
            double distanciaAtual = atual[1];

            if (distanciaAtual > dist[u]) continue; // já temos melhor caminho

            for (Edge e : adj.get(u)) {
                if (dist[u] + e.weight < dist[e.w]) {
                    dist[e.w] = dist[u] + e.weight;
                    fila.offer(new int[]{e.w, (int) dist[e.w]});
                }
            }
        }
	}
	
        // Exibe resultados
    public void printDistances(int fonte) {
        System.out.println("\nDistâncias a partir do vértice " + fonte + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Para " + i + " -> " + dist[i]);
        }
    }
}
