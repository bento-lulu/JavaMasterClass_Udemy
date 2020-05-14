package cuncurrency.multi_threads_heap.sincronizacao;

/**
 * 
 * @author bento
 *
 *	Usando sincronizacao, este programa tem um balde de agua, um thread enche o balde
 *  e outro despeja a agua no tangue.
 *  Portando o thread que enche agua no balde nao pode encher denovo ate que o balde
 *  esteja vazio, funcao esta do segundo thread.
 */

public class BaldeDeAgua {

	public static void main(String[] args) {
		Balde[] baldes = {
							new Balde(),
							new Balde(),
							new Balde(),
							new Balde(),
							new Balde()
						 };
		
		Thread enchedor = new Thread( new Enchedor(baldes) );
		Thread despejador = new Thread( new Despejador(baldes) );
		enchedor.start();
		despejador.start();
	}

}


class Balde{
	private String estado = "vazio";
	private int litros;
	
	public synchronized void encher( int litros ) {
		//se o balde nao estiver vazio, nao posso encher, devo esperar este estar vazio,
		//entao vou soltar o LOCK deste objecto e esperar, dormindo(sleeping thread) ser notificado
		//pelo thread que despeja agua do balde, pois este estara a me informar que o balde ja esta vazio
		//para poder encher. Entao proxima vez que o loop correr depois do wait(), a condicao vai ser false
		//pois o balde ja estara vazio e pronto para ser enchido
		while ( !estado.equals("vazio") ) {
			try {
				wait();//liberta o lock e fica a espera de ser notificado por outro thread que vai pegar o lock
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//balde esta vazio, pois a condicao de loop deu false, entao vou encher o balde
		this.litros = litros;
		estado = "cheio";
		System.out.println("Encheu " +litros+ " litros de agua");
		notifyAll();//notificar o despejador para ele poder despeja a agua
	}
	
	public synchronized void despejar() {
		//enquanto o balde estiver vazio, nao posso despejar, pois nao tem agua. Sendo assim, devo
		//soltar o LOCK deste objecto e esperar ser notificado pelo thread que o vai encher para
		//poder despejar a agua
		while ( estado.equals("vazio") ) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//o balde ja esta cheio, entao vou depejar
		estado = "vazio";
		System.out.println("Despejou " +litros+ " litros de agua");
		this.litros = 0;
		notifyAll();//notificar o enchedor para poder encher o balde vazio
	}
}


//Writer/Producer class
class Enchedor implements Runnable{
	private Balde[] baldes;
	
	Enchedor( Balde[] baldes ){
		this.baldes = baldes;
	}
	
	@Override
	public void run() {
		for ( int i=0; i<baldes.length; i++ ) {
			baldes[i].encher(2*(i+1));
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


//Reader/Consumer class
class Despejador implements Runnable{
	private Balde[] baldes;
	
	Despejador( Balde[] baldes ){
		this.baldes = baldes;
	}
	
	@Override
	public void run() {
		for ( int i=0; i<baldes.length; i++ ) {
			baldes[i].despejar();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


/*
    wait( ) - tells the calling thread to give up the monitor and go to sleep until
    		  some other thread enters the same monitor and calls notify( ).

    notify( ) - wakes up a thread that called wait( ) on the same object.

    notifyAll( ) - wakes up all the threads that called wait( ) on the same object.
    			   The highest priority thread will run first.
*/




