/*
 * Class: CMSC 204 
 * Instructor: Huseiyn Aygun 
 * Description: Write a program that creates a database of courses. 
 * It will either read from a file of courses or allow the user to add one course at a time. 
 * Due: 10/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Inshaal Chaudhury
 */
/*
 * @author Inshaal Chaudhury
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface 
{
	String courseId;
	int CRN;
	int numCredits;
	String roomNum;
	String instructor;
	
	CourseDBStructure courseDB;
	
	public CourseDBManager() 
	{
		courseDB = new CourseDBStructure(20);
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
		CourseDBElement course = new CourseDBElement(id, crn, credits, roomNum, instructor);
		courseDB.add(course);
	}

	/**
	 * Finds CourseDBElement based on the crn key
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 */
	@Override
	public CourseDBElement get(int crn) 
	{
		try 
		{
			return courseDB.get(crn);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads the information of courses from a test file and adds them
	 * to the CourseDBStructure data structure
	 * @param input input file 
	 * @throws FileNotFoundException if file does not exist
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException 
	{
		Scanner scanner = new Scanner(input);
		String[] arr;
		while(scanner.hasNextLine())
		{
			String s = scanner.nextLine();
			
			arr = s.split(" ",5);
			courseId = arr[0];
			CRN = Integer.valueOf(arr[1]);
			numCredits = Integer.valueOf(arr[2]);
			roomNum = arr[3];
			instructor = arr[4];
			CourseDBElement c = new CourseDBElement(courseId, CRN, numCredits, roomNum, instructor);
			courseDB.add(c);
		}
		scanner.close();
	}

	/**
	 * @return an array list of string representation of each course in 
	 * the data structure separated by a new line. 
	 * Example:
	 * Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular Room:SC100
	 */
	@Override
	public ArrayList<String> showAll() 
	{
		return courseDB.showAll();
	}
}
