package lambdas.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		
		List<String> bingoNumbers = Arrays.asList(
				"N40", "N36",
				"B12", "B6",
				"G53", "G49", "G60", "G50", "g64", "g4",
				"I26", "I17","I29",
				"O71"
		);
		
		List<String> selected = new ArrayList<>();
		bingoNumbers.forEach( number -> {
			if ( number.toUpperCase().startsWith("G") ) {
				selected.add( number );
			}
		});
		
		selected.sort( (String s1, String s2) -> s1.compareToIgnoreCase(s2) );
		selected.forEach( (String number) -> System.out.println(number) );
		System.out.println("***********************");
		
		//The same as bellow with streams
		bingoNumbers.stream()//cria um stream de elementos da lista
					.map(String::toUpperCase)//chama o metodo toUpperCase() em todos elementos do stream e returna o resultado em stream de elementos retornados,
											//mapeia os elementos pelos resultados da operacao em cada um
					.filter( str -> str.startsWith("G"))//filtra os elementos do stream com o Predicate fornecido, e retorna os elementos que retornaram true a condicao do Predicate
					.sorted()//retorna um stream com os elementos do stream ordenados
					.forEach( System.out::println );//terminal operation, pois nao retorna um stream
		
		//Embora os elementos da lista sao transformados em stream e manipulados, a lista nao e alterada, so o stream
		System.out.println("\n" +bingoNumbers);
		
		//operacoes em streams devem ter duas caracteristicas:
			//1. Nao alterar a fonte do stream (a lista) de nenhuma forma
			//2. Nao depender do resultado de outra operacao para operar
		
		//stream from scratch:
		Stream<String> numbers1 = Stream.of( "I26", "I17", "I29", "O71" );
		Stream<String> numbers2 = Stream.of( "N40", "N36", "I26", "I17", "I29", "O71" );
		Stream<String> combinedNumbers = Stream.concat( numbers1, numbers2 );
		//System.out.println( combinedNumbers.count() );//count e terminal operation, por isso comentei para operar denovo no stream abaixo
		//System.out.println( combinedNumbers.distinct().count() );
		
		//para imprimir valores do stream sem terminar operacoes nele: usa o metodo peek(), que e um Consumer que recebe
		//o stream, performa a sua accao e adiciona todos elementos do stream num novo stream para o retornar. O metodo
		//e normalmente usado para debugging, sem fazer alteracoes no stream.
		System.out.println("**********************");
		System.out.println(
		combinedNumbers.distinct()
					   .peek( System.out::println )
					   .count()
		);
		
		
		
		
	}

}
