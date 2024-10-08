import java.util.ArrayList;

/**
 * Generic class that implements the Queue interface 
 * @author inshaalc
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T>
{
	private int size;
	private int backIndex;
	private int frontIndex;
	private final T[] queue;
	private static final int DEFAULT_SIZE = 50;
	
	
	/** provide two constructors 
	 * 1. takes an int as the size of the queue
	 * 2. default constructor - uses a default as the size of the queue
	 * 
	 */
	@SuppressWarnings("unchecked")
	public MyQueue(int size)
	{
		T[] tempQueue = (T[]) new Object[size];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = 0;
		this.size = size;
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue()
	{
		T[] tempQueue = (T[]) new Object[DEFAULT_SIZE];
		queue = tempQueue;
		frontIndex = 0;
		backIndex = 0;
		size = DEFAULT_SIZE;
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty()
	{
		for (int i = 0; i < size; i++)
		{
			if (queue[i] != null)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines of the Queue is Full
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull()
	{
		for (int i = 0; i < size; i++)
		{
			if (queue[i] == null)
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	public T dequeue() throws QueueUnderflowException
	{
		if (isEmpty())
		{
			throw new QueueUnderflowException();
		}
		
		T element = queue[frontIndex];
		queue[frontIndex] = null;
		
		frontIndex = (frontIndex + 1) % queue.length;
		size--;
		
		return element;
	}

	/**
	 * Returns number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size()
	{
		if(isEmpty())
		{
			return 0;
		}
		
		int Size = 1;
		if (frontIndex < backIndex)
		{
			Size += backIndex - frontIndex;
		}
		else if (frontIndex > backIndex)
		{
			Size += size - frontIndex + backIndex;
		}
		return Size;
			
	}
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if (isFull())
		{
			throw new QueueOverflowException();
		}
		
		if (isEmpty())
		{
			queue[frontIndex] = e;
		}
		else
		{
			backIndex = (backIndex + 1) % size;
			queue[backIndex] = e;
		}
		
		if (queue[backIndex] == e)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString()
	{
		String data = "";
		
		for (int i = 0; i < size(); i++)
		{
			data += queue[(frontIndex + i) % size];
		}
		
		return data;
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter)
	{
		String data = "";
		
		for (int i = 0; i < size() - 1; i++)
		{
			data += queue[(frontIndex + i) % size] + delimiter;
		}
		data += queue[backIndex];
		
		return data;	
	}
	
	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) 
	{
	    ArrayList<T> listCopy = new ArrayList<T>();
	    
	    for (int i = 0; i < list.size(); i++) 
	    {
	        listCopy.add(list.get(i));
	    }

	    for (int i = 0; i < listCopy.size(); i++) 
	    {
	        queue[i] = listCopy.get(i);
	    }
	    
	    frontIndex = 0;
	    backIndex = listCopy.size() - 1;
	}

}
