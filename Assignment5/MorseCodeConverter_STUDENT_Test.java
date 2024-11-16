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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MorseCodeConverter_STUDENT_Test 
{

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree() {	
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}

	@Test
	public void testConvertMorseStringToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish(".-- .. - .... / --. .-. . .- - / .--. --- .-- . .-. / -.-. --- -- . ... / --. .-. . .- - / .-. . ... .--. --- -. ... .. -... .. .-.. .. - -.--");
		assertEquals("with great power comes great responsibility", converter1);

	}

	@Test
	public void testConvertMorseFileToEnglishString() {	
		
		/*Make sure LovesLooksNot.txt is in the src directory for this 
		  test to pass
		*/
		File file = new File("src/LoveLooksNot.txt"); 
		try {
			assertEquals("love looks not with the eyes but with the mind", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}
}
