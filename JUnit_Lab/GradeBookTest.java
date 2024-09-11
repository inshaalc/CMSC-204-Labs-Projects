import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest
{
	private GradeBook object1;
	private GradeBook object2;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		object1 = new GradeBook(5);
		object2 = new GradeBook(5);
		
		object1.addScore(77);
		object1.addScore(79);
		
		object2.addScore(89);
		object2.addScore(95);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		object1 = null;
		object2 = null;
	}

	@Test
	void testAddScore() 
	{
		assertTrue(object1.toString().equals("77.0 79.0 "));
		assertEquals("77.0 79.0 ", object1.toString());
		
		assertTrue(object2.toString().equals("89.0 95.0 "));
		assertEquals("89.0 95.0 ", object2.toString());
		
		assertEquals(2, object1.getScoreSize());
		assertEquals(2, object2.getScoreSize());

	}

	@Test
	void testSum() 
	{
		assertEquals(156.0, object1.sum(), .0001);
		assertEquals(184.0, object2.sum(), .0001);
	}

	@Test
	void testMinimum() 
	{
		assertEquals(77, object1.minimum(), .001);
		assertEquals(89, object2.minimum(), .001);

	}

	@Test
	void testFinalScore() 
	{
		assertEquals(79, object1.finalScore(), .001);
		assertEquals(95, object2.finalScore(), .001);
	}

	@Test
	void testGetScoreSize() 
	{
		// no test for getScoreSize outside of testAddScore 
	}

	@Test
	void testToString() 
	{
		// no test for toString outside of testAddScore
	}

}
