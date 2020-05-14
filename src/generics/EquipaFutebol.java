package generics;

public class EquipaFutebol extends Equipa<Futebol> {
	
	public EquipaFutebol(String nome) {
		super(nome);
	}
	
	@Override
	public int getPontos() {
		return this.vitorias*3 + this.empates;
	}

	@Override
	public int getDiferencaDeGolos() {
		return this.golosMarcados - this.golosSofridos;
	}
	
	@Override
	public void resultadoJogo( Equipa<Futebol> adversario, int golosMarcados, int golosSofridos ) {
		this.golosMarcados += golosMarcados;
		this.golosSofridos += golosSofridos;
		this.jogos++;
		if ( golosMarcados > golosSofridos ) {
			this.vitorias++;
		}else if ( golosMarcados < golosSofridos ) {
			this.derrotas++;
		} else {
			this.empates++;
		}
		if ( adversario != null) {
			adversario.resultadoJogo( null, golosSofridos, golosMarcados );
		}
	}

}
