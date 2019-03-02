package thread;

class ThreadImpl implements Runnable{

	 boolean v=false;
	@Override
	public void run() {
		v=true;
		System.out.println("i="+v+""+Thread.currentThread());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class TestThread {

	public static void main(String[] args) {

		ThreadImpl t1 = new ThreadImpl();
		
		 new Thread(t1,"Thread1").start();
		 new Thread(t1,"Thread2").start();
		 
		 
		 
	}

}
