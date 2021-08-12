package MultitheadExamples;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		
		List<Integer> sharedList=new ArrayList<Integer>();
		Thread t1=new Thread(new Producer(sharedList));
		Thread t2=new Thread(new Consumer(sharedList));
		t1.start();
		t2.start();
	}

}

class Producer implements Runnable{

	final int MAX_SIZE=5;
	List<Integer> sharedList=null;
	private int i=0;
	
	public Producer(List<Integer> sharedList) {
		super();
		this.sharedList=sharedList;
	}
	
	@Override
	public void run() {
		while(true)
		{
			try {
				produce(i++);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void produce(int i) throws InterruptedException
	{
		synchronized (sharedList) {
			while(sharedList.size()==MAX_SIZE)
			{
				System.out.println("sharedlist is full.....waiting for consumer to consume");
				sharedList.wait();
			}
		}
		synchronized (sharedList) {
			
			System.out.println("producer produced element "+i);
			sharedList.add(i);
			Thread.sleep(100);
			sharedList.notify();
		}
	}
	
}
class Consumer implements Runnable{

	List<Integer> sharedList=null;
	
	public Consumer(List<Integer> sharedList) {
		super();
		this.sharedList=sharedList;
	}
	
	@Override
	public void run() {
		while(true)
		{
			try {
				consume();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public void consume() throws InterruptedException
	{
		synchronized (sharedList) {
			while(sharedList.isEmpty())
			{
				System.out.println("sharedlist is empty.....waiting for the producer to produce elements");
				sharedList.wait();
			}
		}
		synchronized (sharedList) {
			
			Thread.sleep(1000);
			System.out.println("consumer consumed the element "+sharedList.remove(0));
			sharedList.notify();
		}
	}
	
}
