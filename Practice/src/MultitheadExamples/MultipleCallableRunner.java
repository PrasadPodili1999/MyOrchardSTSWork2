package MultitheadExamples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultipleCallableRunner {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newFixedThreadPool(3);
		List<CallableTask> list=Arrays.asList(new CallableTask("Smith")
				,new CallableTask("john")
				,new CallableTask("adam"));
		//Future<String> result=executorService.submit(new CallableTask("Smith"));
//		List<Future<String>> results=executorService.invokeAll(list);
//		
//		for(Future<String> result:results)
//		{
//			System.out.println(result.get()+"\n");
//		}
		List<Future<String>> result=executorService.invokeAll(list);
		result.stream().forEach(m->{
			try {
				System.out.println(m.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		System.out.println(result);
		executorService.shutdown();

	}

}
