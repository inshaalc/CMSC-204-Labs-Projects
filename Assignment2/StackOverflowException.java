/**
 * Exception class that throws StackOverflowException
 * @author inshaalc
 */
public class StackOverflowException extends RuntimeException
{
	public StackOverflowException()
	{
		super("Stack is full. Stack overflow occurred.");
	}
	
	public StackOverflowException(String message)
	{
		super(message);
	}
}
