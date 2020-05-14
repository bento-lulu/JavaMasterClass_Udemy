package collections.sorted;

public class StockItem implements Comparable<StockItem> {
	private final String nome;
	private double preco;
	private int quantidade;
	
	public StockItem( String nome, double preco, int quantidade ) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
	public StockItem( String nome, double preco ) {
		this( nome, preco, 0 );
	}
	
	public String getNome() { return nome; }
	public double getPreco() { return preco; }
	public int getQuantidade() { return quantidade; }
	
	public void adjustarQuantidade( int quantidade ) {
		if ( quantidade > 0) {
			this.quantidade += quantidade;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( this == obj ) {
			return false;
		}
		if ( obj == null || this.getClass() != obj.getClass() ) {
			return false;
		}
		return this.getNome().equals( ((StockItem)obj).getNome() );
	}
	
	@Override
	public int hashCode() {
		return this.getNome().hashCode() + 3;
	}
	
	@Override
	public int compareTo(StockItem obj) {
		if ( this == obj ) {
			return 0;
		}
		if ( obj != null ) {
			return this.nome.compareTo( ((StockItem)obj).getNome() );
		}
		throw new NullPointerException("Nao pode comparar com null");
	}
	
}




