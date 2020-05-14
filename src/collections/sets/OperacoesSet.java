package collections.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OperacoesSet {

	public static void main(String[] args) {
		
		Set<Integer> quadrados = new HashSet<>();
		Set<Integer> cubos = new HashSet<>();
		
		for ( int i=1; i <= 10; i++) {
			quadrados.add( i * i );
			cubos.add( i * i * i );
		}
		System.out.println( "Conjunto dos Quadrados:\t" +quadrados+ " - " +quadrados.size() );
		System.out.println( "Conjunto dos Cubos:\t" +cubos+ " - " +cubos.size() );
		
		//Uniao dos conjuntos / Sets
		Set<Integer> uniao = new HashSet<>(quadrados);//e necessario criar novo conjunto para aplicar as operacoes
													  //de conjuntos, pois estas operacoes sao caoticas, isto e, modificam
													  //os valores ou estado do objecto que chama a operacao
		uniao.addAll(cubos);
		System.out.println( "Uniao dos Conjuntos:\t" +uniao+ " - " +uniao.size() );
		
		
		//Interseccao dos conjuntos / Sets
		Set<Integer> interseccao = new HashSet<>(quadrados);
		interseccao.retainAll(cubos);
		System.out.println( "Interseccao Conjuntos:\t" +interseccao+ " - " +interseccao.size() );
		
		//Diferenca dos conjuntos / Sets. Criar novos conjuntos com texto so para testar
		System.out.println("\n############################################################\n");
		
		String frase1 = "Dont force yourself to fit in a place where you dont belong";
		String[] palavras1 = frase1.split(" ");
		Set<String> conjunto1 = new HashSet<>( Arrays.asList(palavras1) );
		System.out.println( "Conjunto 1:" +conjunto1 );
		
		String frase2 = "Dont force yourself to fit in somewhere you dont belong";
		String[] palavras2 = frase2.split(" ");
		Set<String> conjunto2 = new HashSet<>( Arrays.asList( palavras2 ) );
		System.out.println( "Conjunto 2:" +conjunto2 );
		
		Set<String> diferenca1 = new HashSet<>(conjunto1);
		diferenca1.removeAll( conjunto2 );
		System.out.println("Conjunto1 - Conjunto2 = " +  diferenca1 );
		
		Set<String> diferenca2 = new HashSet<>(conjunto2);
		diferenca2.removeAll( conjunto1 );
		System.out.println("Conjunto2 - Conjunto1 = " +  diferenca2 );
		
		//Diferenca acima sao assimetricas, isto e, conjunto1.removeAll(conjunto2) e diferente de conjunto2.removeAll(conjunto1)
		//Para ter diferenca simetrica, isto e, todos elementos em conjunto1 e todos do conjunto2, menos a sua interseccao
		//devemos fazer a uniao menos a interseccao
		Set<String> uniao_conjuntos = new HashSet<>(conjunto1);
		uniao_conjuntos.addAll(conjunto2);//uniao conjunto1 e conjunto2
		
		Set<String> interseccao_conjuntos = new HashSet<>(conjunto1);
		interseccao_conjuntos.retainAll(conjunto2);//interseccao de conjunto1 e conjunto2
		
		Set<String> diferenca_simetrica = new HashSet<>(uniao_conjuntos);
		diferenca_simetrica.removeAll(interseccao_conjuntos);
		System.out.println("Diferenca Simetrica: = " +  diferenca_simetrica );
		
		
	}
	
}




