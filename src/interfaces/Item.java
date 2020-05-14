package interfaces;

public abstract class Item {
	
	protected Item anterior;
	protected Item proximo;
	protected int valor;
	
	public Item( int valor ) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public Item getAnterior() {
		return anterior;
	}
	public void setAnterior(Item anterior) {
		this.anterior = anterior;
	}
	
	public Item getProximo() {
		return proximo;
	}
	public void setProximo(Item proximo) {
		this.proximo = proximo;
	}
	
	public abstract int compareTo( Item item );
}



