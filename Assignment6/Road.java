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

public class Road extends Object implements Comparable<Road>
{
	//Fields
	private Town source;
	private Town destination;
	private String name;
	private int weight;
	
	/**
	 * Constructor
	 * @param source
	 * @param destination
	 * @param degrees
	 * @param name
	 */
	public Road(Town source, Town destination, int weight, String name)
	{
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}
	
	/**
	 * Constructor with weight preset at 1
	 * @param source - One town on the road
	 * @param destination = Another town on the road
	 * @param name - Name of the road
	 */
	public Road(Town source, Town destination, String name)
	{
		this.source = source;
		this.destination = destination;
		this.name = name;
		weight = 1;
	}
	
	/**
	 * Returns true only if the edge contains the given town
	 * @param town - a vertex of the graph
	 * @return true only if the edge is connected to the given vertex
	 */
	public boolean contains(Town town)
	{
		return town.equals(source)|| town.equals(destination);
	}
	
	/**
	 * To string method
	 * @Override toString in Object class
	 */
	public String toString()
	{
		return "The road " + this.name + " is " + this.weight + " miles long and starts at " + this.source + " and it ends at " + this.destination;
	}
	
	/**
	 * Returns the road name
	 * @return The name of the road
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the second town on the road
	 * @return A town on the road
	 */
	public Town getDestination()
	{
		return destination;
	}
	
	/**
	 * Returns the first town on the road
	 * @return A town on the road
	 */
	public Town getSource()
	{
		return source;
	}
	
	/**
	 * Specified By: CompareTo interface Comparable<Road>
	 * @return 0 if the road names are the same, a positive or negative number
	 * if road names aren't the same
	 */
	@Override
	public int compareTo(Road o) 
	{
		return this.weight - o.getWeight();
	}
	
	/**
	 * Returns the distance of the road
	 * @return the distance of the road
	 */
	public int getWeight()
	{
		return weight;
	}
	
	/**
	 * Returns true if each of the ends of the road r is the same as the ends of this road
	 * Remember that a road that goes from point A to point B is the same as a road that goes from
	 * point B to point A.
	 * @Override equals in class Object
	 * @param r - road object to compare it to
	 */
	public boolean equals(Object r)
	{
		Road other = (Road) r;
		if ((this.source.equals(other.source) && this.destination.equals(other.destination)) || (this.source.equals(other.destination) && this.destination.equals(other.source)))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}
}
