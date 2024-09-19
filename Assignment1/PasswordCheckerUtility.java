/*
 * Class: CMSC204 
 * Instructor: Huseyin Aygun
 * Description: Used as the primary password checker utility, has methods that throw exceptions if requirement isn't met
 * Due: 09/18/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Inshaal Chaudhury
*/

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

/** Password Checker Utility Class
 * @author Inshaal Chaudhury
 */
public class PasswordCheckerUtility 
{
	// Empty Constructor
	public PasswordCheckerUtility()
	{
	}
	
	/**
	 * Method compares passwords
	 * @param Takes in password
	 * @param passwordConfirm
	 * @throws UnmatchedException
	 */
	public static void comparePasswords​(java.lang.String password, java.lang.String passwordConfirm) throws UnmatchedException
	{
		if (!password.equals(passwordConfirm))
		{
			throw new UnmatchedException("Passwords do not match");
		}
	}
	
	/**
	 * Compares passwords but returns a boolean flag
	 * @param password
	 * @param passwordConfirm
	 * @return boolean flag of whether passwords match or not
	 */
	public static boolean comparePasswordsWithReturn​(java.lang.String password, java.lang.String passwordConfirm)
	{
		if (password.equals(passwordConfirm))
		{
			 return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Checks if the password is a valid length
	 * @param password
	 * @return
	 * @throws LengthException
	 */
	public static boolean isValidLength​(java.lang.String password) throws LengthException
	{
		try
		{
			if (password.length() < 6)
			{
				throw new LengthException();
			}
			else
			{
				return true;
			}
		}
		catch (LengthException e)
		{
			System.out.println(e.getMessage());
			throw e;
		}
	}

	/**
	 * Checks the password alpha character requirement - Password must contain an uppercase alpha character
	 * @param password
	 * @return boolean flag indicating whether it has upper alpha
	 * @throws NoUpperAlphaException
	 */
	public static boolean hasUpperAlpha​(java.lang.String password) throws NoUpperAlphaException
	{
		try
		{
			boolean hasUpperCase = false;
			
			for (int i = 0; i < password.length(); i++)
			{
				if (Character.isUpperCase(password.charAt(i)))
				{
					hasUpperCase = true;
					break;
				}
			}
			
			// If (!false) then... (because !false = true)
			if (!hasUpperCase)
			{
				throw new NoUpperAlphaException();
			}
			
			// Final return flag if it doesn't throw the exception
			return true;
		}
		catch (NoUpperAlphaException e)
		{
			System.out.println(e.getMessage());
			return false;
		}

	}
	
	/**
	 * Checks the password lowercase requirement - Password must contain at least one lowercase alpha character
	 * @param password
	 * @return
	 * @throws NoLowerAlphaException
	 */
	public static boolean hasLowerAlpha​(java.lang.String password) throws NoLowerAlphaException
	{
		try
		{
			boolean hasLowerCase = false;
			
			for (int i = 0; i < password.length(); i++)
			{
				if (Character.isLowerCase(password.charAt(i)))
				{
					hasLowerCase = true;
					break;
				}
			}
			
			// If (!false) then... (because !false = true)
			if (!hasLowerCase)
			{
				throw new NoLowerAlphaException();
			}
			return true;
		}
		catch (NoLowerAlphaException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Checks the password Digit requirement - Password must contain a numeric character 
	 * @param password
	 * @return Returns boolean flag indicating whether it has a digit
	 * @throws NoDigitException
	 */
	public static boolean hasDigit​(java.lang.String password) throws NoDigitException
	{
		try 
		{
			boolean hasDigit = false;
			
			for (int i = 0; i < password.length(); i++)
			{
				if (Character.isDigit(password.charAt(i)))
				{
					hasDigit = true;
					break;
				}
			}
			
			if (!hasDigit)
			{
				throw new NoDigitException();
			}
			return true;
		}
		catch (NoDigitException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Checks the password SpecialCharacter requirement - Password must contain a Special Character
	 * @param password string to be checked for SpecialCharacter requirement
	 * @return true if meets SpecialCharacter requirement
	 * @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	 */
	public static boolean hasSpecialChar​(java.lang.String password) throws NoSpecialCharacterException
	{
		try
		{
			Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
			Matcher matcher = pattern.matcher(password);
			
			if (matcher.matches())
			{
				throw new NoSpecialCharacterException();
				
			}
			return true;
			
		}
		catch (NoSpecialCharacterException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * Checks the password Sequence requirement - Password should not contain more than 2 of the same character in sequence
	 * @param password - password string to be checked for Sequence requirement
	 * @return false if does NOT meet Sequence requirement
	 * @throws InvalidSequenceException - thrown if meets Sequence requirement
	 */
	public static boolean NoSameCharInSequence​(java.lang.String password) throws InvalidSequenceException
	{
		try
		{	
			for (int i = 0; i < password.length() - 2; i++)
			{
				if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i)== password.charAt(i + 2))
				{
					throw new InvalidSequenceException();
				}
			}
			return true;
		}
		catch (InvalidSequenceException e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * checks if the password contains 6 to 9 characters
	 * @param password string to be checked for
	 * @return true if password contains 6 to 9 characters, false otherwise
	 */
	public static boolean hasBetweenSixAndNineChars​(java.lang.String password)
	{
		if (password.length() >= 6 && password.length() <= 9)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Return true if valid password (follows all the following rules), 
	 * returns false if an invalid password 1. At least 6 characters long - 2. 
	 * At least 1 numeric character- 3. At least 1 uppercase alphabetic character - 4. 
	 * At least 1 lowercase alphabetic character - 5. At least 1 special character - 6. 
	 * No more than 2 of the same character in a sequence 
	 * Hello@123 – OK AAAbb@123 – not OK Aaabb@123 – OK
	 * @param password -- string to be checked for validity
	 * @return true if valid password (follows all rules from above), false if an invalid password
	 * @throws LengthException - thrown if length is less than 6 characters
	 * @throws NoUpperAlphaException - thrown if no uppercase alphabetic
	 * @throws NoLowerAlphaException - thrown if no lowercase alphabetic
	 * @throws NoDigitException - thrown if no digit
	 * @throws NoSpecialCharacterException - thrown if does not meet SpecialCharacter requirement
	 * @throws InvalidSequenceException - thrown if more than 2 of same character.
	 */
	public static boolean isValidPassword​(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
	{
	    try
	    {
	        if (!isValidLength​(password)) 
	            throw new LengthException();
	        else if (!hasUpperAlpha​(password)) 
	            throw new NoUpperAlphaException();	        
	        else if (!hasLowerAlpha​(password)) 
	            throw new NoLowerAlphaException();        
	        else if (!hasDigit​(password)) 
	            throw new NoDigitException();	        
	        else if (!hasSpecialChar​(password)) 
	            throw new NoSpecialCharacterException();
	        else if (!NoSameCharInSequence​(password)) 
	            throw new InvalidSequenceException();
	        
	        return true; 
	    }
	    catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e)
	    {
	        System.out.println(e.getMessage());	        
	        throw e;
	    }
	}

	
	/**
	 * Checks if password is VALID and the length is NOT between 6-9 characters
	 * @param password - string to be checked if weak password
	 * @return false if the password is valid and the length of password is NOT between 6 and 9 (inclusive).
	 * @throws WeakPasswordException - if length of password is between 6 and 9 (inclusive), ALTHOUGH the password may be VALID.
	 */
	public static boolean isWeakPassword​(java.lang.String password) throws WeakPasswordException 
	{
	    try 
	    {
	        if (isValidPassword​(password) && hasBetweenSixAndNineChars​(password)) 
	        {
	            throw new WeakPasswordException();
	        }
	        return false;
	    } 
	    catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e) 
	    {
	        System.out.print(e.getMessage());
	        return false;
	    }
	}

	
	/**
	 * This method will accept an ArrayList of passwords as the parameter and return an ArrayList with the status of any invalid passwords (weak passwords are not considered invalid). 
	 * The ArrayList of invalid passwords will be of the following format: password BLANK message of the exception thrown.
	 * @param passwords - list of passwords
	 * @return ArrayList of invalid passwords in the correct format
	 */
	public static java.util.ArrayList<java.lang.String> getInvalidPasswords​(java.util.ArrayList<java.lang.String> passwords)
	{
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		for (String password : passwords)
		{
			try
			{
				if (!isValidPassword​(password))
				{
				}
			}
			catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e)
		    {
		        invalidPasswords.add(password + " " + e.getMessage());
		    }
			
		}
		return invalidPasswords;
	}
}
