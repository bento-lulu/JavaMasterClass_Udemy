package cuncurrency.basic_thread_runnable;

public class AnotherThread extends Thread {
	
	@Override
	public void run() {
		System.out.println( currentThread().getId() + ": Hello from " +currentThread().getName() );
		
		try {
			Thread.sleep( 3000 );
		} catch ( InterruptedException e) {
			System.out.println( currentThread().getId() + ": Another Thread woke me up " );
			//Esta excepcao ocorre quando um outro Thread interompe este Thread, usando o metodo interrupt() na instancia deste Thread,
			//a execucao no try e interrompida e o codigo no catch vai correr, mas o Thread nao para, dai a necessidade neste exemplo de,
			//por o return statement para terminar a execucao do metodo run() e nao correr o codigo depois do try...catch
			return;
		}
		
		System.out.println( currentThread().getId() + ": Ja passaram os 3 segundos de execucao da tarefa " );
	}
	
}
