package generics;

public class MetodoGenerico {
	
	public static void main(String[] args) {
		System.out.println( MetodoGenerico.<Integer, Double>soma( 5, 6.0 ) );
		System.out.println( MetodoGenerico.soma( 5, 6.0 ) );
	}
	
	public static < T1 extends Number, T2 extends Number > Number soma( T1 num1, T2 num2 ) {
		return num1.doubleValue() + num2.doubleValue();
	}
}
