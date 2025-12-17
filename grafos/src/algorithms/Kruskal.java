package algorithms;
import graphs.*;
import java.util.*;

public class Kruskal {
	static double mstWeight;
	static List<Edge> mstEdges = new ArrayList<>();
	
	public static double minimumST() {
		return mstWeight;
	}
	
	public static void print() {
		System.out.println("Kruskal's MST:");
        for (Edge e : mstEdges) {
            System.out.println(e.v + " - " + e.w + " (weight: " + e.weight + ")");
        }
	}
	
    public static void findMST(Graph graph) {
        List<Edge> edges = new ArrayList<>(graph.edges());
        Collections.sort(edges, Comparator.comparingDouble(e -> e.weight));

        //estruturas para a união e busca de conjuntos disjuntos
        int[] parent = new int[graph.V()];
        int[] rank = new int[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        for (Edge edge : edges) {
            int rootU = find(parent, edge.v);
            int rootV = find(parent, edge.w);

            if (rootU != rootV) { //não forma ciclo
                mstEdges.add(edge);
                mstWeight += edge.weight;
                union(parent, rank, rootU, rootV);
            }
        }
    }

    private static int find(int[] parent, int v) {
        if (parent[v] != v) {
            parent[v] = find(parent, parent[v]); //compressão de caminho
        }
        return parent[v];
    }

    private static void union(int[] parent, int[] rank, int rootU, int rootV) {
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}
