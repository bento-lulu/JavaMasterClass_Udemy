package collections.sets;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Map<String, Estudante> estudantes = new HashMap<>();
		
		Estudante andre = new Estudante( "SAU456", "Andre Ander" );
		andre.adicionarCadeira( new Cadeira( "Matematica", 24 ));
		andre.adicionarCadeira( new Cadeira( "Programacao 1", 24 ));
		andre.adicionarCadeira( new Cadeira( "Ingles", 24 ));
		estudantes.put( andre.getNumeroEstudante(), andre );
		
		Estudante mario = new Estudante( "SAU895", "Mario Marcos" );
		mario.adicionarCadeira( new Cadeira( "Matematica", 24 ));
		mario.adicionarCadeira( new Cadeira( "Ingles", 24 ));
		mario.adicionarCadeira( new Cadeira( "Web Design", 24 ));
		estudantes.put( mario.getNumeroEstudante(), mario );
		
		Estudante paulo = new Estudante( "SAU145", "Paulo Pluto" );
		paulo.adicionarCadeira( new Cadeira( "Programacao 1", 24 ));
		paulo.adicionarCadeira( new Cadeira( "Ingles", 24 ));
		paulo.adicionarCadeira( new Cadeira( "Web Design", 24 ));
		estudantes.put( paulo.getNumeroEstudante(), paulo );
		
		Set<Cadeira> cadeirasSendoFeitas = new HashSet<>();
		System.out.println("Estudantes e cadeiras feitas por cada um:\n");
		for ( String numeroEstudante : estudantes.keySet() ) {
			Estudante estudante = estudantes.get(numeroEstudante);
			System.out.println( estudante.getNumeroEstudante()+ ": " +estudante.getNome() );
			
			for ( Cadeira cadeira : estudante.getCadeiras() ) {
				System.out.println( "\t" +cadeira.getNome()+ "(" +cadeira.getHoras()+ ")" );
				cadeirasSendoFeitas.add(cadeira);
			}
		}
		
		System.out.println("\nCadeiras sendo feitas pelos estudantes actualmente:");
		for( Cadeira cadeira : cadeirasSendoFeitas ) {
			System.out.println( "\t" +cadeira.getNome()+ "(" +cadeira.getHoras()+ ")" );
		}
	}

}
