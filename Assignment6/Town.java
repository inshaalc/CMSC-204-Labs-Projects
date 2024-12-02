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

import java.util.HashSet;
import java.util.Set;

/**
 * Represents an town as a node of a graph. 
 * The Town class holds the name of the town and a list of adjacent towns, and other fields as desired, and the traditional methods (constructors, getters/setters, toString, etc.). 
 * It will implement the Comparable interface These are the minimum methods that are needed. Please feel free to add as many methods as you need.
 */
public class Town implements Comparable<Town>
{
	// Fields
	private String name;
	protected Set<Town> towns = new HashSet<Town>();
	protected Town previous = null;
	protected int weight = Integer.MAX_VALUE;
	
	/**
	 * Constructor - Requires Town's Name
	 * @param name - Town name
	 */
	public Town(String name)
	{
		this.name = name;
	}
	
	/**
	 * Copy constructor
	 * @param templateTown - an instance of Town
	 */
	public Town(Town templateTown)
	{
		this.name = templateTown.name;
	}
	
	/**
	 * Returns the town's name
	 * @return town's name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Compare to method
	 * @return 0 if names are equal, a positive or negative number if the names
	 * are not equal
	 */
	@Override
	public int compareTo(Town o) 
	{
		if (this.name.equals(o.name))
		{
			return 0;
		}
		else 
		{
			return -1;
		}
	}
	
	/**
	 * To string method
	 * @Override toString in class java.lang.Object
	 * @return the town name
	 */
	@Override
	public String toString()
	{
		return this.name;
	}
	
	/**
	 * HashCode method
	 * @Override hashCode in Object class
	 * @Return the hashCode for the name of the town
	 */
	@Override
	public int hashCode()
	{
		int hashCode = name.hashCode();
		return hashCode;
	}
	
	/**
	 * @Override equals in Object class
	 * @return true if the town names are equal, false if not
	 */
	public boolean equals(Object obj)
	{
		Town other = (Town) obj;
		if (this.name.equals(other.name))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
