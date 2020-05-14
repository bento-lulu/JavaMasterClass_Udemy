package lambdas.streams;

import java.util.Arrays;

public class MethodReference {
	public static void main(String[] args) {
		//Praticamente method reference serve para chamar um metodo em um objecto ou classe que faz
		//o que foi definido pela funcao da interface que pretendemos usar.
		
		//There are four kinds of method references:
		//1. Reference to a static method: 	ContainingClass::staticMethodName
		String getUsername = getUsername("William Bento Arao", MySystemUsername::extractReverseUsername);
		System.out.println( getUsername);
		
		//2. Reference to an instance method of a particular object: 	containingObject::instanceMethodName
		MySystemUsername mySystemUsername = new MySystemUsername();
		getUsername = getUsername("William Bento Arao", mySystemUsername::extractUsername);
		System.out.println( getUsername);
		
		//3. Reference to an instance method of an arbitrary object of a particular type: 	ContainingType::methodName
		String[] nomes = { "William", "Bento", "Arao" };
		Arrays.sort( nomes, String::compareTo );//chama o metodo compareTo para os elementos da lista
		for ( String str : nomes ) {
			System.out.println( str );
		}
		
		//4. Reference to a constructor 	ClassName::new
		
	}
	
	private static String getUsername( String nome, UsernameExtrator extrator ) {
		return extrator.getUsername(nome);
	}
}

//O functional interface, cujo metodo sera implementado pelo lambda expression em method reference para metodo de outra class
//que faz a funcao definida pela funcao da interface: mySystemUsername::extractUsername
interface UsernameExtrator{
	public String getUsername(String nome);
}

//Classe com metodo que faz o que foi definido pela interface, a signature do metodo deve ser a mesma que
//a funcao da interface, receber um String e retornar um String. O nome do metodo nao interessa
class MySystemUsername{
	public String extractUsername( String nome ) {
		return nome.substring(0, 2).toLowerCase().concat( nome.substring( nome.lastIndexOf(' ')+1 ).toLowerCase() );
	}

	public static String extractReverseUsername( String nome ) {
		return nome.substring( nome.lastIndexOf(' ')+1, nome.lastIndexOf(' ')+2 ).toLowerCase().concat( nome.substring(0, nome.indexOf(' ')).toLowerCase() );
	}
}


