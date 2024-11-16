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

public class TreeNode<T> extends Object
{
	//Fields
	T dataNode;
	TreeNode<T> left;
	TreeNode<T> right;
	
	/**
	 * Constructor creates new TreeNode with left and right 
	 * child set to null and data set to dataNode
	 * @param dataNode - data to be stored in TreeNode
	 */
	public TreeNode(T dataNode)
	{
		this.dataNode = dataNode;
		this.left = null;
		this.right = null;
	}
	
	/**
	 * Used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node)
	{
		if (node == null)
			return;
		
		this.dataNode = node.dataNode;
		this.left = (node.left != null) ? new TreeNode<>(node.left) : null;
		this.right = (node.right != null) ? new TreeNode<>(node.right) : null;
	}
	
	/**
	 * Returns the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData()
	{
		return this.dataNode;
	}	
}
