package trial.program.thread.timelimit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TimeLimiteThread {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println(Thread.currentThread());
					Thread.sleep(2000);
				}catch(InterruptedException e) {
					e.printStackTrace();
					return;
				}
				System.out.println("Thread continues to run...");
			}
			
		});
		
		thread.start();
		
		try {
			TimeUnit.SECONDS.timedJoin(thread,1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		if(thread.isAlive()) {
			thread.interrupt();
			try {
				throw new TimeoutException("Thread did not finish within time limit");
			} catch (TimeoutException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
