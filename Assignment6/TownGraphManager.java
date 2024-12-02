import java.util.*;
import java.io.*;

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

public class TownGraphManager implements TownGraphManagerInterface
{
	private Graph graph;
	
	/**
	 * Default no-arg constructor initializes graph to represent town map
	 */
	public TownGraphManager()
	{
		graph = new Graph();
	}
	
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) 
	{
		Town town1a = getTown(town1);
		Town town2a = getTown(town2);
		graph.addEdge(town1a, town2a, weight, roadName);
		return true;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) 
	{
		Town town1a = getTown(town1);
		Town town2a = getTown(town2);
		Road road = graph.getEdge(town1a, town2a);
		
		for (Road r : graph.edgesOf(town1a))
		{
			if (r.getDestination().equals(town2a) || r.getSource().equals(town2a))
				return road.getName();
		}
		return null;
	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) 
	{
		Town town1a = new Town(v);
		return graph.addVertex(town1a);
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) 
	{
		Town town1a = new Town(name);
		for (Town town : graph.vertexSet())
		{
			if (town1a.equals(town))
			{
				return town;
			}
		}
		return null;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) 
	{
		Town town1a = new Town(v);
		return graph.containsVertex(town1a);
	}

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) 
	{
		Town town1a = getTown(town1);
		Town town2a = getTown(town2);
		return graph.containsEdge(town1a, town2a);
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() 
	{
		ArrayList<String> roads = new ArrayList<>();
		for (Road road : graph.edgeSet())
		{
			roads.add(road.getName());
		}
		Collections.sort(roads);
		return roads;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) 
	{
		Town town1a = getTown(town1);
		Town town2a = getTown(town2);
		
		if (graph.containsEdge(town1a, town2a))
		{
			Road road1 = graph.getEdge(town1a, town2a);
			Road road2 = graph.removeEdge(town1a, town2a, road1.getWeight(), road);
			
			if (road2.equals(road1))
				return true;
		}
		return false;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) 
	{
		Town town1a = new Town(v);
		return graph.removeVertex(town1a);
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() 
	{
		ArrayList<String> towns = new ArrayList<>();
		for (Town town : graph.vertexSet())
		{
			towns.add(town.getName());
		}
		
		Collections.sort(towns);
		return towns;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) 
	{
		Town town1a = getTown(town1);
		Town town2a = getTown(town2);
		
		ArrayList<String> path = graph.shortestPath(town1a, town2a);
		return path;
	}
	
	/**
	 * Method to populate the town graph
	 * @param input - File that contains the towns
	 * @throws FileNotFoundException if the file is NOT found
	 */
	public void populateTownGraph(File input) throws FileNotFoundException
	{
		ArrayList<String> record = new ArrayList<>();
		
		if (input == null || !input.exists())
		{
			throw new FileNotFoundException();
		}
		
		Scanner scanner = new Scanner(input);
		while (scanner.hasNextLine())
		{
			record.add(scanner.nextLine());
		}
		
		for (String line : record)
		{
			String[] split = line.split(";");
			int deliminator = split[0].indexOf(",");
			String rName = split[0].substring(0, deliminator);
			String weight = split[0].substring(deliminator+1,split[0].length());
			String source = split[1];
			String destination = split[2];
			
			addTown(source);
			addTown(destination);
			addRoad(source, destination, Integer.parseInt(weight), rName);
		}
		
		scanner.close();
	}
}
