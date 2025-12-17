package utils;
import graphs.*;
import java.util.List;
import java.util.ArrayList;

public class Choose {
	
	public static String chooseSample(int sample) {
		String sampleName = null;
		switch(sample) {
		case 1:
			sampleName = "samples/sample100-1980.gr";
			break;
		case 2:
			sampleName = "samples/sample100-3960.gr";
			break;
		case 3:
			sampleName = "samples/sample100-5940.gr";
			break;
		case 4:
			sampleName = "samples/sample100-7920.gr";
			break;
		case 5:
			sampleName = "samples/sample100-9900.gr";
			break;
		case 6:
			sampleName = "samples/sample200-7960.gr";
			break;
		case 7:
			sampleName = "samples/sample200-15920.gr";
			break;
		case 8:
			sampleName = "samples/sample200-23880.gr";
			break;
		case 9:
			sampleName = "samples/sample200-31840.gr";
			break;
		case 10:
			sampleName = "samples/sample200-39800.gr";
			break;
		case 11:
			sampleName = "samples/sample500-49900.gr";
			break;
		case 12:
			sampleName = "samples/sample500-99800.gr";
			break;
		case 13:
			sampleName = "samples/sample500-149700.gr";
			break;
		case 14:
			sampleName = "samples/sample500-199600.gr";
			break;
		case 15:
			sampleName = "samples/sample500-249500.gr";
			break;
		}
		
		return sampleName;
	}

	public static void chooseAlgGraph(int alg, String graphType, String sample, Graph graph, int rep, List<String> csvList) {
		switch(alg) {
			case 1:
				GraphTimes.timeGraphBFS(graphType, sample, graph, rep, csvList);
				break;
			case 2:
				GraphTimes.timeGraphDFS(graphType, sample, graph, rep, csvList);
				break;
			case 4:
				GraphTimes.timeK(graphType, sample, graph, rep, csvList);
				break;
			case 5:
				GraphTimes.timeP(graphType, sample, graph, rep, csvList);
				break;
			default:
				System.out.println("\n Agoritmo não aplicável a 'GRAFOS NÃO DIRIGIDOS'!");
		}
	}
	
	public static void chooseAlgDigraph(int alg, String graphType, String sample, Digraph graph, int rep, List<String> csvList) {
		switch(alg) {
			case 1:
				GraphTimes.timeDigraphBFS(graphType, sample, graph, rep, csvList);
				break;
			case 2:
				GraphTimes.timeDigraphDFS(graphType, sample, graph, rep, csvList);
				break;
			case 3:
				GraphTimes.timeOT(graphType, sample, graph, rep, csvList);
				break;
			case 6:
				GraphTimes.timeBF(graphType, sample, graph, rep, csvList);
				break;
			case 7:
				GraphTimes.timeD(graphType, sample, graph, rep, csvList);
				break;
			case 8:
				GraphTimes.timeFW(graphType, sample, graph, rep, csvList);
				break;
			case 9:
				GraphTimes.timeFF(graphType, sample, graph, rep, csvList);
				break;
			default:
				System.out.println("\n Agoritmo não aplicável a 'GRAFOS DIRIGIDOS'!");
		}
	}
}
