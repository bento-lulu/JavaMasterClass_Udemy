package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetodosCollections {

	public static void main(String[] args) {
		
		//Com tipo simples, o valor a mudar e o objecto
		List<String> nomes = new ArrayList<>();
		nomes.add("Abel");
		nomes.add("Victor");
		nomes.add("Lebowsky");
		nomes.add("Timo");
		System.out.println( nomes );
		
		List<String> nomesCopia = new ArrayList<>( nomes );//shallow copy, copies references, not the objects
		nomesCopia.set( 0, "Antonio" );//this will point to new object
		
		System.out.println( nomes );
		System.out.println( nomesCopia );
		
		System.out.println("***************************************************");
		
		//Com tipo composto, o valor a mudar e atributo do objecto
		List<Mutavel> mutaveis = new ArrayList<>();
		mutaveis.add( new Mutavel("Abel") );
		mutaveis.add( new Mutavel("Victor") );
		mutaveis.add( new Mutavel("Lebowsky") );
		mutaveis.add( new Mutavel("Timo") );
		System.out.println( mutaveis );
		
		List<Mutavel> mutaveisCopiaCopia = new ArrayList<>( mutaveis );//shallow copy, copies references, not the objects
		mutaveisCopiaCopia.set( 0, new Mutavel("Antonio") );//this will point to new object
		mutaveisCopiaCopia.get(1).valor = "Novo Nome";//this changes the string in the object, not the object
													  //so the object is still the same
		Collections.shuffle( mutaveisCopiaCopia );//shuffle the list
		
		System.out.println( mutaveis );
		System.out.println( mutaveisCopiaCopia );
		
		System.out.println( "Min: " + Collections.min( mutaveisCopiaCopia ) );
		System.out.println( "Max: " + Collections.max( mutaveisCopiaCopia ) );
		
		int[] array = new int[]{ 12, 14, 15, 17, 18, 19, 21 };
		swap( array, 0, 6 );
		
		for( int i : array ) {
			System.out.print( i + ", " );
		}
		System.out.println();
	}
	
	
	private static void swap( int[] array, int index1, int index2 ) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	

	private static class Mutavel implements Comparable<Mutavel>{
		private String valor;
		
		public Mutavel( String valor ) {
			this.valor = valor;
		}
		
		@Override
		public String toString() {
			return this.valor;
		}
		
		@Override
		public int compareTo( Mutavel obj ) {
			return this.valor.compareToIgnoreCase( obj.valor );
		}
	}
}




