/*
 * Class: CMSC 204 
 * Instructor: Huseiyn Aygun 
 * Description: In this project you will be creating an application to maintain a network of towns and the roads connecting them. 
 * The application will use Dijkstra’s Shortest Path algorithm to find the shortest distance between any two towns. 
 * Upload the initial files and your working files to the repository in GitHub you created in Lab 1, in a directory named Assignment6. 
 * Due: 12/1/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Inshaal Chaudhury
*/
/*
 * @author Inshaal Chaudhury
 */

import java.util.*;

public class Graph implements GraphInterface<Town, Road>
{
	private Map<Town, List<Road>> adjacencyList;
	private Map<Town, Integer> distances;
	private Map<Town, Town> predecessors;
	
	/**
	 * Constructor
	 */
	public Graph()
	{
		adjacencyList = new HashMap<>();
	}

	/**
	 * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return an edge connecting source vertex to target vertex.
	 */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) 
	{
		for (Road road : adjacencyList.get(sourceVertex))
		{
			if (road.getSource().equals(destinationVertex) || road.getDestination().equals(destinationVertex))
			{
				return road;
			}
		}
		return null;
	}

	/**
	 * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     * @return The newly created edge if added to the graph, otherwise null.
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
	 */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException("Vertices cannot be null");
		if (!adjacencyList.containsKey(sourceVertex) || !adjacencyList.containsKey(destinationVertex))
			throw new IllegalArgumentException("Both vertices must be in the graph");
		
		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		adjacencyList.get(sourceVertex).add(road);
		adjacencyList.get(destinationVertex).add(road);
		return road;
	}

	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     * @param v vertex to be added to this graph.
     * @return true if this graph did not already contain the specified
     * vertex.
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) 
	{
		if (v == null)
			throw new NullPointerException("Vertex cannot be null");
		if (adjacencyList.containsKey(v))
			return false;
		adjacencyList.put(v, new ArrayList<>());
		
		return true;
	}

	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) 
	{
		return getEdge(sourceVertex, destinationVertex) != null;
	}

	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     * @param v vertex whose presence in this graph is to be tested.
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) 
	{
		return adjacencyList.containsKey(v);
	}

	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() 
	{
		Set<Road> edges = new HashSet<>();
		for (List<Road> roads : adjacencyList.values())
		{
			edges.addAll(roads);
		}
		return edges;
	}

	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     * @return a set of all edges touching the specified vertex.
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) 
	{
		if (vertex == null)
		{
			throw new NullPointerException("Vertex is null");
		}
		else if (!adjacencyList.containsKey(vertex))
		{
			throw new IllegalArgumentException("Vertex not found");
		}
		
		return new HashSet<>(adjacencyList.get(vertex));
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * Returns the edge if removed
     * or null otherwise.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) 
	{
		Road removeRoad = new Road(sourceVertex, destinationVertex, weight, description);
		List<Road> sourceEdges = adjacencyList.get(sourceVertex);
		List<Road> destinationEdges = adjacencyList.get(destinationVertex);
		
		if (sourceEdges != null && sourceEdges.remove(removeRoad))
		{
			destinationEdges.remove(removeRoad);
			return removeRoad;
		}
		return null;
	}

	/**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     * If the specified vertex is null returns false.
     * @param v vertex to be removed from this graph, if present.
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	@Override
	public boolean removeVertex(Town v) 
	{
		if (!adjacencyList.containsKey(v))
			return false;
		
		for (Road road : new ArrayList<>(adjacencyList.get(v)))
		{
			removeEdge(road.getSource(), road.getDestination(), road.getWeight(), road.getName());
		}
		adjacencyList.remove(v);
		return true;
	}

	/**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() 
	{
		return adjacencyList.keySet();
	}

	/**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */   
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) 
	{
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> path = new ArrayList<>();
		Town step = destinationVertex;
		
		if (distances.get(step) == Integer.MAX_VALUE)
		{
			return path;
		}
		
		while (step != null && predecessors.get(step) != null)
		{
			Town prev = predecessors.get(step);
			Road road = getEdge(prev, step);
			
			if (road != null)
			{
				path.add(0, prev.getName() + " via " + road.getName() + " to " + step.getName() + " " + road.getWeight() + " mi");
			}
			step = prev;
		}
		return path;
	}

	/**
     * Dijkstra's Shortest Path Method.  Internal structures are built which
     * hold the ability to retrieve the path, shortest distance from the
     * sourceVertex to all the other vertices in the graph, etc.
     * @param sourceVertex the vertex to find shortest path from
     */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) 
	{
		distances = new HashMap<>();
		predecessors = new HashMap<>();
		PriorityQueue<Town> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));
		
		for (Town town : adjacencyList.keySet())
		{
			distances.put(town, Integer.MAX_VALUE);
			predecessors.put(town, null);
		}
		distances.put(sourceVertex, 0);
		pq.add(sourceVertex);
		
		while(!pq.isEmpty())
		{
			Town current = pq.poll();
			
			for (Road road : adjacencyList.get(current))
			{
				Town neighbor = road.getSource().equals(current) ? road.getDestination() : road.getSource();

				int newDist = distances.get(current) + road.getWeight();				
				if (newDist < distances.get(neighbor))
				{
					distances.put(neighbor, newDist);
					predecessors.put(neighbor, current);
					pq.remove(neighbor);
					pq.add(neighbor);
				}
			}
		}
	}
}
