/*
 * Class: CMSC 204 
 * Instructor: Huseiyn Aygun 
 * Description: Write the classes required to create a Morse Code Converter Utility. 
 * Your Morse Code Converter Utility will be using a generic linked binary tree 
 * with generic TreeNodes to convert Morse Code into English. 
 * There is no GUI requirement for this assignment. You are supplied a GUI for testing purposes.
 * Due: 11/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Inshaal Chaudhury
*/
/*
 * @author Inshaal Chaudhury
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class MorseCodeTree_STUDENT_Test {

    private MorseCodeTree tree;

    @BeforeEach
    public void setUp() throws Exception {
        tree = new MorseCodeTree();
    }

    @AfterEach
    public void tearDown() throws Exception {
        tree = null;
    }

    @Test
    public void testMorseCodeTree() {
        assertNotNull(tree.getRoot());
        assertEquals("", tree.getRoot().getData());
        assertEquals("e", tree.getRoot().left.getData());
        assertEquals("t", tree.getRoot().right.getData());
    }

    @Test
    public void testInsert() {
        tree.insert("....-", "4");
        String fetched = tree.fetch("....-");
        assertEquals("4", fetched);

        assertEquals("e", tree.fetch("."));
    }

    @Test
    public void testFetch() {
    	assertTrue(tree.fetch(".-").equals("a"));
		assertTrue(tree.fetch("....").equals("h"));
		assertTrue(tree.fetch("...").equals("s"));
		assertTrue(tree.fetch(".--").equals("w"));
		assertTrue(tree.fetch("-..-").equals("x"));
    }

    @Test
    public void testToArrayList() {
        MorseCodeTree tree = new MorseCodeTree(); 
        ArrayList<String> expected = new ArrayList<>(Arrays.asList(
            "h", "s", "v", "i", "f", "u", "e", "l", "r", "a", "p", "w",
            "j", "b", "d", "x", "n", "c", "k", "y", "t", "z", "g", "q", "m", "o"));

        ArrayList<String> actual = tree.toArrayList();

        for (int i = 0; i < actual.size(); i++) 
        {
            if (actual.get(i).isEmpty()) 
            {
                actual.remove(i);
                i--; 
            }
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testAddNode() {
        tree.addNode(tree.getRoot(), "....-", "4");
        String fetched = tree.fetch("....-");
        assertEquals("4", fetched);
    }

    @Test
    public void testLNRoutputTraversal() {
        ArrayList<String> list = new ArrayList<>();
        tree.LNRoutputTraversal(tree.getRoot(), list);

        assertEquals(27, list.size()); 
        assertEquals("h", list.get(0));
        assertEquals("o", list.get(list.size() - 1));
    }

    @Test
    public void testUnsupportedDelete() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> tree.delete("data"));
        assertEquals(null, exception.getMessage());
    }

    @Test
    public void testUnsupportedUpdate() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> tree.update());
        assertEquals(null, exception.getMessage());
    }
}
