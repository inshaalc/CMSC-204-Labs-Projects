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
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CourseDBStructureTest_STUDENT_Test {
    private CourseDBStructure structure;

    @BeforeEach
    void setUp() throws Exception {
        structure = new CourseDBStructure(20);
    }

    @AfterEach
    void tearDown() throws Exception {
        structure = null;
    }

    @Test
    void testAddAndGet() {
        CourseDBElement element1 = new CourseDBElement("CMSC204", 30504, 4, "SC100", "Dr. Smith");
        CourseDBElement element2 = new CourseDBElement("CMSC203", 30505, 3, "SC101", "Prof. Johnson");
        
        structure.add(element1);
        structure.add(element2);
        
        try {
            assertEquals(element1, structure.get(30504));
            assertEquals(element2, structure.get(30505));
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testCollisionHandling() {
        CourseDBElement element1 = new CourseDBElement("CMSC204", 30504, 4, "SC100", "Dr. Smith");
        CourseDBElement element2 = new CourseDBElement("CMSC203", 30504, 3, "SC101", "Prof. Johnson"); // Same CRN to test collision
        
        structure.add(element1);
        structure.add(element2);
        
        try {
            assertEquals(element2, structure.get(30504), "Collision handling failed");
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testGetNonExistentCRN() {
        assertThrows(IOException.class, () -> {
            structure.get(12345); // CRN not added, should throw IOException
        });
    }

    @Test
    void testShowAll() {
        CourseDBElement element1 = new CourseDBElement("CMSC204", 30504, 4, "SC100", "Dr. Smith");
        CourseDBElement element2 = new CourseDBElement("CMSC203", 30505, 3, "SC101", "Prof. Johnson");

        structure.add(element1);
        structure.add(element2);

        assertTrue(structure.showAll().contains("\nCourse:CMSC204 CRN:30504 Credits:4 Instructor:Dr. Smith Room:SC100"));
        assertTrue(structure.showAll().contains("\nCourse:CMSC203 CRN:30505 Credits:3 Instructor:Prof. Johnson Room:SC101"));
    }
}
