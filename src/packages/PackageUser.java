package packages;

import static mz.co.ben.matematica.Series.nSum;
import static mz.co.ben.matematica.Series.fibonacci;
import static mz.co.ben.matematica.Series.factorial;

public class PackageUser {

	public static void main(String[] args) {
		
		int n = 1;
		System.out.println( nSum(n) );
		System.out.println( factorial(n) );
		System.out.println( fibonacci(n) );
	}
}
