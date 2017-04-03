import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 8; i++) {
			Thread t = new Thread(new DEAD(450, 500));
			t.start();
		}
	}

	public static class DEAD implements Runnable {
		long busyTime;
		long idleTime;

		public DEAD(long busyTime, long idleTime) {
			this.busyTime = busyTime;
			this.idleTime = idleTime;
		}

		@Override
		public void run() {
			while (true) {
				long start = System.currentTimeMillis();
				while (System.currentTimeMillis() < start + busyTime);
				try {
					Thread.sleep(idleTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}


}