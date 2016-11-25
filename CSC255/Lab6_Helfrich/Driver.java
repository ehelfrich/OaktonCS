/*
 * Java Implementation of Kruskal's algorithm
 * 
 * The implementation shows the example from the book Data Structures and Algorithm Analysis in Java by Mark Allen Weiss
 */

public class Driver {
	public static void main(String[] args) {

		System.out.println("A program that implements Kruskals Algoritm\nwith data from p.398\n");

		Graph graph = new Graph(7);
		for (int i = 1; i <= 7; ++i) {
			graph.addVertex(i);
		}

		graph.addEdge(1, 4, 1);
		graph.addEdge(6, 7, 1);
		graph.addEdge(1, 2, 2);
		graph.addEdge(3, 4, 2);
		graph.addEdge(2, 4, 3);
		graph.addEdge(1, 3, 4);
		graph.addEdge(4, 7, 4);
		graph.addEdge(3, 6, 5);
		graph.addEdge(5, 7, 6);
		graph.kruskal();
	}
}
