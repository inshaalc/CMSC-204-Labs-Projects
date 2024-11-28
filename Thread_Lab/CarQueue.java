import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue 
{
	private final Queue<Integer> queue;
	private final Random random;
	
	public CarQueue()
	{
		queue = new ArrayDeque<Integer>();
		random = new Random();
		for (int i = 0; i < 6; i++) 
		{
            queue.add(random.nextInt(4)); 
        }
	}
	
	public void addToQueue()
	{
		class myRunnable implements Runnable
		{
			public void run()
			{
				try
				{
					queue.add(random.nextInt(4));
					Thread.sleep(200);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		Runnable run = new myRunnable();
		Thread the = new Thread(run);
	}
	
	public int deleteQueue()
	{
		return queue.remove();
	}
}
