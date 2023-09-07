package controlle;

public class ThreadsID extends Thread{
	private int idThread;

	public ThreadsID() {
		super();
		this.idThread = (int )getId();
	}
	
	@Override
	public void run() {
		System.out.println(idThread);
	}

}
