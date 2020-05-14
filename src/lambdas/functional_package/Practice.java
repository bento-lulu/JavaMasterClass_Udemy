package lambdas.functional_package;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Practice {
	
	private static String[] nomes = { "Abel", "Paulo", "Pedro", "Donald", "Weldon", "Neto", "Augusto",
									  "Andre", "William", "Bento", "Yves", "Sandro", "Liam"};
	
	public static void main(String[] args) {
		//O supplier vai fornecer 10 nomes para serem usados por outros
		Supplier<List<String>> nomes = () ->{
			List<String> nomes_list = new ArrayList<>();
			Random random = new Random();
			for ( int i=0; i<10; i++ ) {
				nomes_list.add( Practice.nomes[random.nextInt( Practice.nomes.length )] );
			}
			return nomes_list;
		};
		
		Predicate<String> nomesComecamComA = nome -> nome.startsWith("A");
		Predicate<String> nomesTamanho5OuMais = nome -> nome.length() >= 5;
		Predicate<String> nomesTerminamComO = nome -> nome.endsWith("o");
		
		Consumer<List<String>> imprimeLista = lista -> System.out.println( lista );
		
		List<String> lista = nomes.get();
		imprimeLista.accept( lista );
		
		System.out.println("Nomes que comecam com A");
		imprimirListaFiltrada( lista, nomesComecamComA );
		System.out.println("Nomes que terminam com O");
		imprimirListaFiltrada( lista, nomesTerminamComO );
		System.out.println("Nomes com cinco ou mais caracteres");
		imprimirListaFiltrada( lista, nomesTamanho5OuMais );
		System.out.println("Nomes que comecam com A e terminam com O");
		imprimirListaFiltrada( lista, nomesComecamComA.and(nomesTerminamComO) );
		System.out.println("Nomes que terminam com O e tem cinco ou mais caracteres");
		imprimirListaFiltrada( lista, nomesTerminamComO.and(nomesTamanho5OuMais) );
		System.out.println("Nomes que comecam com A, terminam com O e tem cinco ou mais caracteres");
		imprimirListaFiltrada( lista, nomesComecamComA.and(nomesTerminamComO.and(nomesTamanho5OuMais)) );
		
	}
	
	
	
	private static void imprimirListaFiltrada( List<String> nomes, Predicate<String> predicate ) {
		System.out.println("**************** Lista Filtrada ****************");
		for ( String nome : nomes ) {
			if ( predicate.test(nome) ) {
				System.out.println( nome );
			}
		}
		System.out.println("************************************************");
	}

	
}