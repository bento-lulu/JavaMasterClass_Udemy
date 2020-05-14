package input_output.sequential_access.binary_io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JogoAventura {

	public static void main(String[] args) {
		Locations locais = new Locations();
		Scanner scanner = new Scanner( System.in );
		
		
		Map<String, String> vocabulario = new HashMap<>();
		vocabulario.put("NORTH", "N");
		vocabulario.put("SOUTH", "S");
		vocabulario.put("EAST", "E");
		vocabulario.put("WEST", "W");
		vocabulario.put("QUIT", "Q");
		
		int local_actual = 1;
		while (true) {
			System.out.println( locais.get( local_actual ).getDescricao() );
			System.out.print("Possiveis saidas: ");
			Map<String, Integer> saidas = locais.get(local_actual).getSaidas();
			for ( String saida: saidas.keySet() ) {
				System.out.print( saida + " " );
			}
			System.out.println();
			
			String local_proximo = scanner.nextLine().toUpperCase();
			
			String[] words = local_proximo.split(" ");
			for ( String word: words ) {
				if ( vocabulario.containsKey(word) ) {
					local_proximo = vocabulario.get( word );
				}
			}
			
			if ( locais.get( local_actual ).getSaidas().containsKey( local_proximo ) ) {
				System.out.println("Movendo de " +locais.get(local_actual).getDescricao()+ " para " 
												 +locais.get( saidas.get( local_proximo ) ).getDescricao());
				
				if ( local_proximo.equalsIgnoreCase("Q") ) {
					scanner.close();
					break;
				}
				local_actual = saidas.get( local_proximo );
			} else {
				System.out.println("Nao pode mover para esta posicao" );
			}
		}
	}

}
