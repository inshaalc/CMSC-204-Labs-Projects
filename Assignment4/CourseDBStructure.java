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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface 
{
    // Attributes
    public LinkedList<CourseDBElement>[] table;

    // Constructor One
    @SuppressWarnings("unchecked")
    public CourseDBStructure(int n) 
    {
        table = new LinkedList[n];
        for (int i = 0; i < n; i++) 
        {
            table[i] = new LinkedList<CourseDBElement>();
        }
    }

    // Constructor Two
    @SuppressWarnings("unchecked")
    public CourseDBStructure(String testing, int n) 
    {
        table = new LinkedList[n];
        for (int i = 0; i < n; i++) 
        {
            table[i] = new LinkedList<CourseDBElement>();
        }
    }

    /** 
    * Adds a CourseDBElement object to the CourseDBStructure using the hash code of the CRN value.
    * If the CourseDBElement already exists, exit quietly.
    * @param element the CourseDBElement to be added to CourseDBStructure.
    */
    @Override
    public void add(CourseDBElement element) 
    {
    	Integer crnAsInteger = Integer.valueOf(element.getCRN());
    	int index = Math.abs(crnAsInteger.hashCode()) % table.length;
    	
    	
    	
        LinkedList<CourseDBElement> bucket = table[index];

        if (bucket == null) 
        {
            bucket = new LinkedList<>();
            table[index] = bucket;
        }
        else
        {
        	for (int i = 0; i < bucket.size(); i++) 
            {
                if (bucket.get(i).getCRN() == element.getCRN()) 
                {
                    bucket.set(i, element);
                    return;
                }
            }
        }
        bucket.add(element);

    }

    /**
    * Find a CourseDBElement based on the key (CRN) of the CourseDBElement. 
    * If found, return it; otherwise, throw an IOException.
    * @param crn CRN (key) whose associated CourseDBElement is to be returned.
    * @return a CourseDBElement whose CRN is mapped to the key.
    * @throws IOException if the key is not found.
    */
    @Override
    public CourseDBElement get(int crn) throws IOException 
    {
        int hashCode = Integer.hashCode(crn);
        int index = Math.abs(hashCode % getTableSize());
        
        if (index < 0 || index >= getTableSize()) 
        {
            throw new IOException("Invalid index calculated for CRN: " + crn);
        }
        
        if (table[index] == null || table[index].isEmpty()) 
        {
            System.out.println("No elements at index: " + index);
        }
        

        for (CourseDBElement element : table[index]) 
        {
            if (element.getCRN() == crn)
            {
                return element;
            }
        }

        throw new IOException("CRN not found: " + crn);
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
    	ArrayList<String> courseSchedule = new ArrayList<>();
    	
    	for (LinkedList<CourseDBElement> bucket : table)
    	{
    		if (bucket != null)
    		{
    			for (CourseDBElement element : bucket)
    			{
    				String info = "\n" + "Course:" + element.getID()
    									+ " CRN:" + element.getCRN()
    									+ " Credits:" + element.numCredits()
    									+ " Instructor:" + element.getName()
    									+ " Room:" + element.getRoomNum();
    				courseSchedule.add(info);
    			}
    		}
    	}
    	return courseSchedule;
    }

    /**
    * Returns the size of the CourseDBStructure (number of indexes in the array).
    */
    @Override
    public int getTableSize() 
    {
        return table.length;
    }
}
