/*
 * Class: CMSC 204 
 * Instructor: Huseiyn Aygun 
 * Description: Write a generic double-linked list class with an iterator, 
 * and a generic sorted double-linked list class with an iterator that inherits from your generic double-linked list class.
 * Due: 10/16/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Inshaal Chaudhury
*/
/**
 * @author inshaalc
 * @param <T>
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;  
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList_STUDENT_Test 
{
    private SortedDoubleLinkedList<String> sortedLinkedList;
    private Comparator<String> comparator;

    @BeforeEach
    void setUp() 
    {
        comparator = String::compareTo;
        sortedLinkedList = new SortedDoubleLinkedList<>(comparator);
    }

    @AfterEach
    void tearDown() 
    {
        // Clear the sorted linked list after each test
        sortedLinkedList = null; 
    }

    @Test
    void testAddToEnd() 
    {
        // This operation is invalid for a sorted list
        assertThrows(UnsupportedOperationException.class, () -> 
        {
            sortedLinkedList.addToEnd("test");
        });
    }

    @Test
    void testAddToFront() 
    {
        // This operation is invalid for a sorted list
        assertThrows(UnsupportedOperationException.class, () -> 
        {
            sortedLinkedList.addToFront("test");
        });
    }

    @Test
    void testIterator() 
    {
        sortedLinkedList.add("C");
        sortedLinkedList.add("A");
        sortedLinkedList.add("B");

        // Iterate through the list and check order
        ListIterator<String> iterator = sortedLinkedList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testRemove() 
    {
        sortedLinkedList.add("B");
        sortedLinkedList.add("A");
        sortedLinkedList.add("C");

        // Remove element and check if it was removed
        assertNotNull(sortedLinkedList.remove("B", comparator));
        assertNull(sortedLinkedList.remove("X", comparator)); // Removing non-existent element

        // Check remaining elements
        ListIterator<String> iterator = sortedLinkedList.iterator();
        assertEquals("A", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testSortedDoubleLinkedList() 
    {
        // Ensure the sorted linked list is initialized correctly
        assertNotNull(sortedLinkedList);
        assertEquals(0, sortedLinkedList.getSize()); 
    }

    @Test
    void testAdd() 
    {
        // Adding elements to the sorted list
        sortedLinkedList.add("B");
        sortedLinkedList.add("A");
        sortedLinkedList.add("C");

        // Check if elements are in sorted order
        ListIterator<String> iterator = sortedLinkedList.iterator();
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }
}
