package interfaces;

public class BinarySearchTreeMain {

	public static void main(String[] args) {
		System.out.println( java.time.LocalTime.now() );
		MyBinarySearchTree binarySearchTree = new MyBinarySearchTree();
		binarySearchTree.adicionar( new LinkedItem(10));
		binarySearchTree.adicionar( new LinkedItem(8));
		binarySearchTree.adicionar( new LinkedItem(9));
		binarySearchTree.adicionar( new LinkedItem(7));
		binarySearchTree.adicionar( new LinkedItem(18));
		binarySearchTree.adicionar( new LinkedItem(20));
		binarySearchTree.adicionar( new LinkedItem(11));
		binarySearchTree.adicionar( new LinkedItem(22));
		binarySearchTree.adicionar( new LinkedItem(19));
		binarySearchTree.adicionar( new LinkedItem(2));
		binarySearchTree.adicionar( new LinkedItem(16));
		binarySearchTree.adicionar( new LinkedItem(15));
		binarySearchTree.imprimir();
		
		System.out.println("\n***********************************");
		System.out.println( binarySearchTree.get(new LinkedItem(11)) );
		
		System.out.println("\n***********************************");
		
		binarySearchTree.remover( new LinkedItem(16) );
		binarySearchTree.imprimir();
		System.out.println( java.time.LocalTime.now() );
		
	}

}
