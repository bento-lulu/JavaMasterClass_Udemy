package lambdas;

public class Intro {

	public static void main(String[] args) {
		
		//Lambdas sao usadas para facilitar ou diminuir codigo quando queremos criar uma classe
		//anonima que implementa apenas um metodo:
		
		new Thread( ()->{
				System.out.println("From runnable");
				System.out.println("From runnable too");
			}
		).start();
		
		//O codigo acima, cria uma classe anonima do tipo Runnable, o tipo do parametro que e uma interface
		//e implementa o metodo run() apenas com o codigo '()->'
		
		//Todas expressoes lambdas tem 3 partes:
		//	1. Lista de argumentos: ()
		//	2. A secta: ->
		//	3. O corpo da expressao: {}, o {} e opcional em casos de haver apenas um statement
	}

}
