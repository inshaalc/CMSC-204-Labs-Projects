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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MorseCodeConverter extends Object
{
	/**
	 * Default Constructor
	 */
	public MorseCodeConverter()
	{
	}
	
	/**
	 * Returns a string with all the data in the tree in LNR Order w/ space in between
	 * Uses toArrayList method in MorseCodeTree 
	 * It should return the data in this order: "h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 * Note the extra space between j & b - that is because there is an empty string that is the root
	 * In LNR traversal the root would come between the right most child of the left tree (j) and 
	 * left most child of right tree (b).
	 * This is used for testing purposes to make sure MorseCodeTree has been built properly
	 * @return the data in the tree in LNR order separated by a space
	 */
	public static String printTree()
	{
		MorseCodeTree tree = new MorseCodeTree();
		ArrayList<String> data = tree.toArrayList();
		StringBuilder result = new StringBuilder();
		for (String element : data)
		{
			result.append(element).append(" ");
		}
		
		return result.toString().trim();
	}
	
	/**
	 * Converts Morse Code into English. Each letter is delimited by a space (' '). Each word
	 * is defined by a '/'.
	 * @param code - the morse code
	 * @return the English Translation
	 */
	public static String convertToEnglish(String code)
	{
		String[] words = code.split("/");
		
		StringBuilder englishTranslation = new StringBuilder();
		MorseCodeTree tree = new MorseCodeTree();
		
		for (int i = 0; i < words.length; i++)
		{
			// Split word into individual morse code letters
			String[] letters = words[i].split(" ");
			
			// Translate each letter to english
			for (String letter : letters)
			{
				// Fetch corresponding English character using tree's fetch method
				String englishLetter = tree.fetch(letter);
				englishTranslation.append(englishLetter);
			}
			
			if (i < words.length - 1)
			{
				englishTranslation.append(" ");
			}
		}
		
		return englishTranslation.toString();
	}
	
	/**
	 * Converts a file of Morse code into English. Each letter is delimited by a space (' '). 
	 * Each word is delimited by a '/'.
	 * Example:
	 * A file that contains "..... . .-.. .-.. ----/ .-- --- .-. .-..-.." - String returned = "Hello World"
	 * @param CodeFile - name of the File that contains Morse Code
	 * @return the English Translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(java.io.File CodeFile) throws FileNotFoundException
	{
		MorseCodeTree tree = new MorseCodeTree();
		StringBuilder englishTranslation = new StringBuilder();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(CodeFile)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				String[] words = line.split(" / ");
				for (int i = 0; i < words.length; i++)
				{
					// Split word into individual Morse code letters
					String[] letters = words[i].split(" ");
					
					// Translate each letter to English
					for (String letter : letters)
					{
						// Fetch corresponding English character using tree's fetch method
						String englishLetter = tree.fetch(letter);
						englishTranslation.append(englishLetter);
					}
					
					if (i < words.length - 1)
					{
						englishTranslation.append(" ");
					}
				}
			}
			
			englishTranslation.append("\n");
		}
		catch (IOException e)
		{
			e.getMessage();
		}
		
		return englishTranslation.toString().trim();
	}
}
