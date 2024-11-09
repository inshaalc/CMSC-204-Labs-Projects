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
import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface manager;

    @Before
    public void setUp() throws Exception {
        manager = new CourseDBManager();
    }

    @After
    public void tearDown() throws Exception {
        manager = null;
    }

    @Test
    public void testAddToDB() {
        try {
            manager.add("CMSC204", 30504, 4, "SC100", "Dr. Smith");
        } catch (Exception e) {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testShowAll() {
        manager.add("CMSC204", 30504, 4, "SC100", "Dr. Smith");
        manager.add("CMSC203", 30505, 3, "SC101", "Prof. Johnson");
        ArrayList<String> list = manager.showAll();
        
        assertEquals(list.get(0), "\nCourse:CMSC204 CRN:30504 Credits:4 Instructor:Dr. Smith Room:SC100");
        assertEquals(list.get(1), "\nCourse:CMSC203 CRN:30505 Credits:3 Instructor:Prof. Johnson Room:SC101");
    }

    @Test
    public void testReadFile() {
        try {
            File inputFile = new File("testCourses.txt");
            PrintWriter writer = new PrintWriter(inputFile);
            writer.println("CMSC204 30506 3 SC102 Dr. Adams");
            writer.println("CMSC201 30507 4 SC103 Prof. Miller");
            writer.close();
            
            manager.readFile(inputFile);
            assertEquals("CMSC204", manager.get(30506).getID());
            assertEquals("Dr. Adams", manager.get(30506).getName());
            assertEquals("SC102", manager.get(30506).getRoomNum());
            assertEquals("CMSC201", manager.get(30507).getID());
            assertEquals("Prof. Miller", manager.get(30507).getName());
            assertEquals("SC103", manager.get(30507).getRoomNum());

        } catch (Exception e) {
            fail("Should not have thrown an exception");
        }
    }
}
