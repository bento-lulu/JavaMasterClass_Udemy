package lambdas.streams;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String nome;
	private List<Employee> employees;
	
	public Department( String nome ) {
		this.nome = nome;
		employees = new ArrayList<Employee>();
	}
	
	public void addEmployee( Employee employee ){
		employees.add( employee );
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
}
