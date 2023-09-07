package controlle;

public class view {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++){
			ThreadsID threadsID = new ThreadsID();
			threadsID.start();			
		}		
	}
}
