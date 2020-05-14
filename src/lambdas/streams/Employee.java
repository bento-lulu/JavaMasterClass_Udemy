package lambdas.streams;

public class Employee {
	
	private String nome;
	private int age;
	
	public Employee( String nome, int age ) {
		this.nome = nome;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}
	
}
