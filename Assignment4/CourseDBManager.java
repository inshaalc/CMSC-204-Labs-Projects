/*
 * Class: CMSC 204 
 * Instructor: Huseiyn Aygun 
 * Description: Write a program that creates a database of courses. 
 * It will either read from a file of courses or allow the user to add one course at a time. 
 * Due: 10/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Inshaal Chaudhury
*/
/*
 * @author Inshaal Chaudhury
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface
{
	// Attributes
	private CourseDBStructure courseDBS;
	private int default_size = 20;
	
	/**
	 * Constructor for CourseDBManager initializing the size to 10
	 */
	public CourseDBManager()
	{
		courseDBS = new CourseDBStructure(default_size);
	}
	
	/**
	 * Adds a course (CourseDBElement) with the given information
	 * to CourseDBStructure.
	 * @param id course id 
	 * @param crn course crn
	 * @param credits number of credits
	 * @param roomNum course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) 
	{
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		courseDBS.add(element);
	}

	/**
	 * finds  CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 */
	@Override
	public CourseDBElement get(int crn) 
	{
		try
		{
			return courseDBS.get(crn);
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		try (Scanner read = new Scanner(input))
		{
			while (read.hasNextLine())
			{
				String line = read.nextLine();
				String[] data = line.split(" ", 5);
				CourseDBElement element = new CourseDBElement(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], data[4]);
				courseDBS.add(element);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Refer to the following example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 * Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		return courseDBS.showAll();
	}
}
