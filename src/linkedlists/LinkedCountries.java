package linkedlists;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedCountries {

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		LinkedList<String> paises = new LinkedList<String>();
		paises.add("Mocambique");
		paises.add("Inglaterra");
		paises.add("Brazil");
		paises.add("Mexico");
		paises.add("Costa Rica");
		
		ListIterator<String> iterator = paises.listIterator();
		
		boolean correr = true;
		boolean foi_frente = false;
		
		imprimirMenu();

		if( iterator.hasNext()) {
			System.out.println("Agora visitando " +iterator.next()+ "\n\n" );
			iterator.previous();
		}
		while( correr ) {
			System.out.print("> ");
			int escolha = scanner.nextInt();
			scanner.nextLine();//mover para nova linha para aceitar novas linhas de texto
			
			switch (escolha) {
			case 0:
				correr = false;
				System.out.println("Fim das viagens. Ate a proxima!");
				break;
			case 1:
				if(!foi_frente) {
					iterator.next();
					foi_frente = true;
				}
				if( iterator.hasNext()) {
					System.out.println("Agora visitando " +iterator.next() );
				} else {
					System.out.println("Ja esta no ultimo pais da lista");
				}
				break;
			case 2:
				if(foi_frente) {
					iterator.previous();
					foi_frente = false;
				}
				if( iterator.hasPrevious()) {
					System.out.println("Agora visitando " +iterator.previous() );
				} else {
					System.out.println("Ja esta no primeiro pais da lista");
				}
				break;
			}
		}
		
	}

	private static void imprimirMenu() {
		System.out.println("0. Terminar viagens\n" +
						   "1. Ir ao proximo pais\n" +
						   "2. Ir ao pais anterior\n");
	}

}
