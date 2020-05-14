package cuncurrency.basic_thread_runnable;

public class Main {

	public static void main(String[] args) {
		
		System.out.println( CorresConsole.AZUL + "Hello do main" );
		AnotherThread anotherThread = new AnotherThread();
		anotherThread.setName("anotherThread");
		anotherThread.start();
		
		new Thread() {
			public void run() {
				System.out.println( CorresConsole.VERDE + "Do thread anonimo" );
			}
		}.start();
		
		
		System.out.println( CorresConsole.AZUL + "Hello denovo do main" );
		//anotherThread.start(); //nao pode iniciar um thread que ja esta a correr, precisa criar novo objecto, como abaixo
		AnotherThread anotherThread2 = new AnotherThread();
		anotherThread2.setName("anotherThread2");
		anotherThread2.start();
		
		Thread myRunnableThread = new Thread( new MyRunnable() );
		myRunnableThread.start();
		
		new Thread( new Runnable() {
			@Override
			public void run() {
				System.out.println( "T5: Do runnable anonimo" );
			}
		}).start();
		
		
	}
}
