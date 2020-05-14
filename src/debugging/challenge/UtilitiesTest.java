package debugging.challenge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtilitiesTest {
	
	private Utilities utilities;
	
	
	@Before
	public void setup() {
		utilities = new Utilities();
	}
	
	
	@Test
	public void everyNthChar() {
		assertArrayEquals( "hello".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 6) );
		assertArrayEquals( "h".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 0) );
		assertArrayEquals( "hello".toCharArray(), utilities.everyNthChar("hello".toCharArray(), 6) );
	}

	@Test
	public void removePairs() {
		assertEquals( "ABCABDEF", utilities.removePairs( "ABCCABDEEF" ) );
		assertEquals( "ABCDEF", utilities.removePairs( "AABCDDEFF" ) );
		assertEquals( "A", utilities.removePairs( "AAAA" ) );
		assertEquals( "A", utilities.removePairs( "A" ) );
		assertEquals( "ABA", utilities.removePairs( "ABBA" ) );
		assertEquals( "ABCA", utilities.removePairs( "ABBCCCA" ) );
		assertNull( "Nao retornou null quando tentou remover null", utilities.removePairs( null ) );
	}

	@Test
	public void converter() {
		assertEquals( 300, utilities.converter( 10, 5 ) );
	}

	@Test ( expected=ArithmeticException.class )
	public void converterDevideByZero() {
		utilities.converter( 10, 0 );
	}

	@Test
	public void nullIfOddLength() {
		assertNotNull( utilities.nullIfOddLength( "hello!" ) );
		assertNull( utilities.nullIfOddLength( "hello" ) );
	}

}
