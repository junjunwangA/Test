import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class RadomThread {

	public static void main(String[] args) {
		ExecutorService  threadPool=Executors.newFixedThreadPool(3);
		for(int i=1;i<5;i++){
			final int taskID=i;
			threadPool.execute(new Runnable(){

				@Override
				public void run() {
					for(int i =1;i<3;i++){
						System.out.print(taskID+""+i+" ");
					}
					
				}
				
			});
		}
		threadPool.shutdown();

	}

}
