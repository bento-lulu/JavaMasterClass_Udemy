package collections.map;

import java.util.HashMap;
import java.util.Map;

public class Local {
	private final int idLocal;
	private final String descricao;
	private final Map<String, Integer> saidas;
	
	Local( int idLocal, String descricao, Map<String, Integer> saidas ) {
		this.idLocal = idLocal;
		this.descricao = descricao;
		
		if ( saidas == null ) {
			this.saidas = new HashMap<>();
		} else {
			this.saidas = new HashMap<>( saidas );//criar novo objecto hashmap com dados recebidos como parametros,
												  //dando assim ao objecto, um novo objecto hashmap a que vai referenciar,
												  //e nao o objecto recebido, pois o objecto recebido pode ser alterado fora
												  //do codigo da classe, tornando assim o campo saidas em imutavel.
		}
		this.saidas.put("Q", 0);
	}
	
	public int getIdLocal() {
		return idLocal;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	
	public Map<String, Integer> getSaidas() {
		return new HashMap<>(saidas);//retornar nova referencia para o tornar imutavel, isto e,
									 //o codigo que chamou o metodo nao vai receber referencia
									 //ao objecto dentro da classe/objecto, mas sim um novo,
									 //nao tendo assim, como alterar o objecto fora dos
									 //metodos/da interface fornecidos pela classe
	}
	
}
