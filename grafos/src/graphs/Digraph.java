package graphs;

import java.util.List;

public interface Digraph{

    void addEdge(int v, int w, double weight);

    //obter todas as arestas do digrafo
    List<Edge> edges();

    List<Edge> adj(int v);

    int V();
    
    void BFS(int s); 

    void DFS();
    
    @Override
    String toString();
}
