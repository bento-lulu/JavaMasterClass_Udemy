package lambdas;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMain {

	public static void main(String[] args) {
		Employee neto = new Employee( "Neto", 23 );
		Employee andre = new Employee( "Andre", 36 );
		Employee liam = new Employee( "Liam", 3 );
		Employee aarao = new Employee( "Aarao", 65 );
		Employee ben = new Employee( "Ben", 29 );
		
		List<Employee> employees = new ArrayList<>();
		employees.add(neto);
		employees.add(andre);
		employees.add(liam);
		employees.add(aarao);
		employees.add(ben);
		
		//Expressao lambda com dois parametros, implementando o metodo
		//public int compareTo( Object obj1, Object obj2 ){}
		//Nem precisa por o tipo de dado neste caso, pois o compilador ja sabe que vamos sortear
		//uma lista de Employee
		employees.sort( (employee1, employee2) ->
				employee1.getNome().compareTo( employee2.getNome() )
				//nao precisa ter return, pois o compilador vai calcular a expressao e retornar automagicamente
		);
		
		/*
		for ( Employee employee : employees ) {
			System.out.printf( "%s com %d anos\n", employee.getNome(), employee.getIdade() );
		}*/
		
		//foreach com lambda expression, o mesmo que o de cima
		employees.forEach( employee ->{
				System.out.printf( "%s com %d anos\n", employee.getNome(), employee.getIdade() );
			}
		);
		
		
		String sillyString = concat( (str1, str2)->
			str1.toUpperCase() + str2.toUpperCase()
		, neto.getNome(), andre.getNome() );
		
		System.out.println( sillyString );
	}

	
	
	public static String concat( UpperConcat uc, String str1, String str2 ) {
		return uc.upperAndConcat(str1, str2);
	}
	
}





class Employee{
	private String nome;
	private int idade;
	
	public Employee( String nome, int idade ) {
		this.nome = nome;
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}


interface UpperConcat{
	public String upperAndConcat( String str1, String str2 );
}


