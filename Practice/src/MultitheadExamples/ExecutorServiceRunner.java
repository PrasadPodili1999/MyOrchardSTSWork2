package MultitheadExamples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceRunner {

	public static void main(String[] args) {
		
		//ExecutorService executorService=Executors.newSingleThreadExecutor();
		ExecutorService executorService=Executors.newFixedThreadPool(1);
		
		
		executorService.execute(new Task(1));
		executorService.execute(new Task(2));
		executorService.execute(new Task(3));
		executorService.execute(new Task(4));
		executorService.execute(new Task2());
		
		
		executorService.shutdown();
	}

}
class Task extends Thread
{
	private int number;
	public Task(int number)
	{
		this.number=number;
	}
	public void run()
	{
		System.out.println("task "+number+" started");
		for(int i=number*100;i<number*100+49;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println("\ntask "+number +"done");
	}
}
class Task1 extends Thread
{
	public void run()
	{
		System.out.println("task1 started");
		for(int i=0;i<101;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println("\ntask1 done");
	}
}
class Task2 implements Runnable
{

	@Override
	public void run() {
		
		System.out.println("task2 started");
		for(int i=0;i<101;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println("\ntask2 done");
	}
	
}
