
public class Driver {
	public static void main(String[] args) {
		WeightedGraph<String> a = new WeightedGraph(10);
		a.addVertex("Atlanta");
		a.addVertex("Austin");
		a.addVertex("Chicago");
		a.addVertex("Dallas");
		a.addVertex("Denver");
		a.addVertex("Houston");
		a.addVertex("Washington");

		a.addEdge("Austin", "Dallas", 200);
		a.addEdge("Austin", "Houston", 160);
		a.addEdge("Dallas", "Austin", 200);
		a.addEdge("Dallas", "Denver", 780);
		a.addEdge("Dallas", "Chicago", 900);
		a.addEdge("Denver", "Chicago", 1000);
		a.addEdge("Denver", "Atlanta", 1400);
		a.addEdge("Chicago", "Denver", 1000);
		a.addEdge("Houston", "Atlanta", 800);
		a.addEdge("Atlanta", "Houston", 800);
		a.addEdge("Atlanta", "Washington", 600);
		a.addEdge("Washington", "Atlanta", 600);
		a.addEdge("Washington", "Dallas", 1300);

		System.out.println(a);

	}

}
