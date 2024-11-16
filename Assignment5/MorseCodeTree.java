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

import java.util.ArrayList;

public class MorseCodeTree extends Object implements LinkedConverterTreeInterface<String>
{
	TreeNode<String> root;

	/**
	 * Constructor - Calls buildTree method
	 */
	public MorseCodeTree()
	{
		buildTree();
	}
	
	@Override
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<String> getRoot() 
	{
		return this.root;
	}

	@Override
	/**
	 * Sets the root of the MorseCodeTree
	 * @param newNode - a newNdoe that will be the root of MorseCodeTree
	 */
	public void setRoot(TreeNode<String> newNode) 
	{
		this.root = newNode;
	}

	@Override
	/**
	 * Adds element to the correct position in the tree based on the code.
	 * This method will call the recursive method addNode.
	 * @param code - the code for the new node to be added, example ".-."
	 */
	public void insert(String code, String result) 
	{
		addNode(this.root, code, result);
	}

	@Override
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) 
	{
		if (code.isEmpty())
		{
			root.dataNode = letter;
			return;
		}
		
		char direction = code.charAt(0);
		
		if (direction == '.')
		{
			if (root.left == null) {
				root.left = new TreeNode<>("");
			}
			addNode(root.left, code.substring(1), letter);
		}
		else if (direction == '-')
		{
			if (root.right == null) {
				root.right = new TreeNode<>("");
			}
			addNode(root.right, code.substring(1), letter);
		}
	}

	@Override
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	public String fetch(String code) 
	{
		return fetchNode(root, code);
	}

	@Override
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) 
	{
		// Base Case 1
		if (root == null)
		{
			return null;
		}
		
		// Base Case 2
		if (code.isEmpty())
		{
			return root.dataNode;
		}
		
		// Recursive Case
		char direction = code.charAt(0);
		if (direction == '.')
		{
			return fetchNode(root.left, code.substring(1));
		}
		else if (direction == '-')
		{
			return fetchNode(root.right, code.substring(1));
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	@Override
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException();
	}

	@Override
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException();
	}

	@Override
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 */
	public void buildTree() 
	{
		root = new TreeNode<>("");
		
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	@Override
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList() 
	{
		ArrayList<String> result = new ArrayList<>();
		LNRoutputTraversal(root, result);
		return result; 
	}

	@Override
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
	{	
		// Base Case
		if (root == null)
		{
			return;
		}
		
		LNRoutputTraversal(root.left, list);
		
		list.add(root.dataNode);
		
		LNRoutputTraversal(root.right, list);
	}
}
