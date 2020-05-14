package cuncurrency.interrupt_join;

public class MainInteruptJoin {

	public static void main(String[] args) {
		/*
		AnotherThread anotherThread = new AnotherThread();
		anotherThread.setName("anotherThread");
		anotherThread.start();
		anotherThread.interrupt();
		
		AnotherThread anotherThread2 = new AnotherThread();
		anotherThread2.setName("anotherThread2");
		anotherThread2.start();
		*/
		
		
		Thread myRunnable = new Thread( new Runnable() {
			@Override
			public void run() {
				System.out.println( "T4: " + "Inicio de execucao" );
				try {
					Thread.sleep( 5000 );
				} catch (InterruptedException e) {
					System.out.println( "T4: foi interrompido" );
					return;
				}
				System.out.println( "T4: " + "Fim de execucao" );
			}
		});
		
		
		Thread myRunnable2 = new Thread( new Runnable() {
			public void run() {
				System.out.println( "T5: " + "Inicio de execucao" );
				
				try {
					System.out.println( "T5: " + "Step 1" );
					System.out.println( "T5: " + "Step 2" );
					myRunnable.join();//o Thread actual vai esperar o myRunnable terminar para poder seguir com a sua execucao
					System.out.println( "T5: O outro Thread terminou a sua execucao, entao vou seguir para o passo 3" );
					System.out.println( "T5: " + "Step 3" );
					System.out.println( "T5: " + "Step 4" );
					System.out.println( "T5: " + "Step 5" );
					
				} catch ( InterruptedException exc ) {
					System.out.println( "T5: foi interrompido" );
				}
				System.out.println( "T5: " + "Fim de execucao" );
			};
		} );
		
		myRunnable.start();
		myRunnable2.start();
		//myRunnable.interrupt();
		try {
			System.out.println("MethodReference: Hello do MethodReference");
			myRunnable2.join();//O Thread MethodReference vai esperar que o thread myRunnable2 termine antes de seguir para terminar o programa
			//O metodo join aceita um parametro em milisegundos, que determina o timeout para ficar a espera do outro Thread terminar,
			//caso o timeout chegue antes do outro Thread terminar, o Thread em espera vai seguir a sua execucao
			System.out.println( "MethodReference: O Thread T5 ja terminou a sua execucao, entao o MethodReference volta a correr" );
		} catch (InterruptedException e) {
			System.out.println( "MethodReference foi interrompido" );
		}
		System.out.println( "MethodReference: Fim da execucao do MethodReference" );
	}

}