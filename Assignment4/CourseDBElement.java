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
public class CourseDBElement implements Comparable<CourseDBElement>
{
	// Attributes
	protected String courseID;
	protected int crn;
	protected int numCredits;
	protected String roomNum;
	protected String instructorName;
	
	
	
	/**
	 * Constructor
	 * @param courseID
	 * @param crn
	 * @param numCredits
	 * @param roomNum
	 * @param instructorName
	 */
	public CourseDBElement(String courseID, int crn, int numCredits, String roomNum, String instructorName)
	{
		this.courseID = courseID;
		this.crn = crn;
		this.numCredits = numCredits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
	}
	
	public CourseDBElement() 
	{
		// TODO Auto-generated constructor stub
	}

	// Setters & Getter Methods
	/**
	 * Set's courseID
	 * @param courseID
	 */
	public void setID(String courseID)
	{
		this.courseID = courseID;
	}
	
	/**
	 * Sets course CRN
	 * @param crn
	 */
	public void setCRN(int crn)
	{
		this.crn = crn;
	}
	
	/**
	 * Sets number of credits
	 * @param numCredits
	 */
	public void setCredits(int numCredits)
	{
		this.numCredits = numCredits;
	}
	
	/**
	 * Sets Room Number
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum)
	{
		this.roomNum = roomNum;
	}
	
	/**
	 * Sets Instructor Name
	 * @param instructorName
	 */
	public void setInstructorName(String instructorName)
	{
		this.instructorName = instructorName;
	}
	
	/**
	 * Returns course id number
	 * @return courseID
	 */
	public String getID()
	{
		return courseID;
	}
	
	/**
	 * Returns crn number
	 * @return crn
	 */
	public int getCRN()
	{
		return crn;
	}
	
	/**
	 * Returns the number of credits taken
	 * @return numCredits
	 */
	public int numCredits()
	{
		return numCredits;
	}
	
	/**
	 * Returns room number
	 * @return roomNum
	 */
	public String getRoomNum()
	{
		return roomNum;
	}
	
	/**
	 * Returns name of instructor
	 * @return instructorName
	 */
	public String getName()
	{
		return instructorName;
	}
	
	/**
	 * Puts all attributes into single string
	 * @return String of all elements in the CourseDBElement object
	 */
	public String toString()
	{
		return "CourseDBElement contains: " + "Course ID: " + courseID + ", CRN Number; " + crn
				+ ", Number of Credits: " + numCredits + ", Room Number: " + roomNum 
				+ ", Instructor Name: " + instructorName;
	}
	
	@Override
	/**
	 * Compares two course objects's crn numbers to determine if they're equal, less than, or greater than one another
	 * @return integer representing whether their equivalence status
	 */
	public int compareTo(CourseDBElement o) 
	{
		return Integer.compare(this.crn, crn);
	}
	
	/**
	 * Returns the hash code from the course CRN
	 */
	public int hashCode()
	{
		String key = Integer.toString(crn);
		return key.hashCode();
	}
}
