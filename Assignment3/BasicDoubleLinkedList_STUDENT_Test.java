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

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class BasicDoubleLinkedList_STUDENT_Test 
{
    private BasicDoubleLinkedList<Integer> list;

    @BeforeEach
    void setUp() 
    {
        list = new BasicDoubleLinkedList<>();
    }
    
    @AfterEach
    void tearDown() 
    {
        list = null; 
    }

    @Test
    void testBasicDoubleLinkedList() 
    {
        assertNotNull(list, "List should be initialized");
        assertEquals(0, list.getSize(), "Size should be zero upon initialization");
    }

    @Test
    void testGetSize() 
    {
        assertEquals(0, list.getSize(), "Size should be zero");
        list.addToEnd(1);
        assertEquals(1, list.getSize(), "Size should be one after adding an element");
        list.addToEnd(2);
        assertEquals(2, list.getSize(), "Size should be two after adding another element");
    }

    @Test
    void testAddToEnd() 
    {
        list.addToEnd(1);
        list.addToEnd(2);
        assertEquals(2, list.getSize(), "Size should be two after adding two elements");
        assertEquals(1, list.getFirst(), "First element should be 1");
        assertEquals(2, list.getLast(), "Last element should be 2");
    }

    @Test
    void testAddToFront() 
    {
        list.addToFront(1);
        list.addToFront(2);
        assertEquals(2, list.getSize(), "Size should be two after adding two elements");
        assertEquals(2, list.getFirst(), "First element should be 2");
        assertEquals(1, list.getLast(), "Last element should be 1");
    }

    @Test
    void testGetFirst() 
    {
        list.addToEnd(1);
        assertEquals(1, list.getFirst(), "First element should be 1");
        list.addToEnd(2);
        assertEquals(1, list.getFirst(), "First element should still be 1");
    }

    @Test
    void testGetLast() 
    {
        list.addToEnd(1);
        list.addToEnd(2);
        assertEquals(2, list.getLast(), "Last element should be 2");
        list.retrieveLastElement();
        assertEquals(1, list.getLast(), "Last element should be 1 after retrieving last element");
    }

    @Test
    void testIterator() 
    {
        list.addToEnd(1);
        list.addToEnd(2);
        
        BasicDoubleLinkedList<Integer>.DoubleLinkedListIterator iterator = list.new DoubleLinkedListIterator();
        
        assertTrue(iterator.hasNext(), "Iterator should have next");
        assertEquals(1, iterator.next(), "Next element should be 1");
        
        assertTrue(iterator.hasNext(), "Iterator should have next");
        assertEquals(2, iterator.next(), "Next element should be 2");
        
        assertFalse(iterator.hasNext(), "Iterator should not have next anymore");
    }

    @Test
    void testRemove() 
    {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        
        Comparator<Integer> comparator = Integer::compareTo;
        
        assertEquals(3, list.getSize(), "Size should be three before removal");
        assertNotNull(list.remove(2, comparator), "Removing element 2 should return a node");
        assertEquals(2, list.getSize(), "Size should be two after removal");
        assertNull(list.remove(4, comparator), "Removing non-existing element should return null");
    }

    @Test
    void testRetrieveLastElement() 
    {
        list.addToEnd(1);
        list.addToEnd(2);
        assertEquals(2, list.retrieveLastElement(), "Retrieved last element should be 2");
        assertEquals(1, list.getLast(), "Last element should now be 1");
    }

    @Test
    void testRetrieveFirstElement() 
    {
        list.addToEnd(1);
        list.addToEnd(2);
        assertEquals(1, list.retrieveFirstElement(), "Retrieved first element should be 1");
        assertEquals(1, list.getSize(), "Size should be 1 after retrieving the first element");
    }

    @Test
    void testToArrayList() 
    {
        list.addToEnd(1);
        list.addToEnd(2);
        list.addToEnd(3);
        
        ArrayList<Integer> arrayList = list.toArrayList();
        assertEquals(3, arrayList.size(), "ArrayList should contain three elements");
        assertEquals(1, arrayList.get(0), "First element should be 1");
        assertEquals(2, arrayList.get(1), "Second element should be 2");
        assertEquals(3, arrayList.get(2), "Third element should be 3");
    }
}
