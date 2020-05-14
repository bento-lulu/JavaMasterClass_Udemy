package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparavel {
	
	public static void main(String[] args) {
		
		Comparator<Item> comparador = new Comparator<Comparavel.Item>() {
			@Override
			public int compare(Item obj1, Item obj2) {
				if ( obj1.getNumero() > obj2.getNumero() ) {
					return 1;
				} else if ( obj1.getNumero() < obj2.getNumero() ) {
					return -1;
				}else {
					return 0;
				}
			}
		};
		
		Comparavel comparavel = new Comparavel();
		List<Item> items = new ArrayList<>();
		items.add( comparavel.new Item(15) );
		items.add( comparavel.new Item(19) );
		items.add( comparavel.new Item(5) );
		items.add( comparavel.new Item(23) );
		
		System.out.println( items );
		Collections.sort( items, comparador );
		System.out.println( items );
	}
	
	
	
	private class Item {
		private final int numero;
		
		public Item( int numero ) {
			this.numero = numero;
		}
		
		public int getNumero() {
			return numero;
		}
		
		@Override
		public String toString() {
			return numero + "";
		}
	}
}



