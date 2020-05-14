package lambdas.functional_package;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Main {

	public static void main(String[] args) {
		Employee neto = new Employee( "Neto Augusto", 23 );
		Employee andre = new Employee( "Andre Arendse", 36 );
		Employee liam = new Employee( "Liam Willy", 3 );
		Employee aarao = new Employee( "Aarao Uaquico", 65 );
		Employee ben = new Employee( "Ben Lulu", 29 );
		
		List<Employee> employees = new ArrayList<>();
		employees.add(neto);
		employees.add(andre);
		employees.add(liam);
		employees.add(aarao);
		employees.add(ben);
		
		employees.forEach( employee ->{
			System.out.printf( "%s com %d anos\n", employee.getNome(), employee.getIdade() );
		});
		
		printEmployeeByAge( employees, "Employees over 30", employee-> employee.getIdade()>30 );
		printEmployeeByAge( employees, "Employees 30 or under", employee-> employee.getIdade()<=30 );
		
		//Podemos faze tambem com classe anonima
		printEmployeeByAge( employees, "Employees younger than 25", new Predicate<Employee>() {
			@Override
			public boolean test(Employee employee) {
				return employee.getIdade() < 25;
			}
		});
		
		
		//Anyway, Predicate is super fuckin powerfull
		
		
		Function<Employee, String> upperCaser = employee -> employee.getNome().toUpperCase();
		Function<String, String> getFirstName = name -> name.substring( 0, name.indexOf(' ') );
		Function<String, String> getLastName = name -> name.substring( name.lastIndexOf(' ')+1 );
		Consumer<String> namePrinter = nome -> System.out.println(nome);
		
		System.out.println("##############################");
		Employee bento = new Employee( "Bento Lulu Aarao", 29);
		namePrinter.accept( getFirstName.apply( upperCaser.apply( bento ) ) );
		namePrinter.accept( getLastName.apply( upperCaser.apply( bento ) ) );
		
		
		Function<Employee, String> chainedFunction = upperCaser.andThen(getFirstName);
		namePrinter.accept( chainedFunction.apply( bento ) );
		
		
		//Intefaces de funcoes que aceitam dois parametros
		//BiConsumer<T, U>, BiFunction<T, U, R>, BiPredicate<T, U>
		//Exemplo com BiFunction, o ultimo tipo e do seu retorno
		BiFunction<String, String, String> username = (firstName, lastName)->
										firstName.substring(0, 1).toLowerCase().concat(lastName.toLowerCase());
		System.out.println( username.apply( "Wiliam", "Bento" ) );
		System.out.println( username.apply( "Augusto", "Aarao" ) );
		System.out.println( username.apply( "Chimilzi", "Chipa" ) );
		
		
		//Operacoes unarias (UnaryOperator) aceitam um tipo de input e retornam o mesmo tipo
		//UnaryOperator<T> - generico
		//IntUnaryOperator, DoubleUnaryOperator, LongUnaryOperator
		//Versoes especificas para tipos existem tambem para outras interfaces do pacote functions:
		//IntFunction, DoubleFunction, LongFunction
		//IntConsumer, DoubleFunction<Retorno>, LongSupplier, LongToIntFunction, BooleanSupplier
		IntUnaryOperator doubro = numero -> numero*2;
		IntUnaryOperator quadrado = numero -> numero*numero;
		IntUnaryOperator doubroDoQuadrado = quadrado.andThen(doubro);
		System.out.println( doubroDoQuadrado.applyAsInt( 3 ) );
		IntUnaryOperator quadradoDoDoubro = doubro.andThen( quadrado );
		System.out.println( quadradoDoDoubro.applyAsInt( 3 ) );
		
	}
	
	private static void printEmployeeByAge( List<Employee> employees, String ageText, Predicate<Employee> predicate ) {
		System.out.println(ageText);
		System.out.println("================================");
		for ( Employee employee: employees ) {
			if ( predicate.test(employee) ) {
				System.out.println( employee.getNome() );
			}
		}
	}
	
	

}


/*
 * Five types of functional interfaces
Supplier<T> - no parameter, but produces a result/return of type T
Consumer<T> - receives a parameter of type T, but does not produce a result/no return
Function<T,R> - receives a parameter of type T and produces a result/return of type R
UnaryOperator<T> - receives a parameter of type T and produces a result/return of the same type
Predicate<T> - receives a parameter of type T and produces a result/return of type boolean
 * */



