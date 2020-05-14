package debugging.challenge;

public class Main {

	public static void main(String[] args) {
		Utilities utilities = new Utilities();
		String removed = utilities.removePairs( "ABCCABDEEF" );
		System.out.println(removed);
	}

}
