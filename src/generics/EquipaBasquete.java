package generics;

public class EquipaBasquete extends Equipa<Basquete> {
	
	public EquipaBasquete( String nome ) {
		super( nome );
	}

	@Override
	public int getPontos() {
		return this.vitorias*2 + this.derrotas*1;
	}

	@Override
	public int getDiferencaDeGolos() {
		return this.golosMarcados - this.golosSofridos;
	}

	@Override
	public void resultadoJogo( Equipa<Basquete> adversario, int golosMarcados, int golosSofridos ) {
		this.golosMarcados += golosMarcados;
		this.golosSofridos += golosSofridos;
		this.jogos++;
		
		if ( golosMarcados > golosSofridos ) {
			vitorias++;
		}else if ( golosMarcados < golosSofridos ) {
			derrotas++;
		} else {
			System.out.println("Nao pode haver empates no basquete");
			return;
		}
		if ( adversario != null ) {
			adversario.resultadoJogo( null, golosSofridos, golosMarcados );
		}
		
	}
	
}
