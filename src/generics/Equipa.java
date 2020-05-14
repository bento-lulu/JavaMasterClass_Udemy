package generics;

public abstract class Equipa<T extends Desporto> implements Comparable< Equipa<T> > {
	protected String nome;
	protected int jogos;
	protected int vitorias;
	protected int empates;
	protected int derrotas;
	protected int golosMarcados;
	protected int golosSofridos;
	
	public Equipa( String nome ) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getJogos() {
		return jogos;
	}
	
	public int getVitorias() {
		return vitorias;
	}
	
	public int getEmpates() {
		return empates;
	}
	
	public int getDerrotas() {
		return derrotas;
	}
	
	public int getGolosMarcados() {
		return golosMarcados;
	}
	
	public int getGolosSofridos() {
		return golosSofridos;
	}
	
	public abstract int getPontos();
	
	public abstract int getDiferencaDeGolos();
	
	public abstract void resultadoJogo( Equipa<T> adversario, int golos_marcados, int golos_sofridos );
	
	@Override
	public int compareTo( Equipa<T> equipa) {
		if  ( getPontos() > equipa.getPontos() ) {
			return -1;
		} else if ( getPontos() < equipa.getPontos() ) {
			return 1;
		} else {
			if ( getDiferencaDeGolos() > equipa.getDiferencaDeGolos() ) {
				return -1;
			} else if( getDiferencaDeGolos() < equipa.getDiferencaDeGolos() ) {
				return 1;
			}
			return 0;
		}
	}

}
