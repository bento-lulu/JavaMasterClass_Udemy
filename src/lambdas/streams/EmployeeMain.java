package lambdas.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMain {

	public static void main(String[] args) {
		
		Employee john = new Employee("John Wick", 28);
		Employee jack = new Employee("Jack Reacher", 32);
		Employee david = new Employee("David Beckham", 38);
		Employee ton = new Employee("Ton Murdock", 25);
		
		Department hr = new Department("Human Resources");
		hr.addEmployee(david);
		hr.addEmployee(jack);
		hr.addEmployee(john);
		
		Department accounting = new Department("Accounting");
		accounting.addEmployee(ton);
		
		List<Department> departments = new ArrayList<>();
		departments.add(hr);
		departments.add(accounting);
		
		//Para percorrer lista dentro de lista, podemos usar flatmap()
		departments.stream().flatMap( department ->
									  department.getEmployees().stream()).forEach(
											  									  System.out::println);
		System.out.println("*********************");
		//Para pegar resultado de processamento de um Stream e guardar em uma lista, usamos o metodo collect()
		List<String> nomes = Arrays.asList("Abel", "Benson", "Carter", "Denilson", "Edu", "Fonthee");
		List<String> nomesLongos = nomes.stream()
										.filter( nome -> nome.length()>5)
										.collect(Collectors.toList());
		nomesLongos.forEach(System.out::println);
		
		List<String> nomesLongosEspecifico = nomes.stream()
												  .filter( nome -> nome.length()>5)
												  .collect( ArrayList::new, ArrayList::add, ArrayList::addAll );
		nomesLongosEspecifico.forEach(System.out::println);
		
		//Operacoes intermediarias de streams so sao percorridas se existir uma chamada a um Terminaml Operation 
		System.out.println("*******************");
		nomes.stream().filter( nome -> nome.length()>5)
					  .peek(System.out::println)
					  .sorted();
		
		
		
		
		
	}

}




