package graphs;
import java.util.*;

public interface Graph {

    public int V();

    public int E();

    public void addEdge(int v, int w, double weight);

    public List<Edge> edges();

    public Iterable<Edge> adj(int v);

    public void BFS(int s);

    public void DFS();

    public String StatusAtribs();

	@Override
    public String toString();
}



