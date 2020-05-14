package collections.sets;

public final class Cadeira {
	private final String nome;
	private final double horas;
	
	public Cadeira(String nome, double horas) {
		this.nome = nome;
		this.horas = horas;
	}
	
	public String getNome() {
		return nome;
	}
	
	public double getHoras() {
		return horas;
	}
	
	@Override
	public boolean equals(Object obj) {
		//se forem a mesma referencia, sao iguais
		if ( this == obj ) {
			return true;
		}
		
		//se for nulo ou de classes diferente, nao sao iguais
		if ( obj == null || this.getClass() != obj.getClass() ) {
			return false;
		}
		
		Cadeira cadeira = (Cadeira) obj;
		if ( nome.equalsIgnoreCase(cadeira.nome) ) {
			return true;
		}
		return false;
	}
	
	static int count = 0; 
	@Override
	public int hashCode() {
		System.out.println( "count is " + ++count );
		return nome.hashCode() + 6;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
