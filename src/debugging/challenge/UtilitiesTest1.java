package debugging.challenge;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith( Parameterized.class)
public class UtilitiesTest1 {
	
	private Utilities utilities;

	private String value;
	private String expected;
	
	public UtilitiesTest1( String value, String expected ) {
		this.value = value;
		this.expected = expected;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> testData(){
		List<Object[]> data = new ArrayList<>();
		data.add( new Object[] { "ABCDEFF", "ABCDEF" } );
		data.add( new Object[] { "AB88EFFG", "AB8EFG" } );
		data.add( new Object[] { "112233445566", "123456" } );
		data.add( new Object[] { "ZYZQQB", "ZYZQB" } );
		data.add( new Object[] { "A", "A" } );
		
		return data;
	}
	
	@Before
	public void initialize() {
		utilities = new Utilities();
	}
	
	@Test
	public void removePairs() {
		assertEquals( this.expected, utilities.removePairs(this.value) );
	}
}








