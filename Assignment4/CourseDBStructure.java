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

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface
{
    // Attributes
    public int numberCourses;
    private final double MAX_LOADING_FACTOR = 1.5;
    public LinkedList<CourseDBElement>[] hashTable;
    private int tableSize;
    private String testing;
    
    /**
     * A constructor that takes in an integer n which represents the estimated number of 
     * courses and determines the size of the hash table by finding a 4K+3 prime just greater than n /loading factor.
     * Example:  if n is 500 courses, then 500/1.5 = 333, The next 4K+3 prime over 333 is 347.  So, you would set the table a length to 347.
     * @param n Number of courses
     */
    @SuppressWarnings("unchecked")
    public CourseDBStructure(int n)
    {
        // Divides number of courses by 1.5 and rounds it up
        int targetSize = (int) Math.ceil((n) / MAX_LOADING_FACTOR);
        // Finds next 4k+3 prime over target size
        targetSize += 3 - (targetSize % 4);
        
        // If it is not prime, keeps adding 4 until next 4k+3 is found
        while (!isPrime(targetSize))
        {
            targetSize += 4;
        }
        
        this.tableSize = targetSize;
        
        // Creates hashtable using a linkedList the size of the target size
        // For every element in hashtable, courseDBElement is assigned
        hashTable = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++)
        {
            hashTable[i] = new LinkedList<CourseDBElement>();
        }
    }
    
    /**
     * Helper method calculates whether targetSize is a prime number
     * @param targetSize
     * @return true if prime, false if not prime
     */
    public boolean isPrime(int n)
    {
        // If less than or equal to 1, not prime
        if (n <= 1)
            return false;
        // If either 2 or 3, is prime
        if (n <= 3)
            return true;
        // If either divisible by 2 or 3, not prime
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        
        // For loop checks divisors from 5 to the square root of n to see if n is divisble by i. If so, not prime
        for (int i = 5; i * i <= n; i += 2)
        {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
    
    /**
     * A Constructor for testing purposes. 
     * This constructor will take a string "Testing" and an int for the hashTable size. This is used only for testing.
     * @param testing
     * @param n HashTable size 
     */
    @SuppressWarnings("unchecked")
    public CourseDBStructure(String testing, int n)
    {
        this.testing = testing;
        tableSize = n;
        
        hashTable = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++)
        {
            hashTable[i] = new LinkedList<CourseDBElement>();
        }
    }
    
    /** 
     * Adds a CourseDBElement object to the CourseDBStructure using the 
     * hashcode of the CourseDatabaseElemen object's crn value.
     * If the CourseDatabaseElement already exists, exit quietly
     * @param element the CourseDBElement to be added to CourseDBStructure
     */
    @Override
    public void add(CourseDBElement element) 
    {
        int key = element.getCRN();
        int index = Math.abs(key) % hashTable.length;
        
        if (hashTable[index] == null)
            hashTable[index] = new LinkedList<>();
        
        for (CourseDBElement existingElement : hashTable[index])
        {
            if (existingElement.getCRN() == element.crn)
            {
                hashTable[index].remove(existingElement);
                hashTable[index].add(element);
                return;
            }
        }
        
        hashTable[index].add(element);
    }

    /**
     * Find a courseDatabaseElement based on the key (crn) of the
     * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
     * throw an IOException.
     * @param crn crn (key) whose associated courseDatabaseElement is to be returned
     * @return a CourseDBElement whose crn is mapped to the key
     * @throws IOException if key is not found
     */
    @Override
    public CourseDBElement get(int crn) throws IOException 
    {
        int index = Math.abs(crn) % tableSize;
        
        LinkedList<CourseDBElement> bucket = hashTable[index];
        
        if (bucket == null)
            throw new IOException("Course not found");
        
        for (CourseDBElement element : bucket)
        {
            if (element.getCRN() == crn)
                return element;
        }
        
        throw new IOException("Course not found");
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
        ArrayList<String> courseList = new ArrayList<>();
        
        for (LinkedList<CourseDBElement> bucket : hashTable)
        {
            if (bucket != null)
            {
                for (CourseDBElement element : bucket)
                {
                    String courseInfo = "\nCourse:" + element.getID() +
                                        " CRN:" + element.getCRN() +
                                        " Credits:" + element.numCredits() +
                                        " Instructor:" + element.getName() +
                                        " Room:" + element.getRoomNum();
                    courseList.add(courseInfo);
                }
            }
        }
        return courseList;
    }

    /**
     * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
     */
    @Override
    public int getTableSize() 
    {
        return tableSize;
    }
}
