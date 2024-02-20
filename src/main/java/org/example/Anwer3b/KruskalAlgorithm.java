package org.example.Anwer3b;

import java.util.*;

// Class to represent an edge in the graph
class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

public class KruskalAlgorithm {
    // Function to find the minimum spanning tree using Kruskal's algorithm
    public static List<Edge> kruskalMST(List<Edge> edges, int vertices) {
        // Initialize result list for the minimum spanning tree
        List<Edge> result = new ArrayList<>();

        // Sort edges based on their weights using a custom comparator
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

        // Create a UnionFind instance
        UnionFind unionFind = new UnionFind(vertices);

        // Perform Kruskal's algorithm
        for (Edge edge : edges) {
            int sourceRep = unionFind.find(edge.source);
            int destRep = unionFind.find(edge.destination);

            // If including this edge does not create a cycle, add it to the result
            if (sourceRep != destRep) {
                result.add(edge);
                unionFind.union(sourceRep, destRep);
            }
        }

        return result;
    }

    // Class representing a union-find data structure
    static class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int vertex) {
            if (parent[vertex] != vertex) {
                parent[vertex] = find(parent[vertex]);
            }
            return parent[vertex];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }
    }

    // Priority queue implementation using minimum heap for efficient processing of
    // edges
    static class PriorityQueueMinHeap {
        private final List<Edge> heap;

        PriorityQueueMinHeap() {
            heap = new ArrayList<>();
        }

        // Add an edge to the priority queue
        void add(Edge edge) {
            heap.add(edge);
            int current = heap.size() - 1;
            while (current > 0 && heap.get(current).weight < heap.get((current - 1) / 2).weight) {
                Collections.swap(heap, current, (current - 1) / 2);
                current = (current - 1) / 2;
            }
        }

        // Remove and return the edge with the minimum weight from the priority queue
        Edge removeMin() {
            if (heap.isEmpty()) {
                throw new NoSuchElementException("Priority queue is empty");
            }
            Edge min = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            minHeapify(0);
            return min;
        }

        // Perform min-heapify operation to maintain the heap property
        private void minHeapify(int index) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < heap.size() && heap.get(left).weight < heap.get(smallest).weight) {
                smallest = left;
            }
            if (right < heap.size() && heap.get(right).weight < heap.get(smallest).weight) {
                smallest = right;
            }
            if (smallest != index) {
                Collections.swap(heap, index, smallest);
                minHeapify(smallest);
            }
        }

        // Check if the priority queue is empty
        boolean isEmpty() {
            return heap.isEmpty();
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Example usage of Kruskal's algorithm
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int vertices = 4;
        List<Edge> minimumSpanningTree = kruskalMST(edges, vertices);

        System.out.println("Edges in the Minimum Spanning Tree:");
        for (Edge edge : minimumSpanningTree) {
            System.out.println(edge.source + " - " + edge.destination + " : " + edge.weight);
        }

        // Example usage of priority queue using minimum heap
        PriorityQueueMinHeap priorityQueue = new PriorityQueueMinHeap();
        priorityQueue.add(new Edge(0, 1, 10));
        priorityQueue.add(new Edge(0, 2, 6));
        priorityQueue.add(new Edge(0, 3, 5));
        priorityQueue.add(new Edge(1, 3, 15));
        priorityQueue.add(new Edge(2, 3, 4));

        System.out.println("Edges removed from Priority Queue:");
        while (!priorityQueue.isEmpty()) {
            Edge minEdge = priorityQueue.removeMin();
            System.out.println(minEdge.source + " - " + minEdge.destination + " : " + minEdge.weight);
        }
    }
}

