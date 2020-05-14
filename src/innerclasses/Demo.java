package innerclasses;

public class Demo {

	public static void main(String[] args) {
		
		A.B.C c = new A().new B().new C();//nasty code
		c.imprimir();
	}

}

class A{
	
	class B{
		
		class C{
			C(){
				System.out.println("This code is very ugly");
			}
			public void imprimir() {
				System.out.println("Nao faca isso nos teus codigos");
			}
		}
	}
}