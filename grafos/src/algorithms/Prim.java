package algorithms;
import graphs.*;
import java.util.*;

public class Prim {
    
    // Agora apenas declaramos os campos estáticos, sem inicializar arrays.
    static int V;
    static double mstWeight;
    private static int[] parent; 
    private static double[] key; // Adicionado para uso no método print()
    
    public static double minimumST() {
        return mstWeight;
    }
    
    // Método print corrigido para usar a indexação 1-based e exibir os pesos.
    public void print() {
        System.out.println("Prim's MST (Arestas da Árvore Geradora Mínima):");
        // O loop começa em 1, pois o vértice 0 é a raiz (root).
        for (int i = 1; i < V; i++) {
            if (parent[i] != -1) {
                // Impressão 1-based: (predecessor + 1) - (vértice atual + 1)
                System.out.println(String.format("Aresta: (%d - %d, Peso: %.2f)", 
                    parent[i] + 1, 
                    i + 1,         
                    key[i]         
                ));
            }
        }
        System.out.println("Peso Total da MST: " + mstWeight);
    }
    
    public static void findMST(Graph graph) {
        V = graph.V();
        
        // CORREÇÃO ESSENCIAL: Inicializamos os arrays *aqui*, depois que V é conhecido.
        parent = new int[V];
        key = new double[V]; 
        mstWeight = 0; 
        
        boolean[] inMST = new boolean[V];
        
        // Inicializar valores de key e parent
        for (int i = 0; i < V; i++) {
            key[i] = Double.POSITIVE_INFINITY;
            parent[i] = -1;
        }

        // CORREÇÃO LÓGICA: Iniciar a MST pelo vértice 0 com peso 0.
        key[0] = 0; 

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> Double.compare(a.weight, b.weight));
        // Edge(-1, 0, 0) significa: (Predecessor: NIL, Vértice: 0, Peso: 0)
        pq.add(new Edge(-1, 0, 0)); 

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.w; 

            if (inMST[u]) continue;

            inMST[u] = true;
            mstWeight += current.weight; 

            // Atualizar os vértices adjacentes (relaxamento)
            for (Edge e : graph.adj(u)) {
                int v = e.w; 
                
                if (!inMST[v] && e.weight < key[v]) {
                    key[v] = e.weight;
                    parent[v] = u; // u é o predecessor de v
                    // Adiciona o vértice 'v' à PQ com sua nova key.
                    pq.add(new Edge(u, v, key[v])); 
                }
            }
        }
    }
}
