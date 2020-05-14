package interfaces;

public class MyLinkedList {
	private Item primeiro;
	private Item ultimo;
	
	public boolean adicionar( Item item ) {
		if( item == null) {
			return false;
		}
		if( primeiro != null ) {
			if ( ultimo.compareTo(item) > 0 ) {
				//novo item vai ser colocado no meio ou no inicio da lista
				adicionarNoMeio( item );
				return true;
				
			} else if( ultimo.compareTo(item) < 0 ) {
				//fazer com que o ultimo aponte para o novo item como seu proximo
				ultimo.setProximo(item);
				//fazer com que o novo item aponte para o ultimo como seu anterior
				item.setAnterior(ultimo);
				//o novo item ja e o ultimo item da lista
				ultimo = item;
				return true;
			} else {
				System.out.println("Elemento " +item.getValor()+ " ja existe na lista");
			}
			
		} else {
			ultimo = primeiro = item;
		}
		
		return false;
	}
	
	
	/**
	 * Para encontrar a posicao do item que vai estar a frente do novo item
	 * @param anterior
	 * @param novo_item
	 * @return
	 */
	private Item itemPorAfastar( Item anterior, Item novo_item ) {
		if ( novo_item.compareTo(anterior) == 0) {
			System.out.println("Elemento " +novo_item.getValor()+ " ja existe na lista");
			return null;
		}
		//se o item for maior que o 'anterior' que esta sendo comparado agora
		if ( novo_item.compareTo(anterior) > 0 ) {
			//encontrou o item menor que o novo, entao vai retornar o item proximo deste,
			//pois e o primeiro item maior que o novo, e vai ser 'afastado' para dar lugar ao novo item
			//e sera o proximo item do novo item
			return anterior.getProximo();
		}
		
		if( anterior.getAnterior() == null) {
			//retorna o primeiro pois chegou no inicio da lista e vai colocar o novo item no inicio da lista
			//trocando com o actual primeiro
			return primeiro;
		}
		//recursao para comparar com o elemento anterior ate encontrar a posicao certa
		return itemPorAfastar( anterior.getAnterior(), novo_item );
	}
	
	
	/**
	 * Para inserir o novo item na posicao certa
	 * @param novo_item
	 */
	private void adicionarNoMeio( Item novo_item ) {
		//encontrar o item que sera afastado na lista para dar lugar ao novo,
		//se tornando assim, o proximo item do novo item 
		Item item_por_afastar = itemPorAfastar( ultimo.getAnterior(), novo_item );
		
		if ( item_por_afastar != null ) {//se o item 
			novo_item.setAnterior( item_por_afastar.getAnterior() );
			novo_item.setProximo( item_por_afastar );
			item_por_afastar.setAnterior( novo_item );
			
			if ( novo_item.getAnterior() != null ) {
				novo_item.getAnterior().setProximo(novo_item);
			} else {
				primeiro = novo_item;
			}
		}
	}
	
	
	
	public void remover( Item item ) {
		if(item ==null) {
			System.out.println("Lista nao tem nulos!");
			return;
		}
		
		if ( primeiro==null ) {
			System.out.println("Lista vazia!");
			return;
		}
		item = itemPorRemover(primeiro, item);
		
		if ( item == primeiro ) {
			if ( item.getProximo() !=null ) {
				item.getProximo().setAnterior(null);
				primeiro = item.getProximo();
				return;
			} else {
				ultimo = primeiro = null;
			}
		}
		if( item == ultimo ) {
			item.getAnterior().setProximo(null);
			ultimo = item.getAnterior();
			return;
		}
		
		item.getAnterior().setProximo(item.getProximo());
		item.getProximo().setAnterior(item.getAnterior());
	}
	
	
	
	
	private Item itemPorRemover( Item actual, Item item ) {
		if ( actual==null ) {
			System.out.println("Elemento " +item.getValor()+ "nao existe na lista");
			return null;
		}
		if ( item.getValor() == actual.getValor() ) {
			return actual;
		}
		return itemPorRemover(actual.getProximo(), item);
	}
	
	
	
	
	
	
	public void imprimir( ) {
		imprimir ( primeiro );
	}
	private void imprimir( Item item ) {
		if ( item == null ) {
			return;
		}
		System.out.println(item);
		imprimir( item.getProximo() );
	}
	
	
	
	public void imprimirDescendente( ) {
		imprimirDescendente ( ultimo );
	}
	private void imprimirDescendente( Item item ) {
		if ( item == null ) {
			return;
		}
		System.out.println(item);
		imprimirDescendente( item.getAnterior() );
	}
	
}





