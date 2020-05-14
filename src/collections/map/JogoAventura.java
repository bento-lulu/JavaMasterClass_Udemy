package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JogoAventura {

	public static void main(String[] args) {
		
		Map<Integer, Local> locais = new HashMap<Integer, Local>();
		Scanner scanner = new Scanner( System.in );
		
		Map<String, Integer> temp_saidas = new HashMap<>();
		locais.put(0, new Local(0, "Saida do Jogo", temp_saidas) );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("W", 2);
		temp_saidas.put("S", 4);
		temp_saidas.put("E", 3);
		temp_saidas.put("N", 5);
		Local road = new Local( 1, "Road", temp_saidas );
		locais.put(1, road );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("N", 5);
		Local hill = new Local( 2, "Hill", temp_saidas );
		locais.put(2, hill );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("W", 1);
		Local building = new Local( 3, "Building", temp_saidas );
		locais.put(3, building );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("N", 1 );
		temp_saidas.put("W", 2 );
		Local valley = new Local( 4, "Valley", temp_saidas );
		locais.put(4, valley );
		
		temp_saidas = new HashMap<>();
		temp_saidas.put("S", 1);
		temp_saidas.put("W", 2 );
		Local forest = new Local( 5, "Forest", temp_saidas );
		locais.put(5, forest );
		
		
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
