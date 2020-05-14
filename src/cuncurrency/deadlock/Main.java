package cuncurrency.deadlock;

public class Main {
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void main(String[] args) {
		
		new Thread1().start();
		new Thread2().start();
		
		/*
		 * O deadlock ocorre porque Thread1 pega o lock1 e Thread2 pega o lock2, dai Thread1 tenta pegar lock2,
		 * que ele nao pode ter agora, pois esta com Thread2, e Thread2 tenta pegar lock1, que esta com
		 * Thread1 agora, entao os dois nunca vao continuar pois cada um esta a espera de outro terminar para
		 * continuar, dai o deadlock.
		 * */
		/*
		 * Para solucionar este problema, podemos optimizar o codigo, de modo que somente uma chave(lock)
		 * sera usada nos dois threads, mas se isso nao for possivel, podemos ainda organizar o codigo,
		 * de modo que as chaves sejam seguradas na mesma orderm, isto e, Thread1 e Thread2 dois tentarem
		 * pegar um lock, neste caso pode ser lock1 e depois lock2, assim, quando um Thread pegar o primeiro
		 * lock, o outro vai ter que esperar este terminar, nao dando assim chances do thread em espera pegar
		 * o segundo lock(lock2) antes do primeiro thread terminar, evitando assim deadlock
		 * A solucao esta na classe DeadlockSolvedMain.java
		 * */
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
			synchronized (lock2) {
				System.out.println("Thread 2: pegou lock2");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
				System.out.println("Thread 2: esperando para pegar lock1");
				synchronized (lock1) {
					System.out.println("Thread 2: pegou lock1");
				}
				System.out.println("Thread 2: soltou lock1");
			}
			System.out.println("Thread 2: soltou lock2");
		}
	}
	
}
