/*
 * The graph class was based off of the code from http://krishnalearnings.blogspot.com/2015/07/java-implementation-of-kruskals.html
 * the Kruskal Algorithm was based off of code from the book Data Structures and Algorithm Analysis in Java by Mark Allen Weiss
 */

public class Graph {
	Vertex[] vertices;
	Edge edgeList;
	int maxSize;
	int size;
	int edgeNum;

	public Graph(int maxSize) {
		this.maxSize = maxSize;
		vertices = new Vertex[maxSize];
	}

	public class Vertex {
		int rank;
		Vertex representative;
		int name;
		Neighbor adj;

		Vertex(int name) {
			this.name = name;
			representative = this;
		}
	}

	public class Neighbor {
		int index;
		Neighbor next;
		int weight;

		Neighbor(int index, int weight, Neighbor next) {
			this.index = index;
			this.weight = weight;
			this.next = next;
		}
	}

	public class Edge {
		Vertex src;
		Vertex dst;
		Edge next;
		int weight;

		Edge(Vertex src, Vertex dst, int weight, Edge next) {
			this.src = src;
			this.dst = dst;
			this.weight = weight;
			this.next = next;
		}
	}

	public void addVertex(int name) {
		vertices[size++] = new Vertex(name);
	}

	public void addEdge(int src, int dst, int weight) {
		vertices[src - 1].adj = new Neighbor(dst - 1, weight, vertices[src - 1].adj);
		edgeList = new Edge(vertices[src - 1], vertices[dst - 1], weight, edgeList);
		edgeNum++;
	}

	public Vertex findSet(Vertex u) {
		if (u.representative != u) {
			u.representative = findSet(u.representative); // path compression
		}
		return u.representative;
	}

	public void union(Vertex u, Vertex v) {
		if (u.rank == v.rank) {
			v.representative = u;
			u.rank++;
		}
		else if (u.rank < v.rank) {
			v.representative = u;
		}
		else {
			u.representative = v;
		}
	}

	public void quicksort(Edge[] edges, int start, int end) {
		if (start < end) {
			swap(edges, end, start + (end - start) / 2);
			int pIndex = pivot(edges, start, end);
			quicksort(edges, start, pIndex - 1);
			quicksort(edges, pIndex + 1, end);
		}
	}

	public int pivot(Edge[] edges, int start, int end) {
		int pIndex = start;
		Edge pivot = edges[end];
		for (int i = start; i < end; i++) {
			if (edges[i].weight < pivot.weight) {
				swap(edges, i, pIndex);
				pIndex++;
			}
		}
		swap(edges, end, pIndex);
		return pIndex;
	}

	public void swap(Edge[] edges, int index1, int index2) {
		Edge temp = edges[index1];
		edges[index1] = edges[index2];
		edges[index2] = temp;
	}

	public void kruskal() {
		Edge[] edges = new Edge[edgeNum];
		int i = 0;
		while (edgeList != null) {
			edges[i] = edgeList;
			++i;
			edgeList = edgeList.next;
		}
		quicksort(edges, 0, edgeNum - 1);
		for (i = 0; i < edgeNum; ++i) {
			Vertex u = findSet(edges[i].src);
			Vertex v = findSet(edges[i].dst);
			if (u != v) {
				System.out.println(edges[i].src.name + " - " + edges[i].dst.name + " weight " + edges[i].weight);
				union(u, v);
			}
		}
	}
}
