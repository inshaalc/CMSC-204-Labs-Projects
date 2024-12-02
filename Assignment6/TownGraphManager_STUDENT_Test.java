import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

public class TownGraphManager_STUDENT_Test 
{

    private TownGraphManagerInterface graph;
    private String[] town;

    @BeforeEach
    void setUp() throws Exception {
        graph = new TownGraphManager();
        town = new String[7]; 

        for (int i = 1; i <= 6; i++) {
            town[i] = "Town_" + i;
            graph.addTown(town[i]);
        }

        graph.addRoad(town[1], town[2], 2, "Road_1");
        graph.addRoad(town[1], town[3], 4, "Road_2");
        graph.addRoad(town[2], town[4], 6, "Road_3");
        graph.addRoad(town[3], town[5], 3, "Road_4");
        graph.addRoad(town[4], town[6], 5, "Road_5");
        graph.addRoad(town[5], town[6], 2, "Road_6");
    }

    @AfterEach
    void tearDown() throws Exception {
        graph = null;
    }

    @Test
    void testAddRoad() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Road_1", roads.get(0));
        assertEquals("Road_2", roads.get(1));
        assertEquals("Road_3", roads.get(2));
        assertEquals("Road_4", roads.get(3));
        assertEquals("Road_5", roads.get(4));
        assertEquals("Road_6", roads.get(5));

        graph.addRoad(town[1], town[6], 8, "Road_7");
        roads = graph.allRoads();

        assertEquals("Road_1", roads.get(0));
        assertEquals("Road_2", roads.get(1));
        assertEquals("Road_3", roads.get(2));
        assertEquals("Road_4", roads.get(3));
        assertEquals("Road_5", roads.get(4));
        assertEquals("Road_6", roads.get(5));
        assertEquals("Road_7", roads.get(6));
    }

    @Test
    void testGetRoad() {
        assertEquals("Road_3", graph.getRoad(town[2], town[4]));
        assertEquals("Road_6", graph.getRoad(town[5], town[6]));
    }

    @Test
    void testAddTown() {
        assertFalse(graph.containsTown("Town_7"));
        graph.addTown("Town_7");
        assertTrue(graph.containsTown("Town_7"));
    }

    @Test
    void testContainsTown() {
        assertTrue(graph.containsTown("Town_2"));
        assertFalse(graph.containsTown("Town_7"));
    }

    @Test
    void testContainsRoadConnection() {
        assertTrue(graph.containsRoadConnection(town[2], town[4]));
        assertFalse(graph.containsRoadConnection(town[1], town[6]));
    }

    @Test
    void testAllRoads() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Road_1", roads.get(0));
        assertEquals("Road_2", roads.get(1));
        assertEquals("Road_3", roads.get(2));
        assertEquals("Road_6", roads.get(5));
    }

    @Test
    void testDeleteRoadConnection() {
        assertTrue(graph.containsRoadConnection(town[2], town[4]));
        graph.deleteRoadConnection(town[2], town[4], "Road_3");
        assertFalse(graph.containsRoadConnection(town[2], town[4]));
    }

    @Test
    void testDeleteTown() {
        assertTrue(graph.containsTown("Town_2"));
        graph.deleteTown(town[2]);
        assertFalse(graph.containsTown("Town_2"));
    }

    @Test
    void testAllTowns() {
        ArrayList<String> townsList = graph.allTowns();
        assertEquals("Town_1", townsList.get(0));
        assertEquals("Town_6", townsList.get(5));
    }

    @Test
    void testGetPath() {
        ArrayList<String> path = graph.getPath(town[1], town[6]);
        
        assertNotNull(path);
        assertEquals(3, path.size()); 

        assertEquals("Town_1 via Road_2 to Town_3 4 mi", path.get(0).trim());  
        assertEquals("Town_3 via Road_4 to Town_5 3 mi", path.get(1).trim());  
        assertEquals("Town_5 via Road_6 to Town_6 2 mi", path.get(2).trim()); 
    }

    @Test
    void testGetPathA() {
        ArrayList<String> path = graph.getPath(town[1], town[5]);
        assertNotNull(path);
        assertTrue(path.size() > 0);
        assertEquals("Town_1 via Road_2 to Town_3 4 mi", path.get(0).trim());
        assertEquals("Town_3 via Road_4 to Town_5 3 mi", path.get(1).trim());
    }

    @Test
    void testGetPathB() {
        ArrayList<String> path = graph.getPath(town[2], town[6]);
        assertNotNull(path);
        assertTrue(path.size() > 0);
        assertEquals("Town_2 via Road_3 to Town_4 6 mi", path.get(0).trim());
        assertEquals("Town_4 via Road_5 to Town_6 5 mi", path.get(1).trim());
    }
}
