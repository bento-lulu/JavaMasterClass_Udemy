package collections.sets;

import java.util.HashSet;
import java.util.Set;

public final class Estudante {
	private final String numeroEstudante;
	private final String nome;
	private final Set<Cadeira> cadeiras;
	
	public Estudante( String numeroEstudante, String nome ) {
		this.numeroEstudante = numeroEstudante;
		this.nome = nome;
		this.cadeiras = new HashSet<>();
	}
	
	public String getNumeroEstudante() {
		return numeroEstudante;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void adicionarCadeira( Cadeira cadeira ) {
		this.cadeiras.add(cadeira);
	}
	
	public Set<Cadeira> getCadeiras() {
		return new HashSet<>(cadeiras);
	}
}
