package generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Liga< T extends Equipa<?> > {
	private String nome;
	private List<T> equipas;
	
	Liga( String nome ){
		this.nome = nome;
		equipas = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean adicionar( T equipa ) {
		return equipas.add(equipa);
	}
	
	public void imprimirTabela() {
		System.out.println(getNome() + ":");
		System.out.println("Pos \tEquipa \t\tJ \tPts \tV \tE \tD \tGM \tGS \tDG");
		
		Collections.sort( equipas );
		
		for ( int i = 0; i < equipas.size(); i++ ) {
			Equipa<?> equipa = equipas.get( i );
			
			System.out.print(i+1 + "\t");
			System.out.print(equipa.getNome() + "\t");
			System.out.print(equipa.getJogos() + "\t");
			System.out.print(equipa.getPontos() + "\t");
			System.out.print(equipa.getVitorias() + "\t");
			System.out.print(equipa.getEmpates() + "\t");
			System.out.print(equipa.getDerrotas() + "\t");
			System.out.print(equipa.getGolosMarcados() + "\t");
			System.out.print(equipa.getGolosSofridos() + "\t");
			System.out.print(equipa.getDiferencaDeGolos() + "\t\n");
		}
	}
	
	
	
	
	
}
