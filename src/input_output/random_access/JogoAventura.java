package input_output.random_access;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JogoAventura {

	public static void main(String[] args) throws IOException {
		Locations locais = new Locations();
		System.out.println( "Locais no Jogo" +locais );
		Scanner scanner = new Scanner( System.in );
		
		Map<String, String> vocabulario = new HashMap<>();
		vocabulario.put("NORTH", "N");
		vocabulario.put("SOUTH", "S");
		vocabulario.put("EAST", "E");
		vocabulario.put("WEST", "W");
		vocabulario.put("QUIT", "Q");
		
		int local_actual_int = 1;
		Local local_actual = locais.getLocal(local_actual_int);
		while (true) {
			System.out.println( local_actual.getDescricao() );
			System.out.print("Possiveis saidas: ");
			Map<String, Integer> saidas = local_actual.getSaidas();
			for ( String saida: saidas.keySet() ) {
				System.out.print( saida + " " );
			}
			System.out.println();
			
			String local_proximo = scanner.nextLine().toUpperCase();
			
			String[] words = local_proximo.split(" ");
			for ( String word: words ) {
				if ( vocabulario.containsKey(word) ) {
					local_proximo = vocabulario.get( word );
					System.out.println( "Encontrou direcao: " + word);
					break;
				}
			}
			System.out.println("Proximo e: " +local_proximo);
			if ( local_actual.getSaidas().containsKey( local_proximo ) ) {
				System.out.println("Movendo de " +local_actual.getDescricao()+ " para " 
												 +locais.getLocal( saidas.get(local_proximo) ).getDescricao());
				
				if ( local_proximo.equalsIgnoreCase("Q") ) {
					scanner.close();
					locais.close();
					break;
				}
				local_actual = locais.getLocal( saidas.get(local_proximo) );
			} else {
				System.out.println("Nao pode mover para esta d" );
			}
		}
	}

}
