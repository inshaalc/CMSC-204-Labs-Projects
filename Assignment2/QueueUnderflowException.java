/**
 * Exception class that throws QueueUnderflowException
 * @author inshaalc
 */
public class QueueUnderflowException extends Exception
{
	public QueueUnderflowException()
	{
		super("Queue is empty. Queue  underflow occurred.");
	}
	
	public QueueUnderflowException(String message)
	{
		super(message);
	}
}
