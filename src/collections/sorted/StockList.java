package collections.sorted;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class StockList {
	private final Map<String, StockItem> lista;
	
	public StockList() {
		lista = new HashMap<>();
	}
	
	public Map<String, StockItem> getLista() {
		return Collections.unmodifiableMap( lista );
	}
	
	
	public int adicionarItem( StockItem item ) {
		if ( item != null ) {
			//verifica se o item ja esta no mapa, se sim retorna o item, se nao, retorna o novo item(o segundo parametro)
			StockItem noStock = lista.getOrDefault( item.getNome(), item );
			
			if ( noStock != item ) {
				item.adjustarQuantidade( item.getQuantidade() );
			}
			lista.put( item.getNome(), item );
			return item.getQuantidade();
		}
		return 0;
	}
	
	
	public int venderItem( String item, int quantidade ) {
		StockItem noStock = lista.getOrDefault( item, null );
		
		if ( (noStock != null) && (noStock.getQuantidade()-quantidade>=0) && (quantidade>=0) ) {
			noStock.adjustarQuantidade( -quantidade );
			return quantidade;
		}
		return 0;
	}
	
	
	public StockItem get( String nome ) {
		return lista.get( nome );
	}
	
}




