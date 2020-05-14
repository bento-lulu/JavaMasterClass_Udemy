package cuncurrency.multi_threads_heap.sincronizacao;

public class Main {
	
	public static void main(String[] args) {
		
		//Este objecto sera usado nos dois threads, pois fica guardado na memoria HEAP do programa,
		//entao e acessada por todos os threads do programa, ao contrario de um objecto que se encontra
		//na THREAD STACK, que so e acessada pelo thread que o criou
		Countdown countdown = new Countdown();
		
		CountdownThread countdownThread = new CountdownThread( countdown );
		countdownThread.setName("Thread 1");
		
		CountdownThread countdownThread2 = new CountdownThread( countdown );
		countdownThread2.setName("Thread 2");
		
		countdownThread.start();
		countdownThread2.start();
		
		//Para resolver o problema de interferencia, usamos sincronizacao
		/*
		 * Sincronizacao e um metodo ou bloco de codigo que nao pode ser interferido ao longo da sua execucao, isto e, se um thread
		 * estiver a executar um metodo ou bloco de codigo sincronizado, a execucao deste bloco de codigo nao pode ser interompida
		 * por outro thread que quer ter acesso ao mesmo bloco de codigo, como estava a acontecer com o exemplo acima, onde os
		 * threads se interceptavam e por vezes podem imprimir valores inconsistentes, como saltar um numero ou mesmo repetir, isto
		 * porque a interferencia aconteceu em um momento improprio e provoca assim resultados inconsistentes.
		 * 
		 * Quando um bloco de codigo sincronizado esta a correr, nenhum outro thread pode correr qualquer que seja o codigo sincronizado
		 * daquele objecto, seja este bloco, o mesmo que o thread actual esta a correr, ou um outro bloco de codigo tambem sincronizado,
		 * apenas blocos de codigos nao sincronizados podem ser corridos por outro thread quando um thread esta a executar um bloco de
		 * codigo sincronizado.
		 * */
		
	}
	
}

class Countdown {
	private int i;
	
	//Solucao 1 foi de tornar o metodo sincronizado:
	//public synchronized void doCountdown() {
	//Mas apenas o for loop deve ser sincronizado, que e a parte que manipula o nosso recurso partilhado na HEAP
	public void doCountdown() {
		int number;
		
		switch ( Thread.currentThread().getName() ) {
			case "Thread 1": number = 1; break;
			case "Thread 2": number = 2; break;
			default: number = 0;
		}
		
		//Solucao 2: sincronizar bloco de codigo:
		//Bloco sincronizado, com a chave/monitor do objecto actual.
		//O thread deve pegar a chave antes de executar este bloco de codigo, impossibilitando assim que outros threads executem
		//o bloco de codigo antes dele terminar, pois estes so poderao fazer isto apos a chave do thread for libertada
		synchronized ( this ) {
			for ( i=10; i>0; i-- ) {
				System.out.println( "T" +number+ " (" +Thread.currentThread().getName()+  ") -> i = " +i );
			}
		}
	}
}

class CountdownThread extends Thread {
	private Countdown countdown;
	
	public CountdownThread( Countdown countdown ) {
		this.countdown = countdown;
	}
	
	@Override
	public void run() {
		countdown.doCountdown();
	}
}



