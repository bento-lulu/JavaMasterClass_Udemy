package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Challenge {

	public static void main(String[] args) {
		
		//Challenge 1
		String challenge1 = "I want a bike.";
		String regex = "I want a bike.";
		System.out.println( challenge1.matches( regex ) );
		
		//Challenge 2
		String challenge2 = "I want a ball.";
		regex = "I want a (bike|ball)\\.";
		System.out.println( challenge1.matches( regex ) );
		System.out.println( challenge2.matches( regex ) );
		
		//Challenge 3
		regex = "I want a \\w+.";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(challenge1);
		System.out.println(matcher.matches());
		matcher = pattern.matcher(challenge2);
		System.out.println(matcher.matches());
		
		//Challenge 4
		String challenge4 = "Replace all blanks with underscores.";
		System.out.println( challenge4.replaceAll( "\\s", "_") );
		
		//Challenge 5, 6
		String challenge5 = "aaabccccccccdddefffg";
		System.out.println( challenge5.matches( "^a{3}bc{8}d{3}ef{3}g$" ) );
		
		//Challenge 7
		String challenge7 = "kjisl.22";
		System.out.println( challenge7.matches("[a-zA-Z]+\\.[0-9]+") );
		
		//Challenge 8
		String challenge8 = "abcd.135uvqz.7tzik.999";
		pattern = Pattern.compile( "([a-zA-Z]+)\\.([0-9]+)" );
		matcher = pattern.matcher(challenge8);
		while ( matcher.find() ) {
			System.out.println( matcher.group(2) );
		}
		
		//Challenge 9
		String challenge9 = "abcd.135\tuvqz.7\ttzik.999\n";
		pattern = Pattern.compile( "([a-zA-Z]+)\\.([0-9]+)?\\s" );
		matcher = pattern.matcher(challenge9);
		while ( matcher.find() ) {
			System.out.println( matcher.group(2) );
		}
		
		//Challenge 10
		matcher.reset();
		while ( matcher.find() ) {
			System.out.println( matcher.group(2)+ " - ( " +matcher.start(2)+ " - " +(matcher.end(2)-1)+ " )");
		}
		
		//Challenge 11
		String challenge11 = "{0, 2}, {0, 5}, {11, 3}, {2, 4}";
		pattern = Pattern.compile( "\\{(\\d+, \\d+)\\}" );
		matcher = pattern.matcher(challenge11);
		while ( matcher.find() ) {
			System.out.println( matcher.group(1) );
		}
		
		//Challenge 12
		String challenge12 = "11111";
		System.out.println( challenge12.matches("^\\d{5}$") );
		
		//Challenge 13
		String challenge13 = "11111-1111";
		System.out.println( challenge13.matches("^\\d{5}-\\d{4}$") );
		
		//Challenge 14
		regex = "^\\d{5}(-\\d{4})?$";
		System.out.println( challenge12.matches(regex) );
		System.out.println( challenge13.matches(regex) );
		
	}

}













