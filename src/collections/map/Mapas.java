package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Mapas {
	public static void main(String[] args) {
		Map<String, String> linguagens = new HashMap<>();
		//o metodo put retorna o antigo valor guardado pela chave inserida, ou null se for a primeira vez a inserir a chave
		linguagens.put( "Java", "A compiled high level, object-oriented, platform independent language");
		linguagens.put( "C#", "A compiled high level, object-oriented language");
		linguagens.put( "SQL", "The database comunicator language" );
		linguagens.put( "Python", "An interpreted, high level programming language" );
		
		linguagens.put( "SQL", "Structrured Query Language, comunicates with databases" );//vai actualizar valor da chave SQL
		
		putInMap(linguagens, "SQL", "Structrured Query Language" );
		
		System.out.println( linguagens.get("SQL") );
		
		linguagens.remove("C#");//remove pelo key
		linguagens.remove("Java", "linguagem escolhida");//remove se tiver o par <key, value> fornecido
		
		System.out.println("***************************************");
		imprimir(linguagens);
	}
	
	//metodo para prevenir que os valores ja inseridos, sejam alterados
	private static void putInMap( Map<String, String> map, String chave, String valor ) {
		if ( map.containsKey(chave) ) {
			System.out.println("Ja existe " +chave+ " no mapa");
		} else {
			map.put( chave, valor );
			System.out.println("");
		}
	}
	
	
	private static void imprimir( Map<String, String> map ) {
		Set<String> chaves = map.keySet();
		
		for( String i: chaves ) {
			System.out.println( i+ " : " +map.get(i) );
		}
	}
}
