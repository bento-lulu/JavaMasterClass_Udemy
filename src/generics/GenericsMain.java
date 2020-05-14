package generics;

public class GenericsMain {
	
	public static void main(String[] args) {
		
		Liga< Equipa<Futebol> > liga_inglesa = new Liga<>("Liga Inglesa");
		EquipaFutebol mcity = new EquipaFutebol("Man City");
		liga_inglesa.adicionar( mcity );
		EquipaFutebol mutd = new EquipaFutebol("Man United");
		liga_inglesa.adicionar( mutd );
		EquipaFutebol cfc = new EquipaFutebol("Chelsea FC");
		liga_inglesa.adicionar( cfc );
		EquipaFutebol lfc = new EquipaFutebol("Liverpool FC");
		liga_inglesa.adicionar( lfc );
		
		mcity.resultadoJogo( lfc, 2, 2);
		mcity.resultadoJogo( mutd, 0, 2);
		mcity.resultadoJogo( cfc, 3, 1);

		mutd.resultadoJogo( mcity, 2, 2);
		mutd.resultadoJogo( lfc, 0, 1);
		mutd.resultadoJogo( cfc, 1, 1);

		cfc.resultadoJogo( mcity, 0, 2);
		cfc.resultadoJogo( mutd, 2, 0);
		cfc.resultadoJogo( lfc, 2, 1);
		
		lfc.resultadoJogo( mcity, 3, 2);
		lfc.resultadoJogo( mutd, 2, 0);
		lfc.resultadoJogo( cfc, 1, 1);
		
		liga_inglesa.imprimirTabela();
		
		//lfc.resultadoJogo( new EquipaFutebol("Arsenal FC"), 8, 0);
		
		liga_inglesa.imprimirTabela();
		
		
		Liga< Equipa<Basquete> > nba = new Liga<>("NBA");
		EquipaBasquete bucks = new EquipaBasquete("Bucks\t");
		nba.adicionar( bucks );
		EquipaBasquete raptors = new EquipaBasquete("Raptors\t");
		nba.adicionar( raptors );
		EquipaBasquete celtics = new EquipaBasquete("Celtics\t");
		nba.adicionar( celtics );
		
		bucks.resultadoJogo(raptors, 86, 79);
		bucks.resultadoJogo(celtics, 102, 63);

		raptors.resultadoJogo(bucks, 65, 79);
		raptors.resultadoJogo(celtics, 86, 52);

		celtics.resultadoJogo(bucks, 73, 71);
		celtics.resultadoJogo(raptors, 66, 79);
		
		nba.imprimirTabela();
		
		
	}

}
