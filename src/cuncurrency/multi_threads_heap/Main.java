package cuncurrency.multi_threads_heap;


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
		
		//Visto que os dois threads estao a usar o mesmo objecto e a manipularem o mesmo atributo desse objecto, teremos aquilo que chamamos
		//de RACE CONDITION, ondem dois ou mais threads concorem para aceder o mesmo objecto na memoria HEAP, causando interferencia entre os
		//dois, e tornando assim dificil de saber em que momento quem vai ter acesso
		countdownThread.start();
		countdownThread2.start();
		
		//Para resolver este problema de interferencia, usamos sincronizacao
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
	
	public void doCountdown() {
		int number;
		
		switch ( Thread.currentThread().getName() ) {
			case "Thread 1": number = 1; break;
			case "Thread 2": number = 2; break;
			default: number = 0;
		}
		
		for ( i=10; i>0; i-- ) {
			System.out.println( "T" +number+ " (" +Thread.currentThread().getName()+  ") -> i = " +i );
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





