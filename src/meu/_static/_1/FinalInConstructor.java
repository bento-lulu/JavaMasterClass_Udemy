package meu._static._1;

public class FinalInConstructor {
	
	private final int inicializadoNoConstrutor;
	
	public FinalInConstructor( int valor ) {
		inicializadoNoConstrutor = valor;//campo final pode ser inicializado na declaracao ou no contrutor
										//mas no construtor so funciona se nao definirmos na declaracao
		
		//inicializadoNoConstrutor = 8;//nao pode alterar valor da variavel final ja inicializada
	}

	
	public void change( int valor ){
		//inicializadoNoConstrutor = valor;//em outros metodos nao e possivel dar valor ao campo final
										  //mesmo se nao estiver atribuido na declaracao
		System.out.println(inicializadoNoConstrutor);
	}
}
