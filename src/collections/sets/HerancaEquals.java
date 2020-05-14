package collections.sets;

public class HerancaEquals {
	
	public static void main(String[] args) {
		HerancaEquals herancaEquals = new HerancaEquals();
		HerancaEquals.Animal animal1 = herancaEquals.new Animal("Pluto");
		Cao cao = herancaEquals.new Cao("Pluto");
		
		System.out.println("animal1(Pluto) e igual a cao(Pluto): " +animal1.equals(cao) );//retorna true
		//porque Cao(subclasse) e Animal(superclasse)
		
		System.out.println("cao(Pluto) e igual a animal1(Pluto): " +cao.equals(animal1) );//retorna false
		//porque Animal(superclasse) nao e Cao(subclasse)
		//Dai a necessidade de declarar o metodo equals da superclasse como final,
		//assim nao vai ser sobreescrito por nenhuma subclasse
		
		//A solucao esta no exemplo abaixo, das classes telefone e smartphone
		Phone phone1 = new HerancaEquals.Phone( "Huawei", "P10 Lite" );
		HerancaEquals.SmartPhone p10Lite = new SmartPhone( "Huawei", "P10 Lite" );
		
		System.out.println("phone1(P10 Lite) e igual a p10Lite(P10 Lite): " +phone1.equals(p10Lite) );//retorna true
		System.out.println("p10Lite(P10 Lite) e igual a phone1(P10 Lite): " +phone1.equals(p10Lite) );//retorna true
		
	}
	
	private class Animal{
		private String nome;
		
		public Animal( String nome ) {
			this.nome = nome;
		}
		
		public String getNome() {
			return nome;
		}
		
		@Override
		public boolean equals(Object obj) {
			if ( this == obj ) {
				return true;
			}
			if ( obj instanceof Animal ) {
				String nome = ((Animal)obj).getNome();
				return nome.equals( this.getNome() );
			}
			return false;
		}
	}
	
	private class Cao extends Animal{
		private Cao( String nome ) {
			super(nome);
		}
		
		@Override
		public boolean equals(Object obj) {//bad idea
			if ( this == obj ) {
				return true;
			}
			if( obj instanceof Cao ) {
				String nome = ( (Cao)obj ).getNome();
				return nome.equals(this.getNome());
			}
			return false;
		}
	}
	
	
	
	
	private static class Phone{
		private String marca;
		private String modelo;
		
		private Phone( String marca, String modelo ) {
			this.marca = marca;
			this.modelo = modelo;
		}
		public String getMarca() {
			return marca;
		}
		public String getModelo() {
			return modelo;
		}
		
		@Override
		public final boolean equals(Object obj) {//muito importante estar final e todo tipo de instancia de Phone sera igual
												 //se tiver a mesma marca e o mesmo modelo, independentemente do tipo de
												 //telefone da subclasse ( DumbPhone, SmartPhone, Fixo, ...)
			if ( this == obj ) {
				return true;
			}
			if ( obj instanceof Phone ) {
				Phone phone = (Phone)obj;
				return phone.getMarca().equals( this.getMarca() ) && phone.getModelo().equals( this.getModelo() );
			}
			
			return false;
		}
	}
	
	private static class SmartPhone extends Phone {
		SmartPhone( String marca, String modelo ){
			super(marca, modelo);
		}
		
		//nao e possivel sobreescrever o metodo equals, pois foi declarado final na superclasse
	}
	
}




