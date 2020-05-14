package interfaces;

public class LinkedListMain {
	
	public static void main(String[] args) {
		
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.adicionar( new LinkedItem( 5 ) );
		linkedList.adicionar( new LinkedItem( 300 ) );
		linkedList.adicionar( new LinkedItem( 10 ) );
		linkedList.adicionar( new LinkedItem( 10 ) );
		linkedList.adicionar( new LinkedItem( 11 ) );
		linkedList.adicionar( new LinkedItem( 1 ) );
		linkedList.adicionar( new LinkedItem( 111 ) );
		linkedList.adicionar( new LinkedItem( 25 ) );
		linkedList.adicionar( new LinkedItem( 5 ) );
		
		linkedList.remover( new LinkedItem(10) );
		
		linkedList.imprimir();
		System.out.println();
		linkedList.imprimirDescendente();
	}
}