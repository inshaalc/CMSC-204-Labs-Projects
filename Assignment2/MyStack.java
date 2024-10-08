import java.util.ArrayList;

/**
 * Generic stack class that implements Stack interface
 * @author inshaalc
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T>
{
	private int top;
	private int size;
	private final T[] stackArray;
	
	private static final int DEFAULT_SIZE = 50;

	/**
	 * Provide two constructors
	 * 1. takes in an int as the size of the stack
	 * 2. default constructor - uses default as the size of the stack
	 */
	// First Constructor
	@SuppressWarnings("unchecked")
	public MyStack(int size)
	{
		T[] tempStack = (T[]) new Object[size];
		stackArray = tempStack;
		top = -1;
		this.size = size;
	}
	
	// Second constructor
	@SuppressWarnings("unchecked")
	public MyStack()
	{
		T[] tempStack = (T[]) new Object[DEFAULT_SIZE];
		stackArray = tempStack;
		top = -1;
		this.size = DEFAULT_SIZE;
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() 
	{
		return (top == -1);
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() 
	{
		return (top == stackArray.length-1);
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException
	{
		if (isFull())
		{
			throw new StackOverflowException();
		}
		top++;
		stackArray[top] = e;
		if (stackArray[top] == e)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException 
	{
		if (isEmpty())
		{
			throw new StackUnderflowException();
		}
		T element = (T) stackArray[top];
		stackArray[top] = null;
		top--;
		return element;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException
	{
		if (isEmpty())
		{
			throw new StackUnderflowException();
		}
		T element = (T) stackArray[top];
		return element;
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public int size() 
	{
		return top + 1;
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() 
	{
		if (isEmpty())
		{
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i <= top; i++)
		{
			result.append(stackArray[i].toString());
			if (i < top)
			{
				result.append("");
			}
		}
		
		return result.toString();
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		if (isEmpty())
		{
			return "";
		}
		
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i <= top; i++)
		{
			result.append(stackArray[i].toString());
			if (i < top)
			{
				result.append(delimiter);
			}
		}
		return result.toString();	
	}

	/**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) 
	{
		ArrayList<T> copyList = new ArrayList<>(list);
		
		for (T element : copyList)
		{
			if (isFull())
			{
				throw new StackOverflowException();
			}
			push(element);
		}
	}

}
