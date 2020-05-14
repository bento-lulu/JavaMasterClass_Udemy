package linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import arraylists.Contact;

public class Demo {
	
	public static void main(String[] args) {
		LinkedList<String> paises = new LinkedList<String>();
		paises.add( "Mocambique" );
		paises.add( "Inglaterra" );
		paises.add( "Brazil" );
		paises.add( "Espanha" );
		
		printList(paises);
		
		LinkedList<Contact> contacts = new LinkedList<Contact>();
		contacts.add( new Contact("A", "33"));
		contacts.add( new Contact("B", "44"));
		contacts.add( new Contact("C", "66"));
		
		System.out.println("");
		Iterator<Contact> i = contacts.iterator();
		while(i.hasNext()) {
			System.out.println("#" +i.next().getName());
		}
		
		System.out.println("\n");
		
		LinkedList<String> textos = new LinkedList<String>();
		adicionarEmOrdemAlfabetica(textos, "Abel");
		adicionarEmOrdemAlfabetica(textos, "Zero");
		adicionarEmOrdemAlfabetica(textos, "Paty");
		adicionarEmOrdemAlfabetica(textos, "Nemo");
		adicionarEmOrdemAlfabetica(textos, "Bomba");
		printList(textos);
		
	}
	
	
	public static void printList( LinkedList<String> list ) {
		Iterator<String> iterator = list.iterator();
		while( iterator.hasNext() ) {
			System.out.println("Agora visitando " +iterator.next());
		}
	}
	
	
	
	public static void adicionarEmOrdemAlfabetica( LinkedList<String> lists, String texto ) {
		ListIterator<String> iterator = lists.listIterator();
		
		while (iterator.hasNext()) {
			String str = (String) iterator.next();
			
			int comparacao = str.compareTo(texto);
			if ( comparacao == 0 ) {
				System.out.println("O texto " +texto+ " ja existe na lista!");
			}
			if ( comparacao > 0 ) {
				iterator.previous();
				iterator.add(texto);
				return;
			}
		}
		iterator.add(texto);
	}
	
	
	
}
