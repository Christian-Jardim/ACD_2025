package utils;
import graphs.*;

public class Copy {
	public static void copyGraph(Graph source, Graph target) {
        for (Edge e : source.edges()) {
            target.addEdge(e.v, e.w, e.weight);
        }
    }
 }
