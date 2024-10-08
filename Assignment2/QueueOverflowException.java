/**
 * Exception class that throws QueueOverflowException
 * @author inshaalc
 */
public class QueueOverflowException extends Exception 
{
	public QueueOverflowException()
	{
		super("Queue is full. Queue  overflow occurred.");
	}
	
	public QueueOverflowException(String message)
	{
		super(message);
	}
}
