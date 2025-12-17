package algorithms;
import graphs.*;
import java.util.*;

public class TopologicalSort {
	List<Integer> result;
    private final Digraph graph;
    private final boolean[] visited;
    private final Stack<Integer> stack;

    public TopologicalSort(Digraph graph) {
        this.graph = graph;
        this.visited = new boolean[graph.V()];
        this.stack = new Stack<>();
        
        //converte a pilha para uma lista na ordem correta
        this.result = new ArrayList<>();
    }
    
    public List<Integer> ordenation() {
		return result;
	}

    public void sort() {
        for (int v = 0; v < graph.V(); v++) {
            if (!visited[v]) {
                dfs(v);
            }
        }
        
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    private void dfs(int v) {
        visited[v] = true;

        for (Edge edge : graph.adj(v)) {
            if (!visited[edge.w]) {
                dfs(edge.w);
            }
        }

        stack.push(v);
    }
}
