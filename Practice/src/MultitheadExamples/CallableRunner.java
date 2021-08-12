package MultitheadExamples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executorService=Executors.newFixedThreadPool(1);
		Future<String> result=executorService.submit(new CallableTask("Smith"));

		System.out.println("new CallableTask(\"Smith\") executed");
		
		String str=result.get();
		System.out.println(str);
		System.out.println("main thread completed");
	}

}
class CallableTask implements Callable<String>
{

	private String name;
	public CallableTask(String name) {
		this.name=name;
	}
	@Override
	public String call() throws Exception {
		
		Thread.sleep(1000);
		return "Hello "+name;
	}
	
}

