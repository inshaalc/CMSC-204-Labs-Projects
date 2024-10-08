/**
 * Exception class that throws StackUnderflowException
 * @author inshaalc
 */
public class StackUnderflowException extends Exception
{
	public StackUnderflowException()
	{
		super("Stack is empty. Stack underflow occurred.");
	}
	
	public StackUnderflowException(String message)
	{
		super(message);
	}
}
