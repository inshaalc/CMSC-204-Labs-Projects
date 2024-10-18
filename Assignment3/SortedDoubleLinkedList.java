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
import java.util.Comparator;
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> 
{
	protected Comparator<T> attribute;
	
	/**
	 * Creates an empty list that is associated with the specified comparator.
	 * @param Comparator to compare data elements
	 */
	public SortedDoubleLinkedList(java.util.Comparator<T> compareableObject)
	{
		this.attribute = compareableObject;
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list. Notice we can insert the same element several times. 
	 * Your implementation must traverse the list only once in order to perform the insertion.
	 * @param the data to be added to the list
	 */
	public void addâ€‹(T data)
	{
		// Create new node with the data from parameter
		Node newNode = new Node(data);
		
		// Checks if head node is empty, and then sets both to equal newNode.
		if (head == null)
		{
			head = tail = newNode;
			size++;
			return;
		}
		
		// If the new data should be inserted at the beginning 
		if (attribute.compare(data, head.data) <= 0)
		{
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
			size++;
			return;
		}
		
		// Traverse list to find correct position to insert
		Node current = head;
		while (current != null)
		{
			// Insert before current node IF new data < current data
			if (attribute.compare(data, current.data) <= 0)
			{
				newNode.next = current;
				newNode.prev = current.prev;
				
				if (current.prev != null)
				{
					current.prev.next = newNode;
				}
				
				current.prev = newNode;
				size++;
				return;
			}
			
			current = current.next;
		}
		
		// If data is greater than all current nodes, insert at the end
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		size++;
	}
	
	/**
	 * This operation is invalid for a sorted list. 
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @param data - the data for the Node within the linked list
	 * @throws java.lang.UnsupportedOperationException -  if method is called
	 * @Overrides addToEnd in class BasicDoubleLinkedList<T>
	 */ 
	@Override
	public void addToEnd(T data) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This operation is invalid for a sorted list.
	 * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
	 * @Overrides addToFront in class BasicDoubleLinkedList<T>
	 * @param data - the data for the Node within the linked list
	 * @throws java.lang.UnsupportedOperationException - if method is called
	 */
	@Override
	public void addToFront(T data) throws java.lang.UnsupportedOperationException
	{
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Implements the iterator by calling the super class iterator method.
	 * @Overrides iterator in class BasicDoubleLinkedList<T>
	 * @returns an iterator positioned at the head of the list
	 */
	@Override
	public java.util.ListIterator<T> iterator()
	{
		// Calls super class iterator method
		return super.iterator();
	}
	
	/**
	 * Implements the remove operation by calling the super class remove method.
	 * @Overrides remove in class BasicDoubleLinkedList<T>
	 * @param data - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the data or null
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public BasicDoubleLinkedList.Node removeâ€‹(T data, java.util.Comparator<T> comparator)
	{
		// Calls remove method from super class
		return super.removeâ€‹(data,  comparator);
	}
}
