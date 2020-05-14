package cuncurrency.deadlock;

public class DeadlockSolvedMain {
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		
		new Thread1().start();
		new Thread2().start();
	}
	
	
	private static class Thread1 extends Thread{
		@Override
		public void run() {
			synchronized (lock1) {
				System.out.println("Thread 1: pegou lock1");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				System.out.println("Thread 1: esperando para pegar lock2");
				synchronized (lock2) {
					System.out.println("Thread 1: pegou lock2");
				}
				System.out.println("Thread 1: soltou lock2");
			}
			System.out.println("Thread 1: soltou lock1");
		}
	}
	
	
	
	private static class Thread2 extends Thread{
		@Override
		public void run() {
		synchronized (lock1) {
			System.out.println("Thread 2: pegou lock1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			System.out.println("Thread 2: esperando para pegar lock2");
			synchronized (lock2) {
				System.out.println("Thread 2: pegou lock2");
			}
			System.out.println("Thread 2: soltou lock2");
			}
			System.out.println("Thread 2: soltou lock1");
		}
	}

}

