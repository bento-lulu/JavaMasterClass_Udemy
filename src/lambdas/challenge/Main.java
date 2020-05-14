package lambdas.challenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {
		/*Challenge 1
		Runnable runnable = ()->{
			String myString = "Let's split this up into an array";
			String[] parts =  myString.split(" ");
			for ( String part : parts ) {
				System.out.println(part);
			}
		};
		new Thread(runnable).start();*/
		
		/*Challenge
		Function<String, String> everySecondChar = (String source) ->{
			StringBuilder returnVal = new StringBuilder();
			for ( int i=0; i< source.length(); i++) {
				if ( i%2 ==1 ) {
					returnVal.append( source.charAt(i) );
				}
			}
			return returnVal.toString();
		};
		
		//Challenge 3
		//System.out.println( everySecondChar.apply( "1234567890" ) );
		
		//Challenge 5
		System.out.println( everySecondCharacter("1234567890", everySecondChar) );
		
		//Challenge 6
		Supplier<String> iLoveJava = ()-> "I love Java!";
		//Challenge 7
		String supplierResult = iLoveJava.get();
		System.out.println( supplierResult );*/
		
		//Challenge 8
		//To map a lambda expression to an interface, the interface must have just one abstract method
		
		//Challenge 9 and 10
		List<String> topNames2015 = Arrays.asList("amelia", "Olivia", "emily", "Isla", "Ava",
												  "oliver", "Jack", "Charlie", "harry", "Jacob" );
		/*
		List<String> upperCasedNames = new ArrayList<>();
		topNames2015.forEach( name -> upperCasedNames.add( name.substring(0,1).toUpperCase().concat(name.substring(1)) ) );
		upperCasedNames.sort( String::compareTo );
		upperCasedNames.forEach( System.out::println );*/
		
		//Challenge 11
		topNames2015.stream()
					.map( name -> name.substring(0,1).toUpperCase().concat(name.substring(1)) )
					.sorted(String::compareTo)
					.forEach(System.out::println);
		
		//Challenge 12
		long namesStartWithA = topNames2015.stream()
										   .map( name -> name.substring(0,1).toUpperCase().concat(name.substring(1)) )
										   .filter( str -> str.startsWith("A"))
										   .count();
		System.out.println(namesStartWithA);
		
		//Challenge 13
		//Nothing will be printed because there is no Terminal Operation at the end of the stream pipe
		//so executing the Intermediate Operations will not make sense as they will not be used, so jvm
		//will save processing power by not executing them
		
		topNames2015.stream()
			        .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
			        .peek(System.out::println)
			        .sorted(String::compareTo)
			        .toArray();
	}
	
	//Challenge 4
	private static String everySecondCharacter( String text, Function<String, String> function ) {
		return function.apply( text );
	}
}











