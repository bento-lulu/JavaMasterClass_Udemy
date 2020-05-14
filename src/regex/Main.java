package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		
		String alphanumeric = "abcDeeeF12ugiiiiiiZZzzz9";
		System.out.println( alphanumeric.replaceAll( ".", "Y" ) );//. representa qualquer character
		System.out.println( alphanumeric.replaceAll( "^abcDeee", "INICIO" ) );//^ representa inicio da frase
		System.out.println( alphanumeric.replaceAll( "^F12", "FF" ) );//nao substitui porque F12 nao esta no inicio da frase
		
		System.out.println( alphanumeric.matches("^hello") );//Com metodo matches(), o texto e verificado para saber se todo o
		System.out.println( alphanumeric.matches("^abcDeee") );//string vai de acordo com o regex especificado.
		System.out.println( alphanumeric.matches("abcDeeeF12ugiiiiiiZZzzz9") );
		
		System.out.println( alphanumeric.replaceAll("zzz9$", "FIM") );//$ representa fim da frase
		System.out.println( alphanumeric.replaceAll("[aei]", "-") );//[] substitui cada caracter dentro de parenteses
																		 //rectos por -, [] conjunto de caracteres
		System.out.println( alphanumeric.replaceAll( "[aei]F", "-" ) );//substitui qualquer caracter dentro de parenteses rectos
																	   //juntamente com F depois deles ( aF, eF, iF )
		System.out.println( alphanumeric.replaceAll( "[aei][bFZ9]", "-" ) );//substitui dois caracteres tambem, um dentro de cada
																			//parenteses rectos (ex.: iZ)
		System.out.println( "bento".matches("[Bb]ento")  );
		
		System.out.println( alphanumeric.replaceAll("[^ei]", "X") );//^ dentro de parenteses rectos significa negacao, isto e,
																	//vai substituir todos caracteres menos 'e' e 'i'
		System.out.println( alphanumeric.replaceAll( "[a-fA-F0-5]", "O" ));//substitui no intervalo de 'a' a 'f', 'A'-'F' e
																		   //0 a 5 po O
		System.out.println( alphanumeric.replaceAll( "(?i)[a-f0-5]", "O" ));//(?i) desactiva case sensitivity
		
		System.out.println( alphanumeric.replaceAll( "[0-9]", "-" ) );//substitui todos numeros
		System.out.println( alphanumeric.replaceAll( "\\d", "-" ));//substitui todos numeros/digitos
		System.out.println( alphanumeric.replaceAll( "\\D", "-" ));//substitui todos nao numeros/digitos
		
		String hasWhiteSpace = "I have blanks and\ta tab, and also a newLine\n";
		System.out.println( hasWhiteSpace );
		System.out.println( hasWhiteSpace.replaceAll( "\\s", "") );//remove todos espacos em branco (espaco, tab, newLine)
		System.out.println( hasWhiteSpace.replaceAll( "\\S", "" ) );//remove tudo que nao e espaco em branco
		System.out.println( hasWhiteSpace.replaceAll( "\\t", "" ) );//remove so os tabs
		
		System.out.println( hasWhiteSpace.replaceAll( "\\w", "X" ) );//substitui letras maiusculas e minusculas, numeros e
																	 //underscore
		System.out.println( hasWhiteSpace.replaceAll( "\\W", "X" ) );//substitui tudo que nao e letras maiusculas e minusculas,
																	 //numeros e underscore
		
		System.out.println( hasWhiteSpace.replaceAll( "\\b", "'" ) );//vai colocar o ' antes e depois de cada palavra
		
		System.out.println( "senha1".matches("\\w{6}"));//senha deve ter exatamente 6 caracteres
		System.out.println( "senha1".matches("[a-fA-F0-9]{6}"));//senha deve ter exatamente 6 caracteres
		
		System.out.println( alphanumeric.replaceAll( "^abcDe{3}", "H" ) );//inicio de texto com abcD e 3 'e'
		System.out.println( alphanumeric.replaceAll( "^abcDe+", "H" ) );//inicio de texto com abcD e um ou mais 'e'
		System.out.println( alphanumeric.replaceAll( "^abcDe*", "H" ) );//inicio de texto com abcD e zero ou mais 'e'
		
		System.out.println( alphanumeric.replaceAll( "^abcDe{2,5}", "H") );//inicio de texto com abcD e dois a 5 'e'
		
		System.out.println( alphanumeric.replaceAll("gi*Z+", "Y"));
		
		StringBuilder htmlText = new StringBuilder();
		htmlText.append("<h1>Titulo</h1>");
		htmlText.append("<h2>SubTitulo1</h2>");
		htmlText.append("<p>Paragrafo</p>");
		htmlText.append("<h2>SubTitulo2</h2>");
		htmlText.append("<p>Paragrafo</p>");
		Pattern pattern = Pattern.compile(".*<h2>.*");
		Matcher matcher = pattern.matcher( htmlText );
		System.out.println( matcher.matches() );//matches entire text
		//matcher.reset();
		
		pattern = Pattern.compile("<h2>");
		matcher = pattern.matcher( htmlText );
		int count = 0;
		while( matcher.find() ) {//finds occurrences
			count++;
			System.out.println( "Occurrence " +count+ " : " +matcher.start()+ " to " +matcher.end() );
		}
		
		//Pattern groupPattern = Pattern.compile("(<h2>\\w*</h2>)");//minha versao, faz o mesmo que a solucao de Tim abaixo
		Pattern groupPattern = Pattern.compile("(<h2>.*?</h2>)");//? aqui, significa que assim que encontrar o primeiro </h2>
																//vai parar de procurar mais, e retornar no find()
																//como encontrado. Sem isto, o find ia retornar tudo, desde o
																//primeiro <h2> ate o ultimo </h2>
		Matcher groupMatcher = groupPattern.matcher(htmlText);
		System.out.println( groupMatcher.matches() );
		groupMatcher.reset();
		while ( groupMatcher.find() ) {
			System.out.println( "Occurrence: " + groupMatcher.group(1) );
		}
		
		groupPattern = Pattern.compile("(<h2>)(.*?)(</h2>)");//para pegar apenas o texto dentro dos tags <h2>
		groupMatcher = groupPattern.matcher(htmlText);
		while( groupMatcher.find() ) {
			System.out.println( "H2 Content: " + groupMatcher.group(2) );//segundo grupo e o conteudo, primeiro e <h2>
																		 //e terceiro e </h2>
		}
		
		System.out.println( "harry".replaceAll( "[H|h]arry", "Harry" ) );//H ou h
		System.out.println( "harry".replaceAll( "[Hh]arry", "Harry" ) );//H ou h
		
		System.out.println( "tstvtkt".replaceAll( "t(?!v)", "M") );//Com ?, o regex vai procurar por t que nao e seguido de v, mas sem incluir este caractere que
																   //o segue, logo a substituicao nao sera de t e o caractere a seguir que nao e v, mas sim
																   //apenas t, incluindo o ultimo t que nao e seguido de v e de nenhum outro caractere
		System.out.println( "tstvtkt".replaceAll( "t(?=v)", "M") );//Substitui t seguido de v, mas sem incluir o v na substituicao
		
		String mozPhoneRegex = "\\+*(258)*[ ]*8[2-7]{1}[0-9]{7}$";//$ - para dizer que nada deve estar depois do ultimo caractere especificado
		System.out.println( "+258826647508".matches(mozPhoneRegex) );
		System.out.println( "826647508".matches(mozPhoneRegex) );
		System.out.println( "+258 826647508".matches(mozPhoneRegex) );
		System.out.println( "258 826647508".matches(mozPhoneRegex) );
		System.out.println( "258826647508".matches(mozPhoneRegex) );
		System.out.println( "+258886647508".matches(mozPhoneRegex) );
		System.out.println( "226647508".matches(mozPhoneRegex) );
		System.out.println( "+259 826647508".matches(mozPhoneRegex) );
		System.out.println( "25826647508".matches(mozPhoneRegex) );
		System.out.println( "258826647508".matches(mozPhoneRegex) );
		
		
	}
}





