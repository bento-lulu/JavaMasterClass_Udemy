package debugging;

public class Main {

	public static void main(String[] args) {
		StringUtil util = new StringUtil();
		StringBuilder builder = new StringBuilder();
		
		while( builder.length() < 10 ) {
			util.addChar(builder, 'a');
		}
		System.out.println( builder.toString() );

	}

}

class StringUtil{
	private StringBuilder builder = new StringBuilder();
	private int counter;
	
	void addChar( StringBuilder builder, char a ) {
 		builder.append( a );
		counter++;
	}
}



