import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Inshaal Chaudhury
 *
 */
public class PasswordCheckerTest_STUDENT 
{
	ArrayList<String> studentPasswords;
	String password1, password2;

	@Before
	public void setUp() throws Exception 
	{
		String[] arrayOfPass = {"Hello@123", "AAAbb@123", "Aaabb@123", "ab11Bb", "Password123!", "Sho@1", "GoodPass123!", "Aa1!"};
		studentPasswords = new ArrayList<>();
		studentPasswords.addAll(Arrays.asList(arrayOfPass));
	}

	@After
	public void tearDown() throws Exception 
	{
		studentPasswords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() 
	{
		try 
        {
            PasswordCheckerUtility.isValidPassword​("abcABC123!");
            assertTrue("Password meets length requirement", true);
        } 
        catch (Exception e) 
        {
            fail("Unexpected exception thrown for a valid password");
        }
		
        try 
        {
            PasswordCheckerUtility.isValidPassword​("abcAB"); // Shorter than 6 characters
            fail("Expected LengthException was not thrown");
        } 
        catch (LengthException e) 
        {
            assertTrue("Successfully threw LengthException", true);
        } 
        catch (Exception e) 
        {
            fail("Threw an unexpected exception");
        }
    }
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() 
	{
		try 
        {
            PasswordCheckerUtility.isValidPassword​("UpperCase1!");
            assertTrue("Password has uppercase letters", true);
        } 
        catch (Exception e) 
        {
            fail("Unexpected exception thrown for a valid password");
        }
		
        try 
        {
            PasswordCheckerUtility.isValidPassword​("lowercase1!");
            fail("Expected NoUpperAlphaException was not thrown");
        } 
        catch (NoUpperAlphaException e) 
        {
            assertTrue("Successfully threw NoUpperAlphaException", true);
        } 
        catch (Exception e) 
        {
            fail("Threw an unexpected exception");
        }
    }
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() 
	{
        try 
        {
            PasswordCheckerUtility.isValidPassword​("UpperCase1!");
            assertTrue("Password has lowercase letters", true);
        } 
        catch (Exception e) 
        {
            fail("Unexpected exception thrown for a valid password");
        }
        
        try 
        {
            PasswordCheckerUtility.isValidPassword​("UPPERCASE1!");
            fail("Expected NoLowerAlphaException was not thrown");
        } 
        catch (NoLowerAlphaException e) 
        {
            assertTrue("Successfully threw NoLowerAlphaException", true);
        } 
        catch (Exception e) 
        {
            fail("Threw an unexpected exception");
        }
    }
	/**
	 * Test if the password is valid but is only between 6 and 9 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword() 
	{
		try 
	    {
	        String strongPassword = "StrongPass123!"; 
	        boolean result = PasswordCheckerUtility.isWeakPassword​(strongPassword);
	        assertFalse("Password should not throw WeakPasswordException", result);
	    } 
	    catch (Exception e) 
	    {
	        fail("Unexpected exception thrown for a strong password: " + e.getMessage());
	    }
		
	    try 
	    {
	        String weakPassword = "Weak12!"; 
	        boolean result = PasswordCheckerUtility.isWeakPassword​(weakPassword);
	        assertTrue("Password should throw WeakPasswordException", result);
	    } 
	    catch (WeakPasswordException e) 
	    {
	        assertTrue("Correctly identified weak password", true);
	    } 
	    catch (Exception e) 
	    {
	        fail("Unexpected exception thrown for a weak but valid password: " + e.getMessage());
	    }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence() 
	{
	    try 
	    {
	        assertTrue("Password should be valid", PasswordCheckerUtility.NoSameCharInSequence​("A1b@cD2e!"));
	    } 
	    catch (InvalidSequenceException e) 
	    {
	        fail("Did not expect an InvalidSequenceException");
	    } 
	    catch (Exception e) 
	    {
	        fail("Threw an unexpected exception: " + e.getMessage());
	    }
	    
	    try 
	    {
	    	assertEquals(true,PasswordCheckerUtility.isValidPassword​("123@4aaAAA"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
	    } 
	    catch (InvalidSequenceException e) 
	    {
	        assertTrue("Successfully threw InvalidSequenceException", true);
	    } 
	    catch (Exception e) 
	    {
	        fail("Threw an unexpected exception: " + e.getMessage());
	    }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() 
	{
	    try 
	    {
	        assertTrue("Password should be valid", PasswordCheckerUtility.isValidPassword​("Valid1Password!"));
	    } 
	    catch (Exception e) 
	    {
	        fail("Threw an unexpected exception: " + e.getMessage());
	    }
	    
	    try 
	    {
	        PasswordCheckerUtility.isValidPassword​("NoDigits!");
	        fail("Expected NoDigitException was not thrown");
	    } 
	    catch (NoDigitException e) 
	    {
	        assertTrue("Successfully threw NoDigitException", true);
	    } 
	    catch (Exception e) 
	    {
	        fail("Threw an unexpected exception: " + e.getMessage());
	    }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() 
	{
	    try 
	    {
	        assertTrue("Password should be valid", PasswordCheckerUtility.isValidPassword​("Valid1Password!"));
	    } 
	    catch (Exception e) 
	    {
	        fail("Threw an unexpected exception: " + e.getMessage());
	    }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() 
	{
	    ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords​(studentPasswords);
	    
	    Scanner scan;

	    scan = new Scanner(results.get(0));
	    assertEquals("AAAbb@123", scan.next()); 
	    String resultMessage = scan.nextLine().toLowerCase();
	    assertTrue(resultMessage.contains("sequence"));

	    scan = new Scanner(results.get(1));
	    assertEquals("ab11Bb", scan.next()); 
	    resultMessage = scan.nextLine().toLowerCase();
	    assertTrue(resultMessage.contains("special"));

	    scan = new Scanner(results.get(2));
	    assertEquals("Sho@1", scan.next()); 
	    resultMessage = scan.nextLine().toLowerCase();
	    assertTrue(resultMessage.contains("long"));

	    scan = new Scanner(results.get(3));
	    assertEquals("Aa1!", scan.next()); 
	    resultMessage = scan.nextLine().toLowerCase();
	    assertTrue(resultMessage.contains("long"));
	}	
}
