package newP;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

/**
 * Graph class represents a graph defined by numberOfVertices and adjacency lists
 *
 * @author Delia
 */
public class Graph {
    private int numberOfVertices;
    private LinkedList<Integer> adj[];

    /**
     * Allocates memory and initializes a Graph type object
     *
     * @param numberOfVertices represents the number of vertices that the instance will have
     */
    Graph(int numberOfVertices) {
        if(numberOfVertices>0)
            this.numberOfVertices = numberOfVertices;
        else
            System.out.println("Invalid number!");

        adj = new LinkedList[numberOfVertices];
        for (int i = 0; i < numberOfVertices; ++i)
            adj[i] = new LinkedList();
    }

    /**
     * Adds an edge in the instance
     *
     * @param left represents the left end of the edge
     * @param right represents the right end of the edge
     */
    public void addEdge(int left, int right)
    {
        adj[left].add(right);
    }

    /**
     * Makes a BFS on the instance to find if there is a path into two given vertices
     *
     * @param start represents the start vertex (location)
     * @param finish represents the finish vertex (location
     * @return a boolean response true/false
     * The methos willl return true if there is a path into the given vertices, or false if there isn't this type of path
     */
    public boolean BFS(int start, int finish) {
        boolean visited[] = new boolean[numberOfVertices];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0) {
            start = queue.poll();
            //System.out.print(s + " ");

            Iterator<Integer> i = adj[start].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    if (n == finish)
                        return true;
                }
            }
        }
        return false;
    }
}
