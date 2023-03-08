
//no need to add packages but added them to know where they came from
import java.lang.Runnable;
import java.lang.Thread;
import java.lang.Exception;

public class RunnableDemo implements Runnable {

	private Thread t;
	private String threadName;
	
	public RunnableDemo(String name) {
		this.threadName = name;
		System.out.println("Creating thread: " + this.threadName);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Running " + this.threadName);
		
		try {
			for(int i = 4; i > 0; i--) {
				System.out.println("Thread: " + this.threadName + ", " + i);
				
				//thread will sleep
				Thread.sleep(1000);
				if(i == 2) throw new InterruptedException();
				
				
			}
		} catch(InterruptedException e) {
			System.out.printf("Error: \n %s\n Thread got interrupted\n", e.toString());
		}
		
		System.out.println("Thread " + this.threadName + " exiting");
		
	}
	
	public void start() {
		System.out.println("Starting " + this.threadName);
		
		if(t == null) {
			t = new Thread(this, this.threadName);
			
			//will cause Thread-1 to always go last
			if(t.getName().equals("Thread-1")) {
				t.setPriority(10);
				t.interrupt();
				
			}
			if(t.getName().equals("Thread-1")) {
				
			}
			
			t.start();
		}
	}

}
