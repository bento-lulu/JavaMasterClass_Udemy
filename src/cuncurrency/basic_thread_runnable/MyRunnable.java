package cuncurrency.basic_thread_runnable;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println( CorresConsole.PRETO + "Hello do Runnable" );
	}

}
