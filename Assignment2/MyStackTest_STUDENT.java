import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student Test for MyStack Class + Instructions were unclear so I implemented
 * both empty methods in original test file + created Student Test file just in case
 * @author Inshaal Chaudhury
 */
public class MyStackTest_STUDENT 
{
	public MyStack<String> stringS;
	public MyStack<Double> doubleS;
	public String x="x", y="y", z="z", u="u", v="v", w="w";
	public ArrayList<String> fill = new ArrayList<String>();
	// STUDENT: student tests will use the doubleS
	// STUDENT: add variables as needed for your student tests
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		stringS = new MyStack<String>(5);
		stringS.push(x);
		stringS.push(y);
		stringS.push(z);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS = new MyStack<>(5);
		doubleS.push(3.1);
		doubleS.push(4.2);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringS.isFull());
		stringS.push(u);
		stringS.push(v);
		assertEquals(true, stringS.isFull());
	}

	@Test
	public void testPop() 
	{
		try {
			assertEquals(z, stringS.pop());
			assertEquals(y, stringS.pop());
			assertEquals(x, stringS.pop());
			//Stack is empty, next statement should cause StackUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}
	
	@Test
	public void testTop() throws StackOverflowException, StackUnderflowException {
		assertEquals(z, stringS.top());
		stringS.push(u);
		assertEquals(u, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(y, stringS.top());		
	}

	@Test
	public void testSize() throws StackUnderflowException, StackOverflowException {
		assertEquals(3, stringS.size());
		stringS.push(u);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(u));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(v));
			assertEquals(5, stringS.size());
			//Stack is full, next statement should cause StackOverFlowException
			stringS.push(w);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}
	
	@Test
	public void testToString() {
		assertEquals("xyz", stringS.toString());
		stringS.push(u);
		assertEquals("xyzu", stringS.toString());
		stringS.push(v);
		assertEquals("xyzuv", stringS.toString());
	}
	
	@Test
	public void testToStringDelimiter() {
		assertEquals("x%y%z", stringS.toString("%"));
		stringS.push(u);
		assertEquals("x&y&z&u", stringS.toString("&"));
		stringS.push(v);
		assertEquals("x/y/z/u/v", stringS.toString("/"));
	}

	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty Stack
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}
