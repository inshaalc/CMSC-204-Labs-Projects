import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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

public class Road_STUDENT_Test 
{
    private Road road;
    private Town town1;
    private Town town2;

    @Before
    public void setUp() throws Exception 
    {
        town1 = new Town("Bethesda");
        town2 = new Town("Silver Spring");
        road = new Road(town1, town2, 3, "495");
    }

    @After
    public void tearDown() throws Exception {
        road = null;
        town1 = null;
        town2 = null;
    }

    @Test
    public void testGetName() {
        assertEquals("495", road.getName());
    }

    @Test
    public void testGetSource() {
        assertEquals(town1, road.getSource());
    }

    @Test
    public void testGetWeight() {
        assertEquals(3, road.getWeight());
    }

    @Test
    public void testGetDestination() {
        assertEquals(town2, road.getDestination());
    }

    @Test
    public void testEquals() {
        Road road2 = new Road(town1, town2, 3, "495");
        assertTrue(road.equals(road2));
    }

    @Test
    public void testContains() {
        assertTrue(road.contains(town2));
    }

    @Test
    public void testToString() {
        assertEquals("The road 495 is 3 miles long and starts at Bethesda and it ends at Silver Spring", road.toString());
    }

    @Test
    public void testCompareTo() {
        Road road2 = new Road(town1, town2, 4, "495");
        assertTrue(road.compareTo(road2) < 0);
    }
}
