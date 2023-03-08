
//no need to add packages but added them to know where they came from
import java.lang.Runnable;
import java.lang.Thread;

public class RunnableDemo implements Runnable {

	private Thread t;
	private String threadName;
	
	//first thing that will start
	public RunnableDemo(String name) {
		this.threadName = name;
		System.out.println("Creating thread: " + this.threadName);
	}
	
	@Override
	public void run() {
		//each thread from instances will FINALLY start
		System.out.println("Running " + this.threadName);
		
		try {
			//sleeeeepy threads start!
			for(int i = 4; i > 0; i--) {
				
				//all instances of threads will stop when the i equals 2 (2 seconds remaining)
				if(i == 2) throw new InterruptedException();
				
				//thread sleeping counter
				System.out.println("Thread: " + this.threadName + ", " + i);
				
				//thread will sleep
				Thread.sleep(1000);
				
				
				
				
			}
		} catch(InterruptedException e) {
			System.out.printf("Error: \n %s\n Thread got interrupted\n", e.toString());
		}
		
		System.out.println("Thread " + this.threadName + " exiting");
		
	}
	
	public void start() {
		System.out.println("Starting " + this.threadName);
		
		//every instance of RunnableDemo will not have t instantiated
		if(t == null) {
			//thread will get instantited
			t = new Thread(this, this.threadName);
			
			//will cause Thread-1 to always go first
			if(t.getName().equals("Thread-1")) {
				t.setPriority(10);
				
				//thread will get interrupted and never start
				t.interrupt();
				
			}
			if(t.getName().equals("Thread-1")) {
				
			}
			
			//thread will start
			t.start();
		}
	}

}
