package interfaces;

public class LinkedItem extends Item {
	
	public LinkedItem(int valor) {
		super(valor);
	}
	
	public int compareTo( Item item ) {
		if ( valor > item.getValor() ) {
			return 1;
		} else if( valor < item.getValor() ) {
			return -1;
		} else {
			return 0;
		}
	}
	
	@Override
	public String toString() {
		//int a_hash = (anterior!=null)? anterior.hashCode() : 0;
		//int p_hash = (proximo!=null)? proximo.hashCode() : 0;
		//return "(" +hashCode()+ ") =>\t " +a_hash+ "\t| " +valor+ "\t| " +p_hash;
		return getValor()+ "";
	}
	
}
