package interfaces;

public class MyBinarySearchTree {
	private LinkedItem root;//the middle element
	
	
	public boolean adicionar( LinkedItem novo_item ) {
		if ( novo_item==null ) {
			System.out.println("Nao pode adicionar elementos nullos");
			return false;
		}
		adicionarNaPosicao( null, root, novo_item );
		return true;
	}
	
	
	private boolean adicionarNaPosicao( LinkedItem parente, LinkedItem item, LinkedItem novo_item ) {
		
		//este codigo que insere um elemento na lista, pois encontrou posicao da arvore sem valor
		if ( item == null ) {
			if ( root == null ) {//se for o primeiro elemento, torna este em root
				root = novo_item;
				return true;
			}
			item = novo_item;//se nao for, torna este o elemento actual que era vazio
			
			if ( item.getValor() > parente.getValor() ) {
				parente.setProximo(item);//torna o novo elemento como o filho a direita, pois tem valor maior que o parente
			} else {
				parente.setAnterior(item);//torna o novo elemento como o filho a esquerda, pois tem valor menor que o parente
			}
			
			return true;
		}
		
		if( novo_item.getValor() > item.getValor() ) {
			//adiciona a direita
			System.out.println("Adicionar " +novo_item.getValor()+ " a direita");
			return adicionarNaPosicao( item, (LinkedItem)item.getProximo(), novo_item );
			
		} else if ( novo_item.getValor() < item.getValor() ) {
			//adiciona a esquerda
			System.out.println("Adicionar " +novo_item.getValor()+ " a esquerda");
			return adicionarNaPosicao( item, (LinkedItem)item.getAnterior(), novo_item );
		} else {
			System.out.println("Ja existe elemento " +novo_item.getValor()+ " na lista");
			return false;
			
		} 
	}
	
	
	
	public LinkedItem remover( LinkedItem item_por_remover ) {
		LinkedItem[] items = get( null, root, item_por_remover );
		LinkedItem parente = items[0];
		LinkedItem item = items[1];
		
		if ( item == null || parente == null ) {
			return null;
		}
		boolean item_tem_descendente_a_esquerda = item.getAnterior() != null;
		boolean item_tem_descendente_a_direita = item.getProximo() != null;
		boolean item_nao_tem_descentendes = (!item_tem_descendente_a_esquerda) && (!item_tem_descendente_a_direita);
		boolean item_tem_dois_descentendes = item_tem_descendente_a_esquerda && item_tem_descendente_a_direita;
		
		//se o item por remover nao tiver descendentes, apenas remove o elemento
		if ( item_nao_tem_descentendes ) {
			if ( item==parente.getAnterior() ) {
				parente.setAnterior(null);
			} else {
				parente.setProximo( null );
			}
			System.out.println("opt1");
			
		//se o item por remover tiver dois descendentes
		}else if ( item_tem_dois_descentendes ) {
			
			/**
			 * too hard for me ( crying )
			 */
			
		//se o item por remover tiver descendente a esquerda
		}else if ( item_tem_descendente_a_esquerda ) {
			if ( item == parente.getAnterior() ) {
				parente.setAnterior( item.getAnterior() );
			} else {
				parente.setProximo( item.getAnterior() );
			}
			System.out.println("opt2");
			
		//se o item por remover tiver descendent a direita
		}else if ( item_tem_descendente_a_direita ) {
			if ( item == parente.getAnterior() ) {
				parente.setAnterior( item.getProximo() );
			} else {
				parente.setProximo( item.getProximo() );
			}
			System.out.println("opt3");
		}
		
		return item;
	}
	
	
	public LinkedItem get( LinkedItem item ) {
		LinkedItem[] items = get( null, root, item );
		if (items==null) {
			System.out.println("Item " +item+ " nao encontrado na lista");
			return null;
		}
		
		return items[1];
	}
	private LinkedItem[] get( LinkedItem parente, LinkedItem actual, LinkedItem item ) {
		if ( actual == null ) {
			return null;
		}
		if ( item.getValor() == actual.getValor() ) {
			return new LinkedItem[]{ parente, actual};
		} else if (  item.getValor() < actual.getValor() ){
			return get( actual, (LinkedItem)actual.getAnterior(), item);
		} else {
			return get( actual, (LinkedItem)actual.getProximo(), item);
		}
	}
	
	
	
	public void imprimir() {
		System.out.println("************************");
		imprimirTree(root);
	}
	
	private void imprimirTree( LinkedItem item ) {
		
		if ( item == null ) {
			return;
		}
		imprimirTree( (LinkedItem)item.getAnterior() );
		System.out.println( item.getValor() );
		imprimirTree( (LinkedItem)item.getProximo() );
	}
}





