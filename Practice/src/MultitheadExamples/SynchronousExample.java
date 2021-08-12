package MultitheadExamples;

class Table
{
	void printTable(int n)
	{
		synchronized (this) {
			for(int i=1;i<6;i++)
			{
				System.out.println(i*n+", "+Thread.currentThread().getName());
				try
				{
					Thread.sleep(500);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
//		System.out.println("hello......."+Thread.currentThread().getName());
	}
}

class Thread1 extends Thread
{
	Table t;
	public Thread1(Table t) {
		this.t=t;
	}
	public void run()
	{
		t.printTable(10);
	}
}
class Thread2 extends Thread
{
	Table t;
	public Thread2(Table t) {
		this.t=t;
	}
	public void run()
	{
		t.printTable(20);
	}
}


public class SynchronousExample {

	public static void main(String[] args) {
		
		Table t=new Table();
		
		//By Using Runnable Interface
//		Runnable r1=()->{
//				t.printTable(10);
//		};
//		Runnable r2=()->{
//			
//				t.printTable(20);
//		};
		Runnable r3=()->{
			
				t.printTable(20);
		};
		Runnable r4=()->{
		
				t.printTable(20);
		};
		Thread t1=new Thread1(t);
		Thread t2=new Thread2(t);
		Thread t3=new Thread(r3);
		Thread t4=new Thread(r4);
		
		//By Using Thread anonymous class
		
//		Thread t1=new Thread() {
//			public void run()
//			{
//				t.printTable(10);
//			}
//		};
//		Thread t2=new Thread() {
//			public void run()
//			{
//				t.printTable(20);
//			}
//		};
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

