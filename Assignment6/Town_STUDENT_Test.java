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

public class Town_STUDENT_Test 
{
    private Town town;

    @Before
    public void setUp() throws Exception {
        town = new Town("Bethesda");         
    }

    @After
    public void tearDown() throws Exception {
        town = null;
    }

    @Test
    public void testGetName() {
        assertEquals("Bethesda", town.getName());
    }

    @Test
    public void testToString() {
        assertEquals("Bethesda", town.toString());
    }

    @Test
    public void testEquals() {
        Town town2 = new Town("Bethesda");
        assertTrue(town.equals(town2));
        
        Town town3 = new Town("Rockville");
        assertFalse(town.equals(town3));
    }

    @Test
    public void testCompareTo() {
        Town town2 = new Town("Rockville");
        assertTrue(town.compareTo(town2) != 0);

        Town town3 = new Town("Bethesda");
        assertEquals(0, town.compareTo(town3));
    }
}
