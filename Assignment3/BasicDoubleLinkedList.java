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
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> extends java.lang.Object implements java.lang.Iterable<T>
{
	 /**
	  * Inner class of type node
	  */
	 protected class Node extends java.lang.Object
	 {
		// Attributes
		protected T data;
		protected Node prev;
		protected Node next;
		
		// Constructor
		protected Node(T dataNode)
		{
			this.data = dataNode;
			this.prev = null;
			this.next = null;
		}
	 }
	 
	 // Fields
	 protected Node head;
	 protected Node tail;
	 protected int size;
	 
	 /**
	  * Inner class of Double Linked List Iterator
	  */
	 protected class DoubleLinkedListIterator extends java.lang.Object implements java.util.ListIterator<T>
	 {
		protected Node previousNode;
		protected Node newHead;
		 
		// Constructor
		public DoubleLinkedListIterator()
		{
			previousNode = null;
			newHead = head;
		}
		
		/**
		 * Returns true if this list iterator has more elements when traversing the list in the forward direction. 
		 * (In other words, returns true if next() would return an element rather than throwing an exception.)
		 * @return true if the list iterator has more elements when traversing the list in the forward direction
		 */
		@Override
		public boolean hasNext() 
		{
		    return newHead != null;
		}

		/**
		 * Returns true if this list iterator has more elements when traversing the list in the reverse direction. 
		 * (In other words, returns true if previous() would return an element rather than throwing an exception.)
		 * @return true if the list iterator has more elements when traversing the list in the reverse direction
		 */
		@Override
		public boolean hasPrevious() 
		{
			return previousNode != null;
		}
		
		/**
		 * Returns the next element in the list and advances the cursor position. 
		 * This method may be called repeatedly to iterate through the list, or intermixed with calls to previous() to go back and forth. 
		 * (Note that alternating calls to next and previous will return the same element repeatedly.)
		 * @return the next element in the list
		 * @throws NoSuchElementException if the iteration has no next element
		 */
		@Override
		public T next() throws NoSuchElementException
		{
			if (!hasNext())
			{
				throw new NoSuchElementException();
			}
			else
			{
				previousNode = newHead;
				newHead = newHead.next;
				return previousNode.data;
			}
		}

		/**
		 * Returns the previous element in the list and moves the cursor position backwards. 
		 * This method may be called repeatedly to iterate through the list backwards, or intermixed with calls to next() to go back and forth. 
		 * (Note that alternating calls to next and previous will return the same element repeatedly.)
		 * @throws NoSuchElementException
		 * @return the previous element in the list
		 */
		@Override
		public T previous() throws NoSuchElementException
		{
			if (!hasPrevious())
			{
				throw new NoSuchElementException();
			}
			newHead = previousNode;
			
			if (previousNode != null)
			{
				previousNode = previousNode.prev;
			}
			return newHead.data;
		}

		@Override
		public int nextIndex() throws UnsupportedOperationException  
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();			
		}

		@Override
		public void add(T e) throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();			
		}
		 
	 }
	 
	/**
	 * Constructor
	 */
	public BasicDoubleLinkedList()
	{
	}
	
	/**
	 * Get Size method returns the size 
	 * @return int of size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Adds new Node to the end of the chain
	 * @param data
	 */
	public void addToEnd(T data)
	{
		Node newNode = new Node(data);
		
		if (head == null)
		{
			head = tail = newNode;
		}
		else
		{
			tail.next = newNode;
			newNode.prev = tail;
			
			tail = newNode;
		}
		
		size++;
	}
	
	/**
	 * Adds new node to front of the chain
	 * @param data
	 */
	public void addToFront(T data)
	{
		Node newNode = new Node(data);
		
		if (tail == null)
		{
			head = tail = newNode;
		}
		else
		{
			newNode.next = head;
			head.prev = newNode;
			
			head = newNode;
		}
		
		size++;
	}
	
	/**
	 * Returns but does not remove the first element from the list.
	 * @return the data element or null
	 */
	public T getFirst()
	{
		if (head == null)
			return null;
		else
			return head.data;
	}
	
	/**
	 * Returns but does not remove the last element from the list.
	 * If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return the data element or null
	 */
	public T getLast()
	{
		if (tail == null)
			return null;
		else
			return tail.data;
	}

	/**
	 * This method returns an object of the DoubleLinkedListIterator. (the inner class that implements java's ListIterator interface)
	 * @return a ListIterator object
	 */
	@Override
	public java.util.ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	
	/**
	 * Removes the first instance of the targetData from the list. 
	 * Notice that you must remove the elements by performing a single traversal over the list. 
	 * You may not use any of the other retrieval methods associated with the class in order to complete the removal process. 
	 * You must use the provided comparator (do not use equals) to find those elements that match the target. 
	 * Do not implement this method using iterators.
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return a node containing the targetData or null
	 */
	@SuppressWarnings("rawtypes")
	public BasicDoubleLinkedList.Node remove(T targetData, java.util.Comparator<T> comparator)
	{
		Node current = head;
		
		while (current != null)
		{
			if (comparator.compare(current.data, targetData) == 0)
			{
				// If it's the head
				if (current == head)
				{
					head = current.next;
					
					if (head != null)
					{
						head.prev = null;
					}
					size--;
					break;
				}
				// If it's the tail
				else if (current == tail)
				{
					tail = current.prev;
					
					if (tail != null)
					{
						tail.next = null;
					}
					size--;
					break;
				}
				// If it's in the middle
				else
				{
					current.prev.next = current.next;
					current.next.prev = current.prev;
					size--;
				}
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	/**
	 * Removes and returns the last element from the list. 
	 * If there are no elements the method returns null. Do not implement implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveLastElement()
	{		
		// Checks if tail is empty/null
		if (tail == null)
		{
			return null;
		}
		
		// If one one node is there, create temporary node copying data, remove the data, and return the node's data.
		if (head == tail)
		{
			Node currentNode = tail;
			head = null;
			tail = null;
			size--;
			return currentNode.data;
		}
		
		// Traverse list from head to second-to-last element using while loop 
		Node current = head;
		while (current.next != tail)
		{
			current = current.next;
		}
		
		// Copy the tail's data, set the final node to null so it is no longer pointing to to last node. Set tail to equal current, and return the tail's original data. 
		T data = tail.data;
		current.next = null;
		tail = current;
		size--;
		
		return data;
	}
	
	/**
	 * Removes and returns the first element from the list. 
	 * If there are no elements the method returns null. Do not implement this method using iterators.
	 * @return data element or null
	 */
	public T retrieveFirstElement()
	{
		// Checks if head is empty/null
		if (head == null)
		{
			return null;
		}
		
		// Checks if one element remains 
		if (tail == head)
		{
			Node currentNode = head;
			head = tail = null;
			size--;
			return currentNode.data;
		}
		
		// Copy First Node's data, set head equal to head.next (next node), and remove the original head node by making it equal null.
		Node current = head;
		T data = current.data;	
		head = head.next;
		head.prev = null;
		size--;
		
		return data;
	}
	
	/**
	 * Returns an arraylist of all the items in the Double Linked list
	 * @return an arraylist of the items in the list
	 */
	public java.util.ArrayList<T> toArrayList()
	{
		// Initialize ArrayList
		ArrayList<T> list = new ArrayList<>();
		
		// Create node using reference of head node, traverse entire list of nodes from head to tail, adding data to the array, then moving pointer.
		Node current = head;
		while (current != null)
		{
			list.add(current.data);
			current = current.next;
		}
		
		return list;
	}
}
