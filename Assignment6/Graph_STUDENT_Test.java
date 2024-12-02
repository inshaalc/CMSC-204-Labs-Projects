import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

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

public class Graph_STUDENT_Test 
{
    private GraphInterface<Town, Road> graph;
    private Town[] towns;

    @Before
    public void setUp() throws Exception {
        graph = new Graph();
        towns = new Town[6]; 

        for (int i = 1; i < 6; i++) {
            towns[i] = new Town("Town_" + i);
            graph.addVertex(towns[i]);
        }

        graph.addEdge(towns[1], towns[2], 3, "Road_A");
        graph.addEdge(towns[1], towns[3], 1, "Road_B");
        graph.addEdge(towns[2], towns[4], 2, "Road_C");
        graph.addEdge(towns[3], towns[4], 4, "Road_D");
        graph.addEdge(towns[4], towns[5], 1, "Road_E");
    }

    @After
    public void tearDown() throws Exception {
        graph = null;
    }

    @Test
    public void testGetEdge() {
        assertEquals(new Road(towns[1], towns[2], 3, "Road_A"), graph.getEdge(towns[1], towns[2]));
        assertEquals(new Road(towns[3], towns[4], 4, "Road_D"), graph.getEdge(towns[3], towns[4]));
    }

    @Test
    public void testAddEdge() {
        assertFalse(graph.containsEdge(towns[2], towns[5]));
        graph.addEdge(towns[2], towns[5], 5, "Road_F");
        assertTrue(graph.containsEdge(towns[2], towns[5]));
    }

    @Test
    public void testContainsVertex() {
        assertTrue(graph.containsVertex(new Town("Town_1")));
        assertFalse(graph.containsVertex(new Town("Town_6"))); 
    }

    @Test
    public void testEdgeSet() {
        Set<Road> roads = graph.edgeSet();
        ArrayList<String> roadNames = new ArrayList<>();
        for (Road road : roads) {
            roadNames.add(road.getName());
        }
        Collections.sort(roadNames);
        assertEquals("Road_A", roadNames.get(0));
        assertEquals("Road_B", roadNames.get(1));
        assertEquals("Road_E", roadNames.get(4));
    }

    @Test
    public void testShortestPathTown1ToTown5() {
        ArrayList<String> path = graph.shortestPath(towns[1], towns[5]);
        assertNotNull(path);
        assertEquals("Town_1 via Road_B to Town_3 1 mi", path.get(0).trim());
        assertEquals("Town_3 via Road_D to Town_4 4 mi", path.get(1).trim());
        assertEquals("Town_4 via Road_E to Town_5 1 mi", path.get(2).trim());
    }

    @Test
    public void testShortestPathTown2ToTown5() {
        ArrayList<String> path = graph.shortestPath(towns[2], towns[5]);
        assertNotNull(path);
        assertEquals("Town_2 via Road_C to Town_4 2 mi", path.get(0).trim());
        assertEquals("Town_4 via Road_E to Town_5 1 mi", path.get(1).trim());
    }

    @Test
    public void testRemoveVertex() {
        assertTrue(graph.containsVertex(towns[3]));
        graph.removeVertex(towns[3]);
        assertFalse(graph.containsVertex(towns[3]));
    }
}
