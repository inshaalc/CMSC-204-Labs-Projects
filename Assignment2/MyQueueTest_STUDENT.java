import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * Student Test for MyQueue Class
 * @author Inshaal Chaudhury
 */
public class MyQueueTest_STUDENT 
{
    public MyQueue<String> stringQ;
    public String x="x", y="y", z="z", p="p", q="q", r="r";
    public ArrayList<String> fill = new ArrayList<String>();
    public MyQueue<Double> doubleQ;

    @BeforeEach
    public void setUp() throws Exception 
    {
        stringQ = new MyQueue<String>(5);
        stringQ.enqueue(x);
        stringQ.enqueue(y);
        stringQ.enqueue(z);
        
        doubleQ = new MyQueue<Double>(5);
        doubleQ.enqueue(10.5);
        doubleQ.enqueue(20.7);
        doubleQ.enqueue(30.9);
    }

    @AfterEach
    public void tearDown() throws Exception 
    {
        stringQ = null;
        doubleQ = null;
    }

    @Test
    public void testIsEmpty() throws QueueUnderflowException 
    {
        assertEquals(false, stringQ.isEmpty());
        stringQ.dequeue();
        stringQ.dequeue();
        stringQ.dequeue();
        assertEquals(true, stringQ.isEmpty());
    }

    @Test
    public void testDequeue() 
    {
        try 
        {
            assertEquals(x, stringQ.dequeue());
            assertEquals(y, stringQ.dequeue());
            assertEquals(z, stringQ.dequeue());
            stringQ.dequeue();
            assertTrue("This should have caused a QueueUnderflowException", false);
        }
        catch (QueueUnderflowException e) 
        {
            assertTrue("This should have caused a QueueUnderflowException", true);
        }
        catch (Exception e) 
        {
            assertTrue("This should have caused a QueueUnderflowException", false);
        }
    }

    @Test
    public void testSize() throws QueueOverflowException, QueueUnderflowException 
    {
        assertEquals(3, stringQ.size());
        stringQ.enqueue(p);
        assertEquals(4, stringQ.size());
        stringQ.dequeue();
        stringQ.dequeue();
        assertEquals(2, stringQ.size());
    }

    @Test
    public void testEnqueue() 
    {
        try 
        {
            assertEquals(3, stringQ.size());
            assertEquals(true, stringQ.enqueue(p));
            assertEquals(4, stringQ.size());
            assertEquals(true, stringQ.enqueue(q));
            assertEquals(5, stringQ.size());
            stringQ.enqueue(r);
            assertTrue("This should have caused a QueueOverflowException", false);
        }
        catch (QueueOverflowException e) 
        {
            assertTrue("This should have caused a QueueOverflowException", true);
        }
        catch (Exception e) 
        {
            assertTrue("This should have caused a QueueOverflowException", false);
        }
    }

    @Test
    public void testIsFull() throws QueueOverflowException 
    {
        assertEquals(false, stringQ.isFull());
        stringQ.enqueue(p);
        stringQ.enqueue(q);
        assertEquals(true, stringQ.isFull());
    }

    @Test
    public void testToString() throws QueueOverflowException 
    {
        assertEquals("xyz", stringQ.toString());
        stringQ.enqueue(p);
        assertEquals("xyzp", stringQ.toString());
        stringQ.enqueue(q);
        assertEquals("xyzpq", stringQ.toString());
    }
    
    @Test
    public void testToStringDelimiter() throws QueueOverflowException 
    {
        assertEquals("x%y%z", stringQ.toString("%"));
        stringQ.enqueue(p);
        assertEquals("x&y&z&p", stringQ.toString("&"));
        stringQ.enqueue(q);
        assertEquals("x/y/z/p/q", stringQ.toString("/"));
    }

    @Test
    public void testFill() throws QueueUnderflowException 
    {
        fill.add("apple");
        fill.add("banana");
        fill.add("cherry");
        stringQ = new MyQueue<String>(5);
        stringQ.fill(fill);
        assertEquals(3, stringQ.size());
        assertEquals("apple", stringQ.dequeue());
        assertEquals("banana", stringQ.dequeue());
        assertEquals("cherry", stringQ.dequeue());       
    }
}
