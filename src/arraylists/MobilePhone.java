package arraylists;

import java.util.ArrayList;

public class MobilePhone {
	
	private ArrayList<Contact> lista;
	
	public MobilePhone() {
		lista = new ArrayList<Contact>();
	}
	
	public void store( Contact contact ) {
		lista.add(contact);
	}
	
	public void modify( Contact old_contact, Contact contact ) {
		int posicao = lista.indexOf(old_contact);
		
		if ( posicao < 0 ) {
			System.out.println( "Nao existe um contacto com o nome: " +old_contact.getName() );
		}
		
		lista.set( posicao, contact );
		System.out.println( "Contacto modificado com sucesso" );
	}
	
	
	public void remove( Contact contact ) {
		int posicao = lista.indexOf(contact);
		
		if ( posicao < 0) {
			System.out.println( "Nao existe um contacto com o nome: " +contact.getName() );
		}
		
		lista.remove(posicao);
		System.out.println( "Contacto removido com sucesso" );
	}
	
	
	public int query( String name ) {
		Contact contact = new Contact(name, "");
		int posicao = lista.indexOf(contact);
		
		if ( posicao < 0) {
			System.out.println( "Nao existe um contacto com o nome: " +contact.getName() );
			return -1;
		}
		System.out.println( "Contacto encontrado na posicao: " +posicao );
		return posicao;
	}
	
	
	public void imprimirLista() {
		for ( int i=0; i<lista.size(); i++) {
			System.out.println(i+ ". " +lista.get(i).getName()+ " (" +lista.get(i).getContact()+ ")");
		}
	}
	
	
}
